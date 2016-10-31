package com.zfgc.requiredfields;

import java.util.List;

import com.zfgc.model.BaseZfgcModel;

public abstract class AbstractRequiredFieldsChecker {
	protected final String IS_REQUIRED_FIELD = " is required";
	
	public abstract void requiredFieldsCheck(BaseZfgcModel model);
	
	protected <T> void checkRequiredField(T field, String fieldName, String errorMessage, List<RequiredField> errors ){
		if(field == null){
			RequiredField requiredField = new RequiredField();
			requiredField.setErrorMessage(errorMessage);
			requiredField.setFieldName(fieldName);
		}
	}
}