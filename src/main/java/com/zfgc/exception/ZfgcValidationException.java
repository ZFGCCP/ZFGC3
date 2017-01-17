package com.zfgc.exception;

public class ZfgcValidationException extends Exception {
	private static final long serialVersionUID = 3L;
	private String modelName;
	private ZfgcValidationException(){}
	
	public ZfgcValidationException(String modelName){
		this.modelName = modelName;
	}
	
	@Override
	public String getMessage(){
		return "Validation error on object of type " + modelName;
	}
	
}
