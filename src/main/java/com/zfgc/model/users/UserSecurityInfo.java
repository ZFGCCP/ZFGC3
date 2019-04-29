package com.zfgc.model.users;

import com.zfgc.model.BaseZfgcModel;

public class UserSecurityInfo extends BaseZfgcModel{

	private Integer userSecuritySettingsId;
	private String confirmNewPassword;
	private String newPassword;
	private String currentPassword;
	private Boolean hideBirthDateFlag = false;
	private Boolean hideGenderFlag = false;
	private Boolean hideSkypeFlag = false;
	private Boolean hideGtalkFlag = false;
	private Boolean hideFacebookFlag = false;
	private Boolean hidePsnFlag = false;
	private Boolean hideXboxLiveFlag = false;
	private Boolean hideSteamFlag = false;
	private Boolean hideNnidFlag = false;
	private Boolean hideEmailFlag = false;
	private Integer usersId;
	
	public Boolean getHideSkypeFlag() {
		return hideSkypeFlag;
	}

	public void setHideSkypeFlag(Boolean hideSkypeFlag) {
		this.hideSkypeFlag = hideSkypeFlag;
	}

	public Boolean getHideGtalkFlag() {
		return hideGtalkFlag;
	}

	public void setHideGtalkFlag(Boolean hideGtalkFlag) {
		this.hideGtalkFlag = hideGtalkFlag;
	}

	public Boolean getHideFacebookFlag() {
		return hideFacebookFlag;
	}

	public void setHideFacebookFlag(Boolean hideFacebookFlag) {
		this.hideFacebookFlag = hideFacebookFlag;
	}

	public Boolean getHidePsnFlag() {
		return hidePsnFlag;
	}

	public void setHidePsnFlag(Boolean hidePsnFlag) {
		this.hidePsnFlag = hidePsnFlag;
	}

	public Boolean getHideXboxLiveFlag() {
		return hideXboxLiveFlag;
	}

	public void setHideXboxLiveFlag(Boolean hideXboxLiveFlag) {
		this.hideXboxLiveFlag = hideXboxLiveFlag;
	}

	public Boolean getHideSteamFlag() {
		return hideSteamFlag;
	}

	public void setHideSteamFlag(Boolean hideSteamFlag) {
		this.hideSteamFlag = hideSteamFlag;
	}

	public Boolean getHideNnidFlag() {
		return hideNnidFlag;
	}

	public void setHideNnidFlag(Boolean hideNnidFlag) {
		this.hideNnidFlag = hideNnidFlag;
	}

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

	@Override
	public BaseZfgcModel copy(BaseZfgcModel other) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getUserSecuritySettingsId() {
		return userSecuritySettingsId;
	}

	public void setUserSecuritySettingsId(Integer userSecuritySettingsId) {
		this.userSecuritySettingsId = userSecuritySettingsId;
	}

	public Boolean getHideEmailFlag() {
		return hideEmailFlag;
	}

	public void setHideEmailFlag(Boolean hideEmailFlag) {
		this.hideEmailFlag = hideEmailFlag;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	
}