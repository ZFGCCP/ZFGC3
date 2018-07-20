package com.zfgc.exception.security;

public class ZfgcUnauthorizedException extends ZfgcSecurityException{

	public ZfgcUnauthorizedException() {
		super("You are unauthorized to access this resource.");
	}
	
}