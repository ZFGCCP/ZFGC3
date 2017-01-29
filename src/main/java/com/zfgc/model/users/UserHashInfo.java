package com.zfgc.model.users;

import com.zfgc.model.BaseZfgcModel;

public class UserHashInfo extends BaseZfgcModel{
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
	@Override
	public String getHMAC() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}