package com.zfgc.exception;

public class ZfgcValidationException extends Exception {
	private static final long serialVersionUID = 3L;
	private String modelName;
	private ZfgcValidationException(){}
	private String message = "Validation error on object of type ";

	public ZfgcValidationException(String modelName){
		this.modelName = modelName;
	}
	
	public ZfgcValidationException(String modelName, String customMessage){
		this.modelName = modelName;
		this.message = customMessage;
	}
	
	@Override
	public String getMessage(){
		return message + modelName;
	}
	
}
