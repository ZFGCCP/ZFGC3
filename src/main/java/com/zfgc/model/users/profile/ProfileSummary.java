package com.zfgc.model.users.profile;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.services.authentication.AuthenticationService;
import com.zfgc.util.time.ZfgcTimeUtils;

public class ProfileSummary extends BaseZfgcModel {
	private String loginName;
	private String displayName;
	private String primaryIp;
	private Integer primaryMemberGroupId;
	private Date dateRegistered;
	private String emailAddress;
	private Date lastLogin;
	private String personalText;
	private Integer gender;
	private Date birthDate;
	private String userTitle;
	private Boolean hideEmailFlag;
	private Boolean hideGenderFlag;
	private Boolean hideBirthDateFlag;
	private Boolean hideAgeFlag;
	private Integer timeOffset;
	private String avatarFilename;
	private String timeZone;
	
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
	public String getPrimaryIp() {
		return primaryIp;
	}
	public void setPrimaryIp(String primaryIp) {
		this.primaryIp = primaryIp;
	}
	public Integer getPrimaryMemberGroupId() {
		return primaryMemberGroupId;
	}
	public void setPrimaryMemberGroupId(Integer primaryMemberGroupId) {
		this.primaryMemberGroupId = primaryMemberGroupId;
	}
	public Date getDateRegistered() {
		return dateRegistered;
	}
	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}
	public String getDateRegisteredAsString() {
		if(dateRegistered == null){
			return null;
		}
		
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat();
		return sdf.format(dateRegistered);
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getLastLoginAsString() {
		if(lastLogin == null){
			return "";
		}
		
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat();
		return sdf.format(lastLogin);
	}
	public void setLastLoginAsString(Date lastLogin) {
		
	}
	public String getPersonalText() {
		return personalText;
	}
	public void setPersonalText(String personalText) {
		this.personalText = personalText;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getBirthDateAsString() {
		if(birthDate == null){
			return "";
		}
		
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat();
		return sdf.format(birthDate);
	}
	public String getUserTitle() {
		return userTitle;
	}
	public void setUserTitle(String userTitle) {
		this.userTitle = userTitle;
	}
	public Boolean getHideEmailFlag() {
		return hideEmailFlag;
	}
	public void setHideEmailFlag(Boolean hideEmailFlag) {
		this.hideEmailFlag = hideEmailFlag;
	}
	public Boolean getHideGenderFlag() {
		return hideGenderFlag;
	}
	public void setHideGenderFlag(Boolean hideGenderFlag) {
		this.hideGenderFlag = hideGenderFlag;
	}
	public Boolean getHideBirthDateFlag() {
		return hideBirthDateFlag;
	}
	public void setHideBirthDateFlag(Boolean hideBirthDateFlag) {
		this.hideBirthDateFlag = hideBirthDateFlag;
	}
	public Boolean getHideAgeFlag() {
		return hideAgeFlag;
	}
	public void setHideAgeFlag(Boolean hideAgeFlag) {
		this.hideAgeFlag = hideAgeFlag;
	}
	public Integer getTimeOffset() {
		return timeOffset;
	}
	public void setTimeOffset(Integer timeOffset) {
		this.timeOffset = timeOffset;
	}
	public String getAvatarFilename() {
		return avatarFilename;
	}
	public void setAvatarFilename(String avatarFilename) {
		this.avatarFilename = avatarFilename;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	
	@JsonIgnore
	public String getHMAC() throws Exception{
		return null;
				        
	}
	public String getYim() {
		return yim;
	}
	public void setYim(String yim) {
		this.yim = yim;
	}
	@Override
	public BaseZfgcModel copy(BaseZfgcModel other) {
		// TODO Auto-generated method stub
		return null;
	}
}
