package com.zfgc.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.IpAddressDbObj;
import com.zfgc.mappers.IpAddressDbObjMapper;
import com.zfgc.model.users.IpAddress;

@Component
public class IpDao extends AbstractDao {
	
	@Autowired
	IpAddressDbObjMapper ipAddressDbObjMapper;
	
	Logger LOGGER = Logger.getLogger(IpDao.class);
	
	public IpAddressDbObj logIpAddress(IpAddress ip) throws Exception{
		IpAddressDbObj ipDbObj = mapper.map(ip, IpAddressDbObj.class);
		
		try{
			ipAddressDbObjMapper.insert(ipDbObj);
		}
		catch(DuplicateKeyException ex){
			super.logDbDuplicateKeyError(LOGGER, "IP_ADDRESS", ip.getIpAddress());
			return null;
		}
		catch(Exception ex){
			super.logDbInsertError(LOGGER, "IP_ADDRESS");
			throw new Exception(ex.getMessage());
		}
		
		return ipDbObj;
	}
}
