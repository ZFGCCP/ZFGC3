package com.zfgc.services.ip;

import org.springframework.stereotype.Component;

import com.zfgc.model.users.IpAddress;

@Component
public class IpAddressService {
	public IpAddress createIpAddress(String ipAddressAsString){
		IpAddress ipAddress = new IpAddress();
		ipAddress.setIpAddress(ipAddressAsString);
		ipAddress.setVersion(getIpVersion(ipAddressAsString));
		
		return ipAddress;
	}
	
	public Integer getIpVersion(String ipAddressAsString){
		return ipAddressAsString.contains(":") ? 6 : 4;
	}
}
