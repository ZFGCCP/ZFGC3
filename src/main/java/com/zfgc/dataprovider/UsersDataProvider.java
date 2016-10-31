package com.zfgc.dataprovider;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.dao.UsersDao;
import com.zfgc.dbobj.UsersDbObj;
import com.zfgc.model.users.Users;

@Component
@Transactional
public class UsersDataProvider {
	@Autowired
	DozerBeanMapper mapper;
	
	@Autowired 
	UsersDao usersDao;
	
	Logger LOGGER = Logger.getLogger(UsersDataProvider.class);
	public Users createUser(Users user) throws Exception{
		
		try {
			UsersDbObj usersDbObj = usersDao.createUser(user);
			user.setUsersId(usersDbObj.getUsersId());
			
			return user;
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
}
