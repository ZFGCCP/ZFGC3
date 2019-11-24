package com.zfgc.requiredfields.passwordreset;

import org.springframework.stereotype.Component;

import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.model.users.NewPassword;
import com.zfgc.requiredfields.AbstractRequiredFieldsChecker;

@Component
public class PasswordResetRequiredFields extends AbstractRequiredFieldsChecker<NewPassword>{

	@Override
	public void requiredFieldsCheck(NewPassword model) throws ZfgcValidationException {
		checkRequiredField(model.getNewPassword(), "New Password" + IS_REQUIRED_FIELD, "You must enter a new password.", model.getErrors().getRequiredFieldsErrors());
		checkRequiredField(model.getConfirmPassword(), "Confirm Password" + IS_REQUIRED_FIELD, "You must confirm your new password.", model.getErrors().getRequiredFieldsErrors());
	}

}
