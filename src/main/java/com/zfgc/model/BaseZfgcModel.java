package com.zfgc.model;

public class BaseZfgcModel{
	private ZfgcValidationErrors errors = new ZfgcValidationErrors();

	public ZfgcValidationErrors getErrors() {
		return errors;
	}

	public void setErrors(ZfgcValidationErrors errors) {
		this.errors = errors;
	}
}