package com.zfgc.requiredfields.users;

import org.springframework.stereotype.Component;

import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.Users;
import com.zfgc.requiredfields.AbstractRequiredFieldsChecker;

@Component
public class AccountSettingsRequiredFieldsChecker extends AbstractRequiredFieldsChecker<Users>{

	@Override
	public void requiredFieldsCheck(Users model) throws ZfgcValidationException {
		//check email address
		checkRequiredFieldString(model.getUserContactInfo().getEmail().getEmailAddress(), "Email Address", "Email Address " + IS_REQUIRED_FIELD, model.getErrors().getRequiredFieldsErrors());
		
	}

	
}