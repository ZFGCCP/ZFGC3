package com.zfgc.model;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zfgc.model.subscriptions.ThreadSubscription;
import com.zfgc.model.users.Users;

public abstract class BaseZfgcModel implements Comparable{
	private ZfgcValidationErrors errors = new ZfgcValidationErrors();

	public ZfgcValidationErrors getErrors() {
		return errors;
	}

	public void setErrors(ZfgcValidationErrors errors) {
		this.errors = errors;
	}
	
	protected String getUserTimeZone(){
		HttpServletRequest request = 
				((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		
		Users user = (Users) ((Authentication) request.getUserPrincipal()).getPrincipal();
		return user.getTimeZone();
	}
	
	protected Integer getUserId(){
		HttpServletRequest request = 
				((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		
		Users user = (Users) ((Authentication) request.getUserPrincipal()).getPrincipal();
		return user.getUsersId();
	}
	
	public abstract String getHMAC() throws Exception;
	public BaseZfgcModel copy(BaseZfgcModel other){return this;};
	
	@Override
	public int compareTo(Object other){return 0;}
}