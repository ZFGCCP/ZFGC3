package com.zfgc.validation;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.Users;
import com.zfgc.rules.Rule;
import com.zfgc.services.lookups.LookupService;

public abstract class AbstractValidator<T extends BaseZfgcModel> {
	@Autowired
	protected LookupService lookupService;
	
	public abstract void validator(T model) throws RuntimeException;
	
	public final String EMAIL_FORMAT = "^(?!.*--)[a-zA-Z0-9_\\-\\.]+@[a-zA-Z0-9\\.]+\\.{1,1}[a-zA-Z]+$";
	public final String URL_FORMAT = "^(?!.*--)(https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
	
	//This is the first line of defense for sql injection
	public final String GENERAL_STRING_FORMAT = "^(?!.*--)[@a-zA-Z0-9\\.\\?_\\(\\)\\s-',:/]+$";
	public final String GENERAL_STRING_FORMAT_ALLOW_BLANK = "^(?!.*--)[@a-zA-Z0-9\\.\\?_\\(\\)\\s-',:/]*$";
	
	protected final String INVALID_CHARACTER_RULE = "_INVALID_CHARACTER";
	
	protected final String INVALID_CHARACTER_MESSAGE = " contains an invalid character.  Login Names may only contain alphanumeric and the following characters: .-_?()@";
	
	protected Rule createError(String ruleName, String errorMessage){
		Rule rule = new Rule();
		rule.setRuleName(ruleName);
		rule.setErrorMessage(errorMessage);
		return rule;
	}
	
	protected void checkStringFormat(T model, String input, String fieldName){
		if(input != null &&
		   !Pattern.matches(GENERAL_STRING_FORMAT, input)){
			Rule loginNameFormat = new Rule();
			loginNameFormat.setRuleName(fieldName.replace(' ', '_').toUpperCase() + "_INVALID_CHARACTER");
			loginNameFormat.setErrorMessage(fieldName + " contains an invalid character.  Login Names may only contain alphanumeric and the following characters: .-_?()@");
			model.getErrors().getValidationErrors().add(loginNameFormat);
		}
	}
	
	protected void checkStringFormatAllowBlank(T model, String input, String fieldName){
		if(input != null &&
		   !Pattern.matches(GENERAL_STRING_FORMAT_ALLOW_BLANK, input)){
			Rule loginNameFormat = new Rule();
			loginNameFormat.setRuleName(fieldName.replace(' ', '_').toUpperCase() + "_INVALID_CHARACTER");
			loginNameFormat.setErrorMessage(fieldName + " contains an invalid character.  Login Names may only contain alphanumeric and the following characters: .-_?()@");
			model.getErrors().getValidationErrors().add(loginNameFormat);
		}
	}
	
	protected void checkErrorsFound(String typeName, T model) throws ZfgcValidationException{
		if(model.getErrors().getValidationErrors().size() > 0){
			throw new ZfgcValidationException(typeName);
		}
	}

	protected void checkUrlFormat(BaseZfgcModel model, String url){
		checkUrlFormat(model, url, false);
	}
	
	protected void checkUrlFormat(BaseZfgcModel model, String url, Boolean allowBlank){
		if(!StringUtils.isEmpty(url) && !Pattern.matches(URL_FORMAT, url)){
			Rule urlFormatRule = new Rule();
			urlFormatRule.setRuleName("INVALID_URL_FORMAT");
			urlFormatRule.setErrorMessage("Url was not in the correct format.");
			model.getErrors().getValidationErrors().add(urlFormatRule);
		}
	}
	
	protected void checkEmailFormat(String email, BaseZfgcModel model){
		if(email != null &&
		   !Pattern.matches(GENERAL_STRING_FORMAT, email) ||
		   !Pattern.matches(EMAIL_FORMAT,email)){
			
			Rule emailFormatRule = new Rule();
			emailFormatRule.setRuleName("INVALID_EMAIL_FORMAT");
			emailFormatRule.setErrorMessage("Email address was not in the correct format.");
			
			model.getErrors().getValidationErrors().add(emailFormatRule);
		}
	}
	
	protected void checkEmailLength(String email, BaseZfgcModel model){
		if(email != null &&
		   !email.equals("") &&
		   email.length() > 254){
			
			Rule emailLengthRule = new Rule();
			emailLengthRule.setRuleName("EMAIL_LENGTH");
			emailLengthRule.setErrorMessage("Email address must not be greater than 254 characters.");
			
			model.getErrors().getValidationErrors().add(emailLengthRule);

		}
	}
	
	protected String sanitizeString(String theString) {
		theString = StringUtils.replace(theString, "<", "&lt;");
		theString = StringUtils.replace(theString, ">", "&gt;");
		theString = StringUtils.replace(theString, "\"", "&quot;");
		theString = StringUtils.replace(theString, "&", "&amp;");

		return theString;
	}
}
