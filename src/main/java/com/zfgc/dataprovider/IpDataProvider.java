package com.zfgc.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.IpDao;
import com.zfgc.dbobj.IpAddressDbObj;
import com.zfgc.model.users.IpAddress;

@Component
public class IpDataProvider extends AbstractDataProvider{
	@Autowired
	IpDao ipDao;
	
	public IpAddress logIpAddress(IpAddress ip) throws Exception{
		IpAddressDbObj dbObj = ipDao.logIpAddress(ip);
		return mapper.map(dbObj, IpAddress.class);
	}
	
	public IpAddress getPrimaryIpByToken(String token){
		IpAddressDbObj dbObj = ipDao.getPrimaryIpByToken(token);
		return mapper.map(dbObj, IpAddress.class);
	}
}