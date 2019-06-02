package com.zfgc.validation.uservalidation;

import org.springframework.stereotype.Component;

import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.UserProfileView;
import com.zfgc.validation.AbstractValidator;

@Component
public class AccountSettingsValidator extends AbstractValidator<UserProfileView>{

	@Override
	public void validator(UserProfileView model) throws RuntimeException {
		checkEmailFormat(model.getUserContactInfo().getEmail().getEmailAddress(), model);
		checkEmailLength(model.getUserContactInfo().getEmail().getEmailAddress(), model);
	}
}