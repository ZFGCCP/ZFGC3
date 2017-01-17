package com.zfgc.requiredfields;

import java.util.List;

import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.model.BaseZfgcModel;

public abstract class AbstractRequiredFieldsChecker<T extends BaseZfgcModel> {
	protected final String IS_REQUIRED_FIELD = " is required";
	
	public abstract void requiredFieldsCheck(T model) throws ZfgcValidationException;
	
	protected <V> void checkRequiredField(V field, String fieldName, String errorMessage, List<RequiredField> errors ){
		if(field == null){
			RequiredField requiredField = new RequiredField();
			requiredField.setErrorMessage(errorMessage);
			requiredField.setFieldName(fieldName);
			errors.add(requiredField);
		}
	}
	
	protected void checkErrorsFound(String typeName, T model) throws ZfgcValidationException{
		if(model.getErrors().getRequiredFieldsErrors().size() > 0){
			throw new ZfgcValidationException(typeName);
		}
	}
}