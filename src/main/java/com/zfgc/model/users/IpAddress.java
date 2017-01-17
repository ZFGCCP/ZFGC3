package com.zfgc.model.users;

import java.util.Date;

import com.zfgc.model.BaseZfgcModel;

public class IpAddress extends BaseZfgcModel{
	private String ipAddress;
	private Integer version;
	private Date lockedUntil;
	private Boolean isSpammerFlag = true; //just assume everyone is a spammer by default, we'll have a proper check for this during registration
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Boolean getIsSpammerFlag() {
		return isSpammerFlag;
	}
	public void setIsSpammerFlag(Boolean isSpammerFlag) {
		this.isSpammerFlag = isSpammerFlag;
	}
	public Date getLockedUntil() {
		return lockedUntil;
	}
	public void setLockedUntil(Date lockedUntil) {
		this.lockedUntil = lockedUntil;
	}
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}