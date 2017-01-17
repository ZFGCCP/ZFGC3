package com.zfgc.model;

public abstract class BaseZfgcModel{
	private ZfgcValidationErrors errors = new ZfgcValidationErrors();

	public ZfgcValidationErrors getErrors() {
		return errors;
	}

	public void setErrors(ZfgcValidationErrors errors) {
		this.errors = errors;
	}
	
	public abstract String getHMAC() throws Exception; 
}