package com.zfgc.validation.uservalidation;

import org.springframework.stereotype.Component;

import com.zfgc.model.users.Users;
import com.zfgc.validation.AbstractValidator;

@Component
public class AccountSettingsValidator extends AbstractValidator<Users>{

	@Override
	public void validator(Users model) throws RuntimeException {
		checkEmailFormat(model);
		checkEmailLength(model);
	}
}