package com.zfgc.requiredfields.users;

import org.springframework.stereotype.Component;

import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.UserProfileView;
import com.zfgc.requiredfields.AbstractRequiredFieldsChecker;
import com.zfgc.requiredfields.RequiredField;

@Component
public class AccountSettingsRequiredFieldsChecker extends AbstractRequiredFieldsChecker<UserProfileView>{

	@Override
	public void requiredFieldsCheck(UserProfileView model) throws ZfgcValidationException {
		//check email address
		checkRequiredFieldString(model.getUserContactInfo().getEmail().getEmailAddress(), "Email Address", "Email Address " + IS_REQUIRED_FIELD, model.getErrors().getRequiredFieldsErrors());
	
		//check password fields
		RequiredField newPassword = checkRequiredFieldStringOr(model.getUserSecurityInfo().getNewPassword(), "New Password","New Password is required.", model.getErrors().getRequiredFieldsErrors());
		RequiredField confirmPassword = checkRequiredFieldStringOr(model.getUserSecurityInfo().getConfirmNewPassword(), "Confirm Password","You must confirm your new password.",model.getErrors().getRequiredFieldsErrors());
		RequiredField currentPassword = checkRequiredFieldStringOr(model.getUserSecurityInfo().getCurrentPassword(), "Current Password","You must confirm your current password when changing your password.",model.getErrors().getRequiredFieldsErrors());
		
		xor(model.getErrors().getRequiredFieldsErrors(), newPassword, confirmPassword, currentPassword);
	}

	
}