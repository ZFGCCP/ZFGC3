package com.zfgc.model;

import java.util.ArrayList;
import java.util.List;

import com.zfgc.requiredfields.RequiredField;
import com.zfgc.rules.Rule;

public class ZfgcValidationErrors{
	private List<RequiredField> requiredFieldsErrors = new ArrayList<>();
	private List<Rule> validationErrors = new ArrayList<>();
	private List<Rule> ruleErrors = new ArrayList<>();

	private List<String> generalErrors = new ArrayList<>();
	private List<String> generalWarnings = new ArrayList<>();
	
	public List<Rule> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(List<Rule> validationErrors) {
		this.validationErrors = validationErrors;
	}

	public List<Rule> getRuleErrors() {
		return ruleErrors;
	}

	public void setRuleError(List<Rule> ruleErrors) {
		this.ruleErrors = ruleErrors;
	}

	public List<RequiredField> getRequiredFieldsErrors() {
		return requiredFieldsErrors;
	}

	public void setRequiredFieldsErrors(List<RequiredField> requiredFieldsErrors) {
		this.requiredFieldsErrors = requiredFieldsErrors;
	}
	
	public Boolean hasErrors(){
		return requiredFieldsErrors.size() > 0 || validationErrors.size() > 0 || ruleErrors.size() > 0 || generalErrors.size() > 0;
	}

	public List<String> getGeneralWarnings() {
		return generalWarnings;
	}

	public void setGeneralWarnings(List<String> generalWarnings) {
		this.generalWarnings = generalWarnings;
	}

	public List<String> getGeneralErrors() {
		return generalErrors;
	}

	public void setGeneralErrors(List<String> generalErrors) {
		this.generalErrors = generalErrors;
	}
}