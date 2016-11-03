package com.zfgc.dataprovider;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.dao.UsersDao;
import com.zfgc.dbobj.UsersDbObj;
import com.zfgc.model.users.EmailAddress;
import com.zfgc.model.users.IpAddress;
import com.zfgc.model.users.Users;

@Component
@Transactional
public class UsersDataProvider {
	@Autowired
	private DozerBeanMapper mapper;
	
	@Autowired 
	private UsersDao usersDao;
	
	@Autowired 
	private AuthenticationDataProvider authenticationDataProvider;
	
	Logger LOGGER = Logger.getLogger(UsersDataProvider.class);
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
}
