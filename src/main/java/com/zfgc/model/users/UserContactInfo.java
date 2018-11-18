package com.zfgc.model.users;

import com.zfgc.model.BaseZfgcModel;

public class UserContactInfo extends BaseZfgcModel{

	private Integer userContactSettingsId;
	private Integer usersId;
	
	private String skype;
	private String gtalk;
	private String facebook;
	private String psn;
	private String xboxLive;
	private String steam;
	private String nnid;
	
	private Boolean hideSkypeFlag;
	private Boolean hideGtalkFlag;
	private Boolean hideFacebookFlag;
	private Boolean hidePsnFlag;
	private Boolean hideXboxLiveFlag;
	private Boolean hideSteamFlag;
	private Boolean hideNnidFlag;
	
	private EmailAddress email;
	
	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getGtalk() {
		return gtalk;
	}

	public void setGtalk(String gtalk) {
		this.gtalk = gtalk;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getPsn() {
		return psn;
	}

	public void setPsn(String psn) {
		this.psn = psn;
	}

	public String getXboxLive() {
		return xboxLive;
	}

	public void setXboxLive(String xboxLive) {
		this.xboxLive = xboxLive;
	}

	public String getSteam() {
		return steam;
	}

	public void setSteam(String steam) {
		this.steam = steam;
	}

	public String getNnid() {
		return nnid;
	}

	public void setNnid(String nnid) {
		this.nnid = nnid;
	}

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

	public Integer getUserContactSettingsId() {
		return userContactSettingsId;
	}

	public void setUserContactSettingsId(Integer userContactSettingsId) {
		this.userContactSettingsId = userContactSettingsId;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public EmailAddress getEmail() {
		return email;
	}

	public void setEmail(EmailAddress email) {
		this.email = email;
	}
	
}