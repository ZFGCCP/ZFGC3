package com.zfgc.requiredfields.users;

import org.springframework.stereotype.Component;

import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.model.users.Users;
import com.zfgc.requiredfields.AbstractRequiredFieldsChecker;

@Component
public class ProfileRequiredFieldsChecker extends AbstractRequiredFieldsChecker<Users>{

	@Override
	public void requiredFieldsCheck(Users model) throws ZfgcValidationException {
		checkRequiredField(model.getPersonalInfo().getBirthDate(),"Birth Date","Birth Date is a required field", model.getErrors().getRequiredFieldsErrors());
	}
	
}
