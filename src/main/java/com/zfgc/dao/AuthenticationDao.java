package com.zfgc.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.zfgc.dbobj.AuthTokenDbObj;
import com.zfgc.dbobj.AuthTokenDbObjExample;
import com.zfgc.dbobj.EmailAddressDbObj;
import com.zfgc.dbobj.IpAddressDbObj;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.mappers.AuthTokenDbObjMapper;
import com.zfgc.mappers.EmailAddressDbObjMapper;
import com.zfgc.mappers.IpAddressDbObjMapper;
import com.zfgc.model.users.AuthToken;
import com.zfgc.model.users.EmailAddress;
import com.zfgc.model.users.IpAddress;
import com.zfgc.model.users.Users;

@Component
public class AuthenticationDao extends AbstractDao{
	@Autowired
	private IpAddressDbObjMapper ipAddressDbObjMapper;
	
	@Autowired
	private EmailAddressDbObjMapper emailAddressDbObjMapper;
	
	@Autowired
	private AuthTokenDbObjMapper authTokenDbObjMapper;
	
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
	
	public void saveAuthToken(AuthToken authToken) throws Exception{
		try{
			AuthTokenDbObj authTokenDbObj = mapper.map(authToken, AuthTokenDbObj.class);
			authTokenDbObjMapper.insertSelective(authTokenDbObj);
		}
		catch(Exception ex){
			logDbInsertError(LOGGER, "AUTH_TOKEN");
			throw new Exception(ex.getMessage());
		}
	}
	
	public List<AuthTokenDbObj> getAuthTokenByUser(Users user) throws Exception{
		try{
			AuthTokenDbObjExample authTokenDbObjExample = new AuthTokenDbObjExample(); 
			authTokenDbObjExample.createCriteria().andUsersIdEqualTo(user.getUsersId());
			List<AuthTokenDbObj> tokens = authTokenDbObjMapper.selectByExample(authTokenDbObjExample);
			
			return tokens;
		}
		catch(Exception ex){
			logDbSelectError(LOGGER, "AUTH_TOKEN");
			throw new Exception(ex.getMessage());
		}
	}
	
	public AuthTokenDbObj getAuthToken(String authToken) throws Exception{
		List<AuthTokenDbObj> dbObj = null;
		try{
			AuthTokenDbObjExample authTokenDbObjExample = new AuthTokenDbObjExample(); 
			authTokenDbObjExample.createCriteria().andTokenEqualTo(authToken);
			
			dbObj = authTokenDbObjMapper.selectByExample(authTokenDbObjExample);
		}
		catch(Exception ex){
			LOGGER.error("Unable to find auth token " + authToken);
			throw new Exception(ex.getMessage());
		}
		
		if(dbObj.size() == 0){
			throw new ZfgcNotFoundException("Auth token: " + authToken);
		}
		
		return dbObj.get(0);
	}
}