package com.zfgc.model;

import com.zfgc.model.subscriptions.ThreadSubscription;

public abstract class BaseZfgcModel implements Comparable{
	private ZfgcValidationErrors errors = new ZfgcValidationErrors();

	public ZfgcValidationErrors getErrors() {
		return errors;
	}

	public void setErrors(ZfgcValidationErrors errors) {
		this.errors = errors;
	}
	
	public abstract String getHMAC() throws Exception;
	public BaseZfgcModel copy(BaseZfgcModel other){return this;};
	
	@Override
	public int compareTo(Object other){return 0;}
}