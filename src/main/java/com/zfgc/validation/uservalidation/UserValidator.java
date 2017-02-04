package com.zfgc.validation.uservalidation;

import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.model.users.Users;
import com.zfgc.rules.Rule;
import com.zfgc.services.lookups.LookupService;
import com.zfgc.validation.AbstractValidator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class UserValidator extends AbstractValidator<Users> {

	@Override
	public void validator(Users model) throws ZfgcValidationException {
		checkEmailFormat(model);
		checkEmailLength(model);
		checkLoginNameFormat(model);
		checkDisplayNameFormat(model);
		checkLocationFormat(model);
		checkTimeZoneValid(model);
		
		super.checkErrorsFound("Users", model);
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
