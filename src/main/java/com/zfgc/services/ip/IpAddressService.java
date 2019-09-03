package com.zfgc.services.ip;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.HostnameDataProvider;
import com.zfgc.dataprovider.IpDataProvider;
import com.zfgc.model.users.Hostname;
import com.zfgc.model.users.IpAddress;
import com.zfgc.services.logging.LoggingService;
import com.zfgc.util.time.ZfgcTimeUtils;

@Component
public class IpAddressService {
	@Autowired
	LoggingService loggingService;
	
	@Autowired
	IpDataProvider ipDataProvider;
	
	@Autowired
	HostnameDataProvider hostnameDataProvider;
	
	public IpAddress getIpAddress(Integer ipAddressId) throws RuntimeException {
		IpAddress ip = ipDataProvider.getIpAddress(ipAddressId);
		return ip;
	}
	
	public IpAddress getIpAddress(String ipAddress) throws RuntimeException{
		IpAddress ip = ipDataProvider.getIpAddress(ipAddress);
		return ip;
	}
	
	public Hostname createHostname(String hostnameAsString) {
		Hostname hostname = new Hostname();
		hostname.setHostname(hostnameAsString);
		
		hostnameDataProvider.saveHost(hostname);
		
		return hostname;
	}
	
	public Hostname getHostname(Integer hostnameId) {
		return hostnameDataProvider.getHost(hostnameId);
	}

	public Hostname getHostname(String hostname) {
		return hostnameDataProvider.getHost(hostname);
	}
	
	public IpAddress createIpAddress(String ipAddressAsString){
		IpAddress ipAddress = new IpAddress();
		ipAddress.setIpAddress(ipAddressAsString);
		ipAddress.setVersion(getIpVersion(ipAddressAsString));
		ipAddress.setIsLockedFlag(false);
		
		//save the ip
		this.ipDataProvider.saveIpAddress(ipAddress);
		
		return ipAddress;
	}
	
	public Integer getIpVersion(String ipAddressAsString){
		return ipAddressAsString.contains(":") ? 6 : 4;
	}
	
}
