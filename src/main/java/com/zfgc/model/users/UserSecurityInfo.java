package com.zfgc.model.users;

import com.zfgc.model.BaseZfgcModel;

public class UserSecurityInfo extends BaseZfgcModel{

	private String confirmNewPassword;
	private String newPassword;
	private Boolean hideBirthDateFlag;
	private Boolean hideGenderFlag;
	
	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Boolean getHideBirthDateFlag() {
		return hideBirthDateFlag;
	}

	public void setHideBirthDateFlag(Boolean hideBirthDateFlag) {
		this.hideBirthDateFlag = hideBirthDateFlag;
	}

	public Boolean getHideGenderFlag() {
		return hideGenderFlag;
	}

	public void setHideGenderFlag(Boolean hideGenderFlag) {
		this.hideGenderFlag = hideGenderFlag;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}