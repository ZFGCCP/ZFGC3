package com.zfgc.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.AuthTokenDbObj;
import com.zfgc.dbobj.AuthTokenDbObjExample;
import com.zfgc.dbobj.EmailAddressDbObj;
import com.zfgc.dbobj.IpAddressDbObj;
import com.zfgc.exception.ZfgcDataExistsException;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.mappers.AuthTokenDbObjMapper;
import com.zfgc.mappers.EmailAddressDbObjMapper;
import com.zfgc.mappers.IpAddressDbObjMapper;
import com.zfgc.model.BaseZfgcModel;
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
	
	public void logEmailAddress(EmailAddress emailAddress) throws ZfgcDataExistsException, RuntimeException{
		if(getEmailAddress(emailAddress.getEmailAddress()) != null){
			throw new ZfgcDataExistsException("EmailAddress: " + emailAddress.getEmailAddress());
		}
		
		try{
			EmailAddressDbObj emailAddressDbObj = mapper.map(emailAddress, EmailAddressDbObj.class);
			emailAddressDbObjMapper.insertSelective(emailAddressDbObj);
		}
		catch(RuntimeException ex){
			LOGGER.error("Unable to log Email Address " + emailAddress.getEmailAddress());
			throw ex;
		}
	}
	
	public EmailAddressDbObj getEmailAddress(String emailAddress) throws RuntimeException{
		try{
			//return emailAddressDbObjMapper.selectByPrimaryKey(emailAddress);
			return null;
		}
		catch(RuntimeException ex){
			LOGGER.error("Unable to obtain Email Address " + emailAddress);
			throw ex;
		}
	}
	
	public void saveAuthToken(AuthToken authToken) throws RuntimeException{
		try{
			AuthTokenDbObj authTokenDbObj = mapper.map(authToken, AuthTokenDbObj.class);
			authTokenDbObjMapper.insertSelective(authTokenDbObj);
		}
		catch(RuntimeException ex){
			logDbInsertError(LOGGER, "AUTH_TOKEN");
			throw ex;
		}
	}
	
	public List<AuthTokenDbObj> getAuthTokenByUser(Users user) throws RuntimeException{
		try{
			AuthTokenDbObjExample authTokenDbObjExample = new AuthTokenDbObjExample(); 
			authTokenDbObjExample.createCriteria().andUsersIdEqualTo(user.getUsersId());
			List<AuthTokenDbObj> tokens = authTokenDbObjMapper.selectByExample(authTokenDbObjExample);
			
			return tokens;
		}
		catch(RuntimeException ex){
			logDbSelectError(LOGGER, "AUTH_TOKEN");
			throw ex;
		}
	}
	
	public AuthTokenDbObj getAuthToken(String authToken) throws RuntimeException{
		List<AuthTokenDbObj> dbObj = null;
		try{
			AuthTokenDbObjExample authTokenDbObjExample = new AuthTokenDbObjExample(); 
			authTokenDbObjExample.createCriteria().andTokenEqualTo(authToken);
			
			dbObj = authTokenDbObjMapper.selectByExample(authTokenDbObjExample);
		}
		catch(RuntimeException ex){
			LOGGER.error("Unable to find auth token " + authToken);
			throw ex;
		}
		
		if(dbObj.size() == 0){
			throw new ZfgcNotFoundException("Auth token: " + authToken);
		}
		
		return dbObj.get(0);
	}

	@Override
	public List<Object> get(Object ex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void hardDelete(Object ex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(Object obj, Object ex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(Object obj, Object ex) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer countByExample(Object obj, Object ex) {
		// TODO Auto-generated method stub
		return null;
	}
}