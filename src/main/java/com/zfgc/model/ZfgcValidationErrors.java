package com.zfgc.model;

import java.util.ArrayList;
import java.util.List;

import com.zfgc.requiredfields.RequiredField;

public class ZfgcValidationErrors{
	private List<RequiredField> requiredFieldsErrors = new ArrayList<>();
	private List<RequiredField> validationErrors = new ArrayList<>();
	private List<RequiredField> ruleErrors = new ArrayList<>();

	public List<RequiredField> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(List<RequiredField> validationErrors) {
		this.validationErrors = validationErrors;
	}

	public List<RequiredField> getRuleErrors() {
		return ruleErrors;
	}

	public void setRuleError(List<RequiredField> ruleErrors) {
		this.ruleErrors = ruleErrors;
	}

	public List<RequiredField> getRequiredFieldsErrors() {
		return requiredFieldsErrors;
	}

	public void setRequiredFieldsErrors(List<RequiredField> requiredFieldsErrors) {
		this.requiredFieldsErrors = requiredFieldsErrors;
	}
	
	public Boolean hasErrors(){
		return requiredFieldsErrors.size() > 0 || validationErrors.size() > 0 || ruleErrors.size() > 0;
	}
}