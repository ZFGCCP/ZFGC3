package com.zfgc.dataprovider;

import java.util.Date;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.dao.UsersDao;
import com.zfgc.dbobj.UsersDbObj;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.users.EmailAddress;
import com.zfgc.model.users.IpAddress;
import com.zfgc.model.users.Users;
import com.zfgc.util.time.ZfgcTimeUtils;

@Component
@Transactional
public class UsersDataProvider extends AbstractDataProvider {
	@Autowired
	private DozerBeanMapper mapper;
	
	@Autowired 
	private UsersDao usersDao;
	
	@Autowired
	private IpDataProvider ipDataProvider;
	
	@Autowired 
	private AuthenticationDataProvider authenticationDataProvider;
	
	Logger LOGGER = Logger.getLogger(UsersDataProvider.class);
	
	public Users getUserByToken(String token) throws Exception{
		try{
			UsersDbObj dbObj = usersDao.getUserByToken(token);
			return mapper.map(dbObj, Users.class);
		}
		catch(ZfgcNotFoundException ex){
			throw new ZfgcNotFoundException(ex.getResourceName());
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	@Transactional
	public Users createUser(Users user) throws Exception{
		
		try {
			//log Ip Address
			logIpAddress(user.getPrimaryIpAddress(),true);
			
			//log email address
			logEmailAddress(user.getEmailAddress());
			
			UsersDbObj usersDbObj = usersDao.createUser(user);
			user.setUsersId(usersDbObj.getUsersId());
			
			return user;
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	
	private void logIpAddress(IpAddress ipAddress, Boolean newUser){
		try{
			authenticationDataProvider.logIpAddress(ipAddress);
		}
		catch(Exception ex){
			if(newUser){
				LOGGER.info("IP Address " + ipAddress.getIpAddress() + " already exists.");
			}
		}
	}
	
	private  void logEmailAddress(EmailAddress emailAddress) throws Exception{
		try{
			authenticationDataProvider.logEmailAddress(emailAddress);
		}
		catch(Exception ex){
			LOGGER.info("Email Address " + emailAddress.getEmailAddress() + " already exists.");
			throw new Exception("Email Address " + emailAddress.getEmailAddress() + " already exists.");
		}
	}
	
	public Boolean doesLoginNameExist(String loginName) throws Exception{
		return usersDao.doesLoginNameExist(loginName);
	}
	
	public Boolean doesDisplayNameExist(String displayName) throws Exception{
		return usersDao.doesDisplayNameExist(displayName);
	}
	
	public Users getUserByLoginName(String loginName) throws Exception{
		try{
			return usersDao.getUserByLoginName(loginName);
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	public Integer incrementLoginFailCount(String loginName) throws Exception{
		try{
			return usersDao.incrementLoginFails(loginName);
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	public void lockAccount(String loginName, Date lockTime) throws Exception{
		try{
			usersDao.lockAccount(loginName, lockTime);
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	public void unlockAccount(String loginName) throws Exception{
		try{
			usersDao.unlockAccount(loginName);
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	public Date getLockTime(String loginName) throws Exception{
		try{
			return usersDao.getAccountLockTime(loginName);
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}

	public void linkUserToIp(Users user, IpAddress ipAddress, Boolean setPrimary) throws Exception {
		try{
			usersDao.linkUserToIp(user,ipAddress,setPrimary);
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	public String getLoginNameByToken(String token){
		return usersDao.getLoginNameByToken(token);
	}
	
	public Boolean getActiveFlagByToken(String token){
		return usersDao.getActiveFlagByToken(token);
	}
}
