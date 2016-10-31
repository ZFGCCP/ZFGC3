package com.zfgc.model.users;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Users {
	private String password;
	
	private String usersId;
	private String displayName;
	private String loginName;
	
	@JsonIgnore
	private UserHashInfo userHashInfo;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public UserHashInfo getUserHashInfo() {
		return userHashInfo;
	}
	public void setUserHashInfo(UserHashInfo userHashInfo) {
		this.userHashInfo = userHashInfo;
	}
	
}
