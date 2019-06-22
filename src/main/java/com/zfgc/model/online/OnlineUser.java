package com.zfgc.model.online;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.IpAddress;

public class OnlineUser extends BaseZfgcModel {
	private Integer usersId;
	private String displayName;
	private String primaryMemberGroup;
	private IpAddress ipAddress;
	
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
		return primaryMemberGroup.toLowerCase();
	}
	public void setPrimaryMemberGroup(String primaryMemberGroup) {
		this.primaryMemberGroup = primaryMemberGroup;
	}
	public IpAddress getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(IpAddress ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	
}
