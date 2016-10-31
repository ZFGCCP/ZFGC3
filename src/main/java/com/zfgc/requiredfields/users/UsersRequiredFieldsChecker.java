package com.zfgc.requiredfields.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.Users;
import com.zfgc.requiredfields.AbstractRequiredFieldsChecker;

@Component
public class UsersRequiredFieldsChecker extends AbstractRequiredFieldsChecker{

	@Override
	public void requiredFieldsCheck(BaseZfgcModel model) {
		Users userModel = (Users)model;
		
		checkRequiredField(userModel.getLoginName(), "loginName", "Username" + IS_REQUIRED_FIELD, userModel.getErrors().getRequiredFieldsErrors());
		checkRequiredField(userModel.getDisplayName(), "displayName", "Display name" + IS_REQUIRED_FIELD, userModel.getErrors().getRequiredFieldsErrors());
		checkRequiredField(userModel.getPassword(), "password", "Password" + IS_REQUIRED_FIELD, userModel.getErrors().getRequiredFieldsErrors());
		checkRequiredField(userModel.getEmailAddress(), "emailAddress", "Email Address" + IS_REQUIRED_FIELD, userModel.getErrors().getRequiredFieldsErrors());
	}
	
}