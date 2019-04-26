package com.zfgc.exception;

import com.zfgc.model.ZfgcValidationErrors;

public class ZfgcValidationException extends RuntimeException {
	private static final long serialVersionUID = 3L;
	private String modelName;
	private ZfgcValidationException(){}
	private String message = "Validation error on object of type ";
	private ZfgcValidationErrors errors;

	public ZfgcValidationException(String modelName){
		this.modelName = modelName;
	}
	
	public ZfgcValidationException(String modelName, ZfgcValidationErrors errors){
		this.modelName = modelName;
		this.errors = errors;
	}
	
	public ZfgcValidationException(String modelName, String customMessage){
		this.modelName = modelName;
		this.message = customMessage;
	}
	
	@Override
	public String getMessage(){
		return message + modelName;
	}

	public ZfgcValidationErrors getErrors() {
		return errors;
	}

	public void setErrors(ZfgcValidationErrors errors) {
		this.errors = errors;
	}
	
}
