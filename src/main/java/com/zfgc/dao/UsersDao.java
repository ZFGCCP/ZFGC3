package com.zfgc.dao;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.dbobj.BrUsersIpAddressDbObjKey;
import com.zfgc.dbobj.UsersDbObj;
import com.zfgc.dbobj.UsersDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.mappers.BrUserConversationDbObjMapper;
import com.zfgc.mappers.BrUsersIpAddressDbObjMapper;
import com.zfgc.mappers.UsersDbObjMapper;
import com.zfgc.model.users.IpAddress;
import com.zfgc.model.users.UserHashInfo;
import com.zfgc.model.users.Users;

@Component
public class UsersDao extends AbstractDao<UsersDbObjExample, UsersDbObj, Users> {
	@Autowired 
	UsersDbObjMapper usersDbObjMapper;

	private Logger LOGGER = LogManager.getLogger(UsersDao.class);
	
	public UsersDbObj createUser(Users user) throws Exception{
		UsersDbObj usersDbObj = mapper.map(user, UsersDbObj.class);
		usersDbObj.setPassword(user.getUserHashInfo().getPassword());
		usersDbObj.setPassSalt(user.getUserHashInfo().getPassSalt());
		usersDbObj.setPrimaryIp(user.getPrimaryIpAddress().getIpAddressId());
		//usersDbObj.setEmailAddress(user.getEmailAddress().getEmailAddress());
		try{
			usersDbObjMapper.insertSelective(usersDbObj);
			usersDbObjMapper.createSha2HashForUser(usersDbObj);
		}
		catch(Exception ex){
			LOGGER.error("Error creating user " + usersDbObj.getLoginName());
			throw new Exception(ex.getMessage());
		}
		
		return usersDbObj;
	}
	
	@Override
	public List<UsersDbObj> get(UsersDbObjExample ex) throws RuntimeException {
		return usersDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(Users obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(Users obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(Users obj, UsersDbObjExample ex) throws RuntimeException {
		UsersDbObj dbObj = mapper.map(obj, UsersDbObj.class);
		usersDbObjMapper.updateByExampleSelective(dbObj, ex);
	}

	@Override
	public Integer deleteByExample(Users obj, UsersDbObjExample ex) throws RuntimeException {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long countByExample(Users obj, UsersDbObjExample ex)
			throws RuntimeException {
		return usersDbObjMapper.countByExample(ex);
	}
	
	public Integer checkUserPassword(Integer usersId, String password) throws RuntimeException{
		return usersDbObjMapper.validateUserPassword(usersId, password);
	}
	
	public UsersDbObj getMostRecentMember() {
		return usersDbObjMapper.getMostRecentActivatedMember();
	}
	
}
