package com.zfgc.requiredfields.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.Users;
import com.zfgc.requiredfields.AbstractRequiredFieldsChecker;

@Component
public class UsersRequiredFieldsChecker extends AbstractRequiredFieldsChecker<Users>{

	@Override
	public void requiredFieldsCheck(Users model) {

		checkRequiredField(model.getLoginName(), "loginName", "Username" + IS_REQUIRED_FIELD, model.getErrors().getRequiredFieldsErrors());
		checkRequiredField(model.getDisplayName(), "displayName", "Display name" + IS_REQUIRED_FIELD, model.getErrors().getRequiredFieldsErrors());
		checkRequiredField(model.getPassword(), "password", "Password" + IS_REQUIRED_FIELD, model.getErrors().getRequiredFieldsErrors());
		checkRequiredField(model.getEmailAddress(), "emailAddress", "Email Address" + IS_REQUIRED_FIELD,model.getErrors().getRequiredFieldsErrors());
		checkRequiredField(model.getBirthDate(), "birthDate", "Birth Date" + IS_REQUIRED_FIELD, model.getErrors().getRequiredFieldsErrors());
		checkRequiredField(model.getTimeOffset(), "timeOffset", "Timezone" + IS_REQUIRED_FIELD, model.getErrors().getRequiredFieldsErrors());
	}
	
}