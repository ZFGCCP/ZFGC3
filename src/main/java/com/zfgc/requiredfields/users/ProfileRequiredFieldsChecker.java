package com.zfgc.requiredfields.users;

import org.springframework.stereotype.Component;

import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.UserProfileView;
import com.zfgc.requiredfields.AbstractRequiredFieldsChecker;

@Component
public class ProfileRequiredFieldsChecker extends AbstractRequiredFieldsChecker<UserProfileView>{

	@Override
	public void requiredFieldsCheck(UserProfileView model) throws ZfgcValidationException {
		checkRequiredField(model.getPersonalInfo().getBirthDate(),"Birth Date","Birth Date is a required field", model.getErrors().getRequiredFieldsErrors());
	}
	
}
