package com.zfgc.model.users.profile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.UserContactInfo;
import com.zfgc.model.users.UserSecurityInfo;
import com.zfgc.util.time.ZfgcTimeUtils;

public class UserProfileView extends BaseZfgcModel {
	private Integer usersId;
	private String displayName;
	private String loginName;
	
	@JsonIgnore
	private Date dateRegistered;
	
	private ProfileSummary profileSummary = new ProfileSummary();
	private UserContactInfo userContactInfo = new UserContactInfo();
	private UserSecurityInfo userSecurityInfo = new UserSecurityInfo();
	private PersonalInfo personalInfo = new PersonalInfo();
	private NotificationSettings notificationSettings = new NotificationSettings();
	private PersonalMessagingSettings personalMessagingSettings = new PersonalMessagingSettings();
	private List<Buddy> buddyList = new ArrayList<>();
	private Avatar avatar = new Avatar();
	
	private Date lastLogin;
	private Boolean isOnlineFlag;
	private Boolean activeFlag;
	
	@JsonIgnore
	private UserProfileView savedProfile;
	
	public String getLastLoginAsString(){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateTimeFormat(super.getUserTimeZone());
		if(lastLogin == null){
			return "";
		}
		
		return sdf.format(lastLogin);
	}
	
	public UserProfileView getSavedProfile() {
		return savedProfile;
	}
	public void setSavedSummary(UserProfileView savedProfile) {
		this.savedProfile = savedProfile;
	}
	public Integer getUsersId() {
		return usersId;
	}
	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}
	public ProfileSummary getProfileSummary() {
		return profileSummary;
	}
	public void setProfileSummary(ProfileSummary profileSummary) {
		this.profileSummary = profileSummary;
	}
	@Override
	public String getHMAC() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public BaseZfgcModel copy(BaseZfgcModel other) {
		// TODO Auto-generated method stub
		return null;
	}
	public UserContactInfo getUserContactInfo() {
		return userContactInfo;
	}
	public void setUserContactInfo(UserContactInfo userContactInfo) {
		this.userContactInfo = userContactInfo;
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
	public Date getDateRegistered() {
		return dateRegistered;
	}
	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}
	public String getDateRegisteredAsString(){
		if(dateRegistered == null){
			return "";
		}
		
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat(super.getUserTimeZone());
		return sdf.format(dateRegistered);
	}
	public String getUserLocalTimeAsString(){
		Date now = new Date();
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateTimeFormat(super.getUserTimeZone());
		return sdf.format(now);
	}
	public Avatar getAvatar() {
		return avatar;
	}
	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}
	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}
	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}
	public UserSecurityInfo getUserSecurityInfo() {
		return userSecurityInfo;
	}
	public void setUserSecurityInfo(UserSecurityInfo userSecurityInfo) {
		this.userSecurityInfo = userSecurityInfo;
	}
	public NotificationSettings getNotificationSettings() {
		return notificationSettings;
	}
	public void setNotificationSettings(NotificationSettings notificationSettings) {
		this.notificationSettings = notificationSettings;
	}
	public PersonalMessagingSettings getPersonalMessagingSettings() {
		return personalMessagingSettings;
	}
	public void setPersonalMessagingSettings(PersonalMessagingSettings personalMessagingSettings) {
		this.personalMessagingSettings = personalMessagingSettings;
	}
	public List<Buddy> getBuddyList() {
		return buddyList;
	}
	public void setBuddyList(List<Buddy> buddyList) {
		this.buddyList = buddyList;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Boolean getIsOnlineFlag() {
		return isOnlineFlag;
	}

	public void setIsOnlineFlag(Boolean isOnlineFlag) {
		this.isOnlineFlag = isOnlineFlag;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	
}
