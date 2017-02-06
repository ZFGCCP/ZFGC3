package com.zfgc.rules;

import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.Users;


public abstract class AbstractRulesChecker<T extends BaseZfgcModel> {
	public abstract void rulesCheck(T model, Users user) throws Exception;
	
	protected void checkErrorsFound(String typeName, T model) throws ZfgcValidationException{
		if(model.getErrors().getRequiredFieldsErrors().size() > 0){
			throw new ZfgcValidationException(typeName);
		}
	}
}
