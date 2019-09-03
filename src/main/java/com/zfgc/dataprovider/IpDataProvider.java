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
	
	public void saveIpAddress(IpAddress ip) {
		ipDao.updateOrInsert(ip);
	}
}