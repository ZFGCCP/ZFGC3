package com.zfgc.exception;

public class ZfgcNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private String resourceName;
	
	private ZfgcNotFoundException(){}
	public ZfgcNotFoundException(String resourceName){
		this.resourceName = resourceName;
	}
	
	@Override
	public String getMessage(){
		return resourceName + " could not be found.";
	}
	public String getResourceName() {
		return resourceName;
	}
	
	
	
}
