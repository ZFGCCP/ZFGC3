package com.zfgc.model.users;

public class UserHashInfo{
	private String password;
	private String passSalt;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassSalt() {
		return passSalt;
	}
	public void setPassSalt(String passSalt) {
		this.passSalt = passSalt;
	}
	
	
}