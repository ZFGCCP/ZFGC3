package com.zfgc.exception.security;

public class ZfgcSecurityException extends Exception{
	private ZfgcSecurityException(){}
	private String message = "";
	
	public ZfgcSecurityException(String message){
		this.message = message;
	}
	
	@Override
	public String getMessage(){
		return this.message;
	}
	
}
