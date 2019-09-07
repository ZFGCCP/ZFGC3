package com.zfgc.model.users;

import com.zfgc.model.BaseZfgcModel;

public class UserEmailView extends BaseZfgcModel {

	 private Integer usersId;
	 private String loginName;
	 private String displayName;
	 private Integer emailAddressId;
	 private String emailAddress;
	 private Boolean activeFlag;
	
	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getEmailAddressId() {
		return emailAddressId;
	}

	public void setEmailAddressId(Integer emailAddressId) {
		this.emailAddressId = emailAddressId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}