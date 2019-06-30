package com.zfgc.model.online;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.IpAddress;

public class OnlineUser extends BaseZfgcModel {
	private Integer usersId;
	private String displayName;
	private String primaryMemberGroup;
	private IpAddress ip;
	private String agentType;
	private String agentName;
	private String agentVersion;
	private String osType;
	private String osName;
	private String sessionId;

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
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public String getPrimaryMemberGroup() {
		if(primaryMemberGroup == null) {
			return null;
		}
		return primaryMemberGroup.toLowerCase();
	}
	public void setPrimaryMemberGroup(String primaryMemberGroup) {
		this.primaryMemberGroup = primaryMemberGroup;
	}
	public IpAddress getIp() {
		return ip;
	}
	public void setIp(IpAddress ip) {
		this.ip = ip;
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
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	
}
