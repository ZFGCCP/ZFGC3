package com.zfgc.model.users;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.zfgc.dataprovider.IpDataProvider;
import com.zfgc.dataprovider.UsersDataProvider;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.avatar.Avatar;
import com.zfgc.model.users.profile.NotificationSettings;
import com.zfgc.model.users.profile.PersonalMessagingSettings;
import com.zfgc.util.time.ZfgcTimeUtils;

@Component
public class Users extends BaseZfgcModel {
	@Autowired
	@JsonIgnore
	private HttpServletRequest request;
	
	@Autowired
	@JsonIgnore
	private UsersDataProvider usersDataProvider;
	
	@Autowired
	@JsonIgnore
	private IpDataProvider ipDataProvider;
	
	private String password;
	private Integer ttlLogin;
	
	private Integer usersId;
	private String displayName;
	private String loginName;
	private Date dateRegistered;
	private Boolean activeFlag = null;
	private Date birthDate;
	private Integer gender;

	private Date lockedUntil;
	private Date loginFailedAttempts;
	private Integer timeOffset;
	private String location;
	private Boolean agreeToTermsFlag = false;
	private List<Integer> memberGroups = new ArrayList<>();
	private Integer primaryMemberGroupId = 0;
	private String personalText;
	private String customTitle;
	private String websiteTitle;
	private String websiteUrl;
	
	private IpAddress primaryIpAddress = new IpAddress();
	private List<IpAddress> secondaryIpAddresses = new ArrayList<>();
	
	private EmailAddress emailAddress;
	private Boolean hideEmailFlag;
	private String signature;
	private String signaturePreview;
	
	private UserContactInfo contactInfo = new UserContactInfo();
	private UserSecurityInfo securityInfo = new UserSecurityInfo();
	private NotificationSettings notificationSettings = new NotificationSettings();
	private PersonalMessagingSettings personalMessagingSettings = new PersonalMessagingSettings();
	private Avatar avatar;
	
	private String authToken;
	
	@JsonIgnore
	private String timeOffsetLkup;
	
