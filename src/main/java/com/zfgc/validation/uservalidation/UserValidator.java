package com.zfgc.validation.uservalidation;

import com.zfgc.config.ZfgcGeneralConfig;
import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.model.users.Users;
import com.zfgc.rules.Rule;
import com.zfgc.services.lookups.LookupService;
import com.zfgc.validation.AbstractValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidator extends AbstractValidator<Users> {

	@Autowired
	private ZfgcGeneralConfig zfgcGeneralConfig;
	
	@Override
	public void validator(Users model) throws ZfgcValidationException {
		checkEmailFormat(model);
		checkEmailLength(model);
		checkLoginNameFormat(model);
		checkDisplayNameFormat(model);
		checkLocationFormat(model);
		checkTimeZoneValid(model);
		validateRecaptcha(model);
		
		//super.checkErrorsFound("Users", model);
	}
	
	private void validateRecaptcha(Users user) {
		boolean noError = false;
		try {
			
			URL url = new URL("https://www.google.com/recaptcha/api/siteverify?secret=" + zfgcGeneralConfig.getRecaptchaV2Key() + "&response=" + user.getgResponseToken());
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setFixedLengthStreamingMode(0);
			conn.setDoOutput(true);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			
			br.readLine();
			String output = br.readLine();
			
			br.close();

			noError = output.contains("\"success\": true");

		} catch (IOException ex) {
			ex.printStackTrace();
			noError = false;
		}
		
		if(!noError){
			Rule recaptchaFail = new Rule();
			recaptchaFail.setRuleName("RECAPTCHA_V2_FAIL");
			recaptchaFail.setErrorMessage("Recaptcha V2 verification failed. Please make sure you checked the box and answered the challenge.");
			user.getErrors().getValidationErrors().add(recaptchaFail);
		}
	}
	
	private void checkLoginNameFormat(Users model){
		checkStringFormat(model, model.getLoginName(), "Login Name");
	}
	
	private void checkDisplayNameFormat(Users model){
		checkStringFormat(model, model.getDisplayName(), "Display Name");
	}
	
	private void checkLocationFormat(Users model){
		checkStringFormatAllowBlank(model, model.getLocation(),"Location");
	}
	
	private void checkTimeZoneValid(Users model){
		if(model.getTimeOffset() != null &&
		  !lookupService.isLkupIdValid(LookupService.TIMEZONE, model.getTimeOffset())){
			Rule timeZoneInvalid = new Rule();
			timeZoneInvalid.setRuleName("INVALID_TIMEZONE");
			timeZoneInvalid.setErrorMessage("The selected timezone is not valid");
			model.getErrors().getValidationErrors().add(timeZoneInvalid);
		}
	}

}
