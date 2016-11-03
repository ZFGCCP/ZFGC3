package com.zfgc.model.users;

import com.zfgc.model.BaseZfgcModel;

public class EmailAddress extends BaseZfgcModel{
	private String emailAddress;
	private Boolean isSpammerFlag = true;
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Boolean getIsSpammerFlag() {
		return isSpammerFlag;
	}
	public void setIsSpammerFlag(Boolean isSpammerFlag) {
		this.isSpammerFlag = isSpammerFlag;
	}
	
	
}