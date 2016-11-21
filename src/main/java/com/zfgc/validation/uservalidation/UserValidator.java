package com.zfgc.validation.uservalidation;

import com.zfgc.model.users.Users;
import com.zfgc.rules.Rule;
import com.zfgc.services.lookups.LookupService;
import com.zfgc.validation.AbstractValidator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class UserValidator extends AbstractValidator<Users> {

	@Override
	public void validator(Users model) throws Exception {
		checkEmailFormat(model);
		checkEmailLength(model);
		checkLoginNameFormat(model);
		checkDisplayNameFormat(model);
		checkLocationFormat(model);
		checkTimeZoneValid(model);
	}
	
	private void checkEmailFormat(Users model){
		if(model.getEmailAddress() != null &&
		   !Pattern.matches(GENERAL_STRING_FORMAT, model.getEmailAddress().getEmailAddress()) &&
		   !Pattern.matches(EMAIL_FORMAT, model.getEmailAddress().getEmailAddress())){
			
			Rule emailFormatRule = new Rule();
			emailFormatRule.setRuleName("INVALID_EMAIL_FORMAT");
			emailFormatRule.setErrorMessage("Email address was not in the correct format.");
			model.getErrors().getValidationErrors().add(emailFormatRule);
		}
	}
	
	private void checkEmailLength(Users model){
		if(model.getEmailAddress() != null &&
		   !model.getEmailAddress().getEmailAddress().equals("") &&
		   model.getEmailAddress().getEmailAddress().length() > 254){
			
			Rule emailLengthRule = new Rule();
			emailLengthRule.setRuleName("EMAIL_LENGTH");
			emailLengthRule.setErrorMessage("Email address must not be greater than 254 characters.");
			model.getErrors().getValidationErrors().add(emailLengthRule);
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
