package com.zfgc.requiredfields.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.model.users.Users;
import com.zfgc.requiredfields.AbstractRequiredFieldsChecker;
import com.zfgc.requiredfields.RequiredField;

@Component
public class UsersRequiredFieldsChecker extends AbstractRequiredFieldsChecker<Users>{

	@Override
	public void requiredFieldsCheck(Users model) throws ZfgcValidationException {

		checkRequiredField(model.getLoginName(), "loginName", "Username" + IS_REQUIRED_FIELD, model.getErrors().getRequiredFieldsErrors());
		checkRequiredField(model.getDisplayName(), "displayName", "Display name" + IS_REQUIRED_FIELD, model.getErrors().getRequiredFieldsErrors());
		checkRequiredField(model.getUserSecurityInfo().getNewPassword(), "password", "Password" + IS_REQUIRED_FIELD, model.getErrors().getRequiredFieldsErrors());
		checkRequiredField(model.getUserContactInfo().getEmail().getEmailAddress(), "emailAddress", "Email Address" + IS_REQUIRED_FIELD,model.getErrors().getRequiredFieldsErrors());
		checkRequiredField(model.getPersonalInfo().getBirthDate(), "birthDate", "Birth Date" + IS_REQUIRED_FIELD, model.getErrors().getRequiredFieldsErrors());
		checkRequiredField(model.getTimeOffset(), "timeOffset", "Timezone" + IS_REQUIRED_FIELD, model.getErrors().getRequiredFieldsErrors());
		checkRequiredField(model.getUserSecurityInfo().getConfirmNewPassword(), "Confirm Password" + IS_REQUIRED_FIELD,"You must confirm your password.",model.getErrors().getRequiredFieldsErrors());
		//super.checkErrorsFound("Users", model);
	}
	
}