package com.zfgc.validation;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.rules.Rule;
import com.zfgc.services.lookups.LookupService;

public abstract class AbstractValidator<T extends BaseZfgcModel> {
	@Autowired
	protected LookupService lookupService;
	
	public abstract void validator(T model) throws Exception;
	
	public final String EMAIL_FORMAT = "^(?!.*--)[a-zA-Z0-9_\\-\\.]+@[a-zA-Z0-9\\.]+\\.{1,1}[a-zA-Z]+$";
	
	//This is the first line of defense for sql injection
	public final String GENERAL_STRING_FORMAT = "^(?!.*--)[@a-zA-Z0-9\\.\\?_\\(\\)\\s-]+$";
	public final String GENERAL_STRING_FORMAT_ALLOW_BLANK = "^(?!.*--)[@a-zA-Z0-9\\.\\?_\\(\\)\\s-]*$";
	
	protected final String INVALID_CHARACTER_RULE = "_INVALID_CHARACTER";
	
	protected final String INVALID_CHARACTER_MESSAGE = " contains an invalid character.  Login Names may only contain alphanumeric and the following characters: .-_?()@";
	
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
}
