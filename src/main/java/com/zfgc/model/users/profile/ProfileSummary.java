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
	private String gender;
	private Date birthDate;
	private String userTitle;
	private Boolean hideEmailFlag;
	private Boolean hideGenderFlag;
	private Boolean hideBirthDateFlag;
	private Boolean hideAgeFlag;
	private Integer timeOffset;
	private String avatarFilename;
	private String timeZone;
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
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
		String classAsString = loginName + 
				               displayName +
				               primaryIp +
				               (primaryMemberGroupId + "") +
				               getDateRegisteredAsString() +
				               emailAddress +
				               getLastLoginAsString() +
				               personalText +
				               gender +
				               getBirthDateAsString() +
				               userTitle +
				               hideEmailFlag +
				               hideGenderFlag +
				               hideBirthDateFlag +
				               hideAgeFlag +
				               (timeOffset + "") +
				               avatarFilename +
				               timeZone;
		
		String HMAC = AuthenticationService.generateSha256(classAsString);
		return HMAC;
	}
}
