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

	private Date lockedUntil;
	private Date loginFailedAttempts;
	private Integer timeOffset;
	private String location;
	private Boolean agreeToTermsFlag;
	
	private IpAddress primaryIpAddress = new IpAddress();
	private List<IpAddress> secondaryIpAddresses = new ArrayList<>();
	
	private EmailAddress emailAddress;
	private String authToken;
	
	@JsonIgnore
	private String timeOffsetLkup;
	
	@JsonIgnore
	private UserHashInfo userHashInfo = new UserHashInfo();
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUsersId() {
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
		if(loginName == null || loginName.equals("")){
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
		if(activeFlag == null){
			return usersDataProvider.getActiveFlagByToken(request.getHeader("authorization"));
		}
		
		return activeFlag;
	}
	public void setActiveFlag(Boolean isActiveFlag) {
		this.activeFlag = isActiveFlag;
	}
	public IpAddress getPrimaryIpAddress() {
		if(primaryIpAddress == null){
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
	public void setEmailAddressObj(EmailAddress emailAddress) {
		this.emailAddress = emailAddress;
	}
	public void setEmailAddress(String emailAddress){
		this.emailAddress = new EmailAddress();
		this.emailAddress.setEmailAddress(emailAddress);
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
		long age = 0;
		Date today = ZfgcTimeUtils.getToday(timeOffsetLkup);
		
		age = ZfgcTimeUtils.getYearsBetween(birthDate, today);

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
}
