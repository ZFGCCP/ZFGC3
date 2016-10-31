package com.zfgc.model.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.model.BaseZfgcModel;

public class Users extends BaseZfgcModel {
	private String password;
	
	private Integer usersId;
	private String displayName;
	private String loginName;
	private Date dateRegistered;
	private Boolean isActiveFlag = false;
	private String emailAddress;
	
	private IpAddress primaryIpAddress = new IpAddress();
	private List<IpAddress> secondaryIpAddresses = new ArrayList<>();
	
	
	@JsonIgnore
	private UserHashInfo userHashInfo = new UserHashInfo();
	
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
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
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
	public Boolean getIsActiveFlag() {
		return isActiveFlag;
	}
	public void setIsActiveFlag(Boolean isActiveFlag) {
		this.isActiveFlag = isActiveFlag;
	}
	public IpAddress getPrimaryIpAddress() {
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
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
}
