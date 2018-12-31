package com.zfgc.requiredfields;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

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
	
	protected <V> RequiredField checkRequiredFieldOr(V field, String fieldName, String errorMessage, List<RequiredField> errors ){
		if(field == null){
			RequiredField requiredField = new RequiredField();
			requiredField.setErrorMessage(errorMessage);
			requiredField.setFieldName(fieldName);
			return requiredField;
		}
		
		return null;
	}
	
	protected void checkRequiredFieldString(String field, String fieldName, String errorMessage, List<RequiredField> errors ){
		if(StringUtils.isEmpty(field)){
			RequiredField requiredField = new RequiredField();
			requiredField.setErrorMessage(errorMessage);
			requiredField.setFieldName(fieldName);
			errors.add(requiredField);
		}
	}
	
	protected RequiredField checkRequiredFieldStringOr(String field, String fieldName, String errorMessage, List<RequiredField> errors ){
		if(StringUtils.isEmpty(field)){
			RequiredField requiredField = new RequiredField();
			requiredField.setErrorMessage(errorMessage);
			requiredField.setFieldName(fieldName);
			return requiredField;
		}
		
		return null;
	}
	
	protected void checkRequiredFieldBoolean(Boolean field, String fieldName, String errorMessage, List<RequiredField> errors ){
		if(field == false){
			RequiredField requiredField = new RequiredField();
			requiredField.setErrorMessage(errorMessage);
			requiredField.setFieldName(fieldName);
			errors.add(requiredField);
		}
	}
	
	protected RequiredField checkRequiredFieldBooleanOr(Boolean field, String fieldName, String errorMessage, List<RequiredField> errors ){
		if(field == false){
			RequiredField requiredField = new RequiredField();
			requiredField.setErrorMessage(errorMessage);
			requiredField.setFieldName(fieldName);
			return requiredField;
		}
		
		return null;
	}
	
	protected void or(List<RequiredField> errors,RequiredField... fields){
		List<RequiredField> missedFields = new ArrayList<>();
		for(RequiredField field : fields){
			if(field == null){
				return;
			}
			missedFields.add(field);
		}
		
		errors.addAll(missedFields);
	}
	
	protected void and(List<RequiredField> errors, RequiredField... fields){
		List<RequiredField> missedFields = new ArrayList<>();
		for(RequiredField field : fields){
			if(field != null){
				missedFields.add(field);
			}
		}
		
		errors.addAll(missedFields);
	}
	
	protected void xor(List<RequiredField> errors, RequiredField... fields){
		int fieldSize = fields.length;
		int numberOfFieldsChanged = 0;
		List<RequiredField> missedFields = new ArrayList<>();
		for(RequiredField field : fields){
			if(field == null){
				numberOfFieldsChanged += 1;
			}
			else{
				missedFields.add(field);
			}
		}
		
		if(numberOfFieldsChanged > 0 && numberOfFieldsChanged < fieldSize){
			errors.addAll(missedFields);
		}
	}
	
	protected void checkErrorsFound(String typeName, T model) throws ZfgcValidationException{
		if(model.getErrors().getRequiredFieldsErrors().size() > 0){
			throw new ZfgcValidationException(typeName,model.getErrors());
		}
	}
}