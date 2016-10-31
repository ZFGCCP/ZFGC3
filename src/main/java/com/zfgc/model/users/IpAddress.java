package com.zfgc.model.users;

public class IpAddress{
	private String ipAddress;
	private Integer version;
	private Boolean isSpammer = true; //just assume everyone is a spammer by default, we'll have a proper check for this during registration
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
	public Boolean getIsSpammer() {
		return isSpammer;
	}
	public void setIsSpammer(Boolean isSpammer) {
		this.isSpammer = isSpammer;
	}
	
	
}