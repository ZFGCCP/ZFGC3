package com.zfgc.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.zfgc.dbobj.EmailAddressDbObj;
import com.zfgc.dbobj.IpAddressDbObj;
import com.zfgc.mappers.EmailAddressDbObjMapper;
import com.zfgc.mappers.IpAddressDbObjMapper;
import com.zfgc.model.users.EmailAddress;
import com.zfgc.model.users.IpAddress;

@Component
public class AuthenticationDao extends AbstractDao{
	@Autowired
	private IpAddressDbObjMapper ipAddressDbObjMapper;
	
	@Autowired
	private EmailAddressDbObjMapper emailAddressDbObjMapper;
	
	private Logger LOGGER = Logger.getLogger(AuthenticationDao.class);
	
	public void logIpAddress(IpAddress ipAddress) throws Exception{
		
		try{
			IpAddressDbObj ipAddressDbObj = mapper.map(ipAddress, IpAddressDbObj.class);
			ipAddressDbObjMapper.insertSelective(ipAddressDbObj);
		}
		catch(Exception ex){
			LOGGER.error("Unable to log IP Address " + ipAddress.getIpAddress());
			throw new Exception(ex.getMessage());
		}
	}
	
	public void logEmailAddress(EmailAddress emailAddress) throws Exception{
		try{
			EmailAddressDbObj emailAddressDbObj = mapper.map(emailAddress, EmailAddressDbObj.class);
			emailAddressDbObjMapper.insertSelective(emailAddressDbObj);
		}
		catch(Exception ex){
			LOGGER.error("Unable to log Email Address " + emailAddress.getEmailAddress());
			throw new Exception(ex.getMessage());
		}
	}
	
	public EmailAddressDbObj getEmailAddress(String emailAddress) throws Exception{
		try{
			return emailAddressDbObjMapper.selectByPrimaryKey(emailAddress);
		}
		catch(Exception ex){
			LOGGER.error("Unable to obtain Email Address " + emailAddress);
			throw new Exception(ex.getMessage());
		}
	}
}