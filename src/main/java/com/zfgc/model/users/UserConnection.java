package com.zfgc.model.users;

import com.zfgc.model.BaseZfgcModel;

public class UserConnection extends BaseZfgcModel {

	private Integer userConnectionId;
    private Integer usersId;
    private String userAgentVersion;
    private Integer ipAddressId;
    private String userAgent;
    private String osType;
    private String osName;
    private String osVersion;
    private String sessionId;
    
    private IpAddress ipAddress;
	
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

	public String getUserAgentVersion() {
		return userAgentVersion;
	}

	public void setUserAgentVersion(String userAgentVersion) {
		this.userAgentVersion = userAgentVersion;
	}

	public Integer getIpAddressId() {
		return ipAddressId;
	}

	public void setIpAddressId(Integer ipAddressId) {
		this.ipAddressId = ipAddressId;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
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

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
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
	
}