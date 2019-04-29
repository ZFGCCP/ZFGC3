package com.zfgc.dataprovider;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.IpDao;
import com.zfgc.dbobj.IpAddressDbObj;
import com.zfgc.dbobj.IpAddressDbObjExample;
import com.zfgc.model.users.IpAddress;

@Component
public class IpDataProvider extends AbstractDataProvider{
	@Autowired
	IpDao ipDao;
	
	public IpAddress getIpAddress(Integer ipAddressId) throws RuntimeException{
		IpAddressDbObjExample ex = ipDao.getExample();
		ex.createCriteria().andIpAddressIdEqualTo(ipAddressId);
		List<IpAddressDbObj> dbObj = ipDao.get(ex);
		
		return mapper.map(dbObj.get(0), IpAddress.class);
	}
	
	public IpAddress getIpAddress(String ipAddress) throws RuntimeException{
		IpAddressDbObjExample ex = ipDao.getExample();
		ex.createCriteria().andIpAddressEqualTo(ipAddress);
		List<IpAddressDbObj> dbObj = ipDao.get(ex);
		
		return mapper.map(dbObj.get(0), IpAddress.class);
	}
	
	public IpAddress logIpAddress(IpAddress ip) throws RuntimeException{
		IpAddressDbObj dbObj = ipDao.logIpAddress(ip);
		return mapper.map(dbObj, IpAddress.class);
	}
	
	public void saveIpAddress(IpAddress ip) {
		ipDao.updateOrInsert(ip);
	}
	
	public IpAddress getPrimaryIpByToken(String token){
		IpAddressDbObj dbObj = ipDao.getPrimaryIpByToken(token);
		return mapper.map(dbObj, IpAddress.class);
	}
	
	public void lockIp(IpAddress ipAddress, Date lockTime) throws RuntimeException{
		try{
			ipDao.lockIpAddress(ipAddress, lockTime);
		}
		catch(RuntimeException ex){
			throw ex;
		}
	}
	
	public Date getLockTime(IpAddress ipAddress) throws RuntimeException{
		try{
			return ipDao.getIpLockTime(ipAddress);
		}
		catch(RuntimeException ex){
			throw ex;
		}
	}
	
	public void unlockIp(IpAddress ipAddress) throws RuntimeException{
		try{
			ipDao.unlockIp(ipAddress);
		}
		catch(RuntimeException ex){
			throw ex;
		}
	}
	
	public Integer incrementLoginFailCount(IpAddress ipAddress) throws RuntimeException{
		try{
			return ipDao.incrementLoginFails(ipAddress);
		}
		catch(RuntimeException ex){
			throw ex;
		}
	}
}