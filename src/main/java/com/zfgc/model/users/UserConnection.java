package com.zfgc.model.users;

import com.zfgc.model.BaseZfgcModel;

public class UserConnection extends BaseZfgcModel {

	private Integer userConnectionId;
    private Integer usersId;
    private Integer ipAddressId;
    private String sessionId;
    
    private String agentType;
	private String agentName;
	private String agentVersion;
	
	private String osType;
	private String osName;
	private String osVersionName;
	private String osVersionNumber;
    
    private IpAddress ipAddress;
    
    private Integer userActionId = 7;
	
	public Integer getUserConnectionId() {
		return userConnectionId;
	}

	public void setUserConnectionId(Integer userConnectionId) {
		this.userConnectionId = userConnectionId;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public Integer getIpAddressId() {
		return ipAddressId;
	}

	public void setIpAddressId(Integer ipAddressId) {
		this.ipAddressId = ipAddressId;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public IpAddress getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(IpAddress ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getAgentType() {
		return agentType;
	}

	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentVersion() {
		return agentVersion;
	}

	public void setAgentVersion(String agentVersion) {
		this.agentVersion = agentVersion;
	}

	public String getOsVersionName() {
		return osVersionName;
	}

	public void setOsVersionName(String osVersionName) {
		this.osVersionName = osVersionName;
	}

	public String getOsVersionNumber() {
		return osVersionNumber;
	}

	public void setOsVersionNumber(String osVersionNumber) {
		this.osVersionNumber = osVersionNumber;
	}

	public Integer getUserActionId() {
		return userActionId;
	}

	public void setUserActionId(Integer userActionId) {
		this.userActionId = userActionId;
	}
	
}