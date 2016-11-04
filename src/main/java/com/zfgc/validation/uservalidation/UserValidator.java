package com.zfgc.validation.uservalidation;

import com.zfgc.model.users.Users;
import com.zfgc.rules.Rule;
import com.zfgc.validation.AbstractValidator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class UserValidator extends AbstractValidator<Users> {

	@Override
	public void validator(Users model) throws Exception {
		checkEmailFormat(model);
		checkEmailLength(model);
	}
	
	private void checkEmailFormat(Users model){
		if(model.getEmailAddress() != null &&
		   !model.getEmailAddress().getEmailAddress().equals("") &&
		   !Pattern.matches("^[a-zA-Z0-9_\\-\\.]+@[a-zA-Z0-9\\.]+\\.{1,1}[a-zA-Z]+$", model.getEmailAddress().getEmailAddress())){
			
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

}