	@JsonIgnore
	private UserHashInfo userHashInfo = new UserHashInfo();
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUsersId() {
		if(usersId == null){
			return usersDataProvider.getUsersIdByToken(request.getHeader("authorization"));
		}
		
		return usersId;
	}
	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getLoginName() {
		if(request != null && request.getHeader("authorization") != null && (loginName == null || loginName.equals(""))){
			return usersDataProvider.getLoginNameByToken(request.getHeader("authorization"));
		}
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	@JsonIgnore
	public UserHashInfo getUserHashInfo() {
		return userHashInfo;
	}
	public void setUserHashInfo(UserHashInfo userHashInfo) {
		this.userHashInfo = userHashInfo;
	}
	public Date getDateRegistered() {
		return dateRegistered;
	}
	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}
	public Boolean getActiveFlag() {
		if(request != null && request.getHeader("authorization") != null && activeFlag == null){
			return usersDataProvider.getActiveFlagByToken(request.getHeader("authorization"));
		}
		
		return activeFlag;
	}
	public void setActiveFlag(Boolean isActiveFlag) {
		this.activeFlag = isActiveFlag;
	}
	public IpAddress getPrimaryIpAddress() {
		if(request != null && request.getHeader("authorization") != null && primaryIpAddress == null){
			return ipDataProvider.getPrimaryIpByToken(request.getHeader("authorization"));
		}
		return primaryIpAddress;
	}
	public void setPrimaryIpAddress(IpAddress primaryIpAddress) {
		this.primaryIpAddress = primaryIpAddress;
	}
	public List<IpAddress> getSecondaryIpAddresses() {
		return secondaryIpAddresses;
	}
	public void setSecondaryIpAddresses(List<IpAddress> secondaryIpAddresses) {
		this.secondaryIpAddresses = secondaryIpAddresses;
	}
	public EmailAddress getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(EmailAddress emailAddress){
		this.emailAddress = emailAddress;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	//Date functions
	public void setBirthDateAsString(String birthDateAsString){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat();
		try {
			birthDate = sdf.parse(birthDateAsString);
		} catch (ParseException e) {
			e.printStackTrace();
			birthDate = null;
		}
	}
	public String getBirthDateAsString(){
		if(birthDate == null){
			return "";
		}
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat();
		return sdf.format(birthDate);
	}
	
	public void setDateRegisteredAsString(String dateRegisteredAsString){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat();
		try {
			dateRegistered = sdf.parse(dateRegisteredAsString);
		} catch (ParseException e) {
			e.printStackTrace();
			dateRegistered = null;
		}
	}
	public String getDateRegisteredAsString(){
		if(dateRegistered == null){
			return "";
		}
		
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat();
		return sdf.format(dateRegistered);
	}
	public Date getLoginFailedAttempts() {
		return loginFailedAttempts;
	}
	public void setLoginFailedAttempts(Date loginFailedAttempts) {
		this.loginFailedAttempts = loginFailedAttempts;
	}
	public Date getLockedUntil() {
		return lockedUntil;
	}
	public void setLockedUntil(Date lockedUntil) {
		this.lockedUntil = lockedUntil;
	}
	public String getLockedUntilAsString(){
		if(lockedUntil == null){
			return "";
		}
		
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat();
		return sdf.format(lockedUntil);
	}
	
	public void setLockedUntilAsString(String lockedUntilAsString){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat();
		try {
			lockedUntil = sdf.parse(lockedUntilAsString);
		} catch (ParseException e) {
			e.printStackTrace();
			dateRegistered = null;
		}
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public Integer getTtlLogin() {
		return ttlLogin;
	}
	public void setTtlLogin(Integer ttlLogin) {
		this.ttlLogin = ttlLogin;
	}
	public Integer getTimeOffset() {
		return timeOffset;
	}
	public void setTimeOffset(Integer timeOffset) {
		this.timeOffset = timeOffset;
	}
	public Long getAge(){
		Long age = null;
		
		if(timeOffsetLkup == null){
			return age;
		}
		
		Date today = ZfgcTimeUtils.getToday(timeOffsetLkup);
		
		if(birthDate != null){
			age = ZfgcTimeUtils.getYearsBetween(birthDate, today);
		}

		return age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Boolean getAgreeToTermsFlag() {
		return agreeToTermsFlag;
	}
	public void setAgreeToTermsFlag(Boolean agreeToTermsFlag) {
		this.agreeToTermsFlag = agreeToTermsFlag;
	}
	public String getTimeOffsetLkup() {
		return timeOffsetLkup;
	}
	public void setTimeOffsetLkup(String timeOffsetLkup) {
		this.timeOffsetLkup = timeOffsetLkup;
	}
	public List<Integer> getMemberGroups() {
		if(request != null && request.getHeader("authorization") != null && primaryIpAddress == null){
			return usersDataProvider.getMemberGroupsByToken(request.getHeader("authorization"));
		}
		
		return memberGroups;
	}
	public void setMemberGroups(List<Integer> memberGroups) {
		this.memberGroups = memberGroups;
	}
	public Integer getPrimaryMemberGroupId() {
		if(request != null && request.getHeader("authorization") != null && primaryIpAddress == null){
			return usersDataProvider.getPrimaryMemberGroupByToken(request.getHeader("authorization"));
		}
		
		return primaryMemberGroupId;
	}
	public void setPrimaryMemberGroupId(Integer primaryMemberGroupId) {
		this.primaryMemberGroupId = primaryMemberGroupId;
	}
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public UserContactInfo getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(UserContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	public UserSecurityInfo getSecurityInfo() {
		return securityInfo;
	}
	public void setSecurityInfo(UserSecurityInfo securityInfo) {
		this.securityInfo = securityInfo;
	}
	public Boolean getHideEmailFlag() {
		return hideEmailFlag;
	}
	public void setHideEmailFlag(Boolean hideEmailFlag) {
		this.hideEmailFlag = hideEmailFlag;
	}
	public Avatar getAvatar() {
		return avatar;
	}
	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getCustomTitle() {
		return customTitle;
	}
	public void setCustomTitle(String customTitle) {
		this.customTitle = customTitle;
	}
	public String getPersonalText() {
		return personalText;
	}
	public void setPersonalText(String personalText) {
		this.personalText = personalText;
	}
	public String getWebsiteUrl() {
		return websiteUrl;
	}
	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}
	public String getWebsiteTitle() {
		return websiteTitle;
	}
	public void setWebsiteTitle(String websiteTitle) {
		this.websiteTitle = websiteTitle;
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
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getSignaturePreview() {
		return signaturePreview;
	}
	public void setSignaturePreview(String signaturePreview) {
		this.signaturePreview = signaturePreview;
	}
}
