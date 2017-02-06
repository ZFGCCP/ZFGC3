package com.zfgc.model.users;

import com.zfgc.model.BaseZfgcModel;

public class UserContactInfo extends BaseZfgcModel{

	private String skype;
	private String aim;
	private String gtalk;
	private String facebook;
	private String psn;
	private String xboxLive;
	private String steam;
	private String nnid;
	private String yim;
	
	private Boolean hideSkypeFlag;
	private Boolean hideAimFlag;
	private Boolean hideGtalkFlag;
	private Boolean hideFacebookFlag;
	private Boolean hidePsnFlag;
	private Boolean hideXboxLiveFlag;
	private Boolean hideSteamFlag;
	private Boolean hideNnidFlag;
	private Boolean hideYimFlag;
	
	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getAim() {
		return aim;
	}

	public void setAim(String aim) {
		this.aim = aim;
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

	public String getYim() {
		return yim;
	}

	public void setYim(String yim) {
		this.yim = yim;
	}

	public Boolean getHideSkypeFlag() {
		return hideSkypeFlag;
	}

	public void setHideSkypeFlag(Boolean hideSkypeFlag) {
		this.hideSkypeFlag = hideSkypeFlag;
	}

	public Boolean getHideAimFlag() {
		return hideAimFlag;
	}

	public void setHideAimFlag(Boolean hideAimFlag) {
		this.hideAimFlag = hideAimFlag;
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

	public Boolean getHideYimFlag() {
		return hideYimFlag;
	}

	public void setHideYimFlag(Boolean hideYimFlag) {
		this.hideYimFlag = hideYimFlag;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}