package com.zfgc.services.ip;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.IpDataProvider;
import com.zfgc.model.users.IpAddress;
import com.zfgc.services.logging.LoggingService;
import com.zfgc.util.time.ZfgcTimeUtils;

@Component
public class IpAddressService {
	@Autowired
	LoggingService loggingService;
	
	@Autowired
	IpDataProvider ipDataProvider;
	
	public IpAddress getIpAddress(Integer ipAddressId) throws RuntimeException {
		IpAddress ip = ipDataProvider.getIpAddress(ipAddressId);
		return ip;
	}
	
	public IpAddress getIpAddress(String ipAddress) throws RuntimeException{
		IpAddress ip = ipDataProvider.getIpAddress(ipAddress);
		return ip;
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
	
	public Boolean lockIp(IpAddress ipAddress){
		Date lockTime = ZfgcTimeUtils.getToday();
		lockTime = DateUtils.addMinutes(lockTime, 10);
		try {
			ipDataProvider.lockIp(ipAddress, lockTime);
			loggingService.logAction(3, "Ip Address for " + ipAddress.getIpAddress() + " locked.", null, ipAddress.getIpAddress());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Boolean isIpLocked(IpAddress ipAddress){
		try{
			Date lockTime = ipDataProvider.getLockTime(ipAddress);
			ipAddress.setLockedUntil(lockTime);
			
			if(lockTime != null && lockTime.compareTo(ZfgcTimeUtils.getToday()) < 0){
				unlockIp(ipAddress);
				return false;
			}
			if(lockTime != null && lockTime.compareTo(ZfgcTimeUtils.getToday()) >= 0){
				return true;
			}
			
			return false;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	private Boolean unlockIp(IpAddress ipAddress){
		try{
			ipDataProvider.unlockIp(ipAddress);
			loggingService.logAction(7, "Ip Address " + ipAddress.getIpAddress() + " unlocked.", null, "127.0.0.1");
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Integer incrementLoginFailCount(IpAddress ipAddress) throws RuntimeException{
		try{
			return ipDataProvider.incrementLoginFailCount(ipAddress);
		}
		catch(RuntimeException ex){
			throw ex;
		}
	}
	
}
