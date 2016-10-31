package com.zfgc.model;

import java.util.ArrayList;
import java.util.List;

import com.zfgc.requiredfields.RequiredField;

public class ZfgcValidationErrors{
	private List<RequiredField> requiredFieldsErrors = new ArrayList<>();

	public List<RequiredField> getRequiredFieldsErrors() {
		return requiredFieldsErrors;
	}

	public void setRequiredFieldsErrors(List<RequiredField> requiredFieldsErrors) {
		this.requiredFieldsErrors = requiredFieldsErrors;
	}
	
	public Boolean hasErrors(){
		return requiredFieldsErrors.size() > 0;
	}
}