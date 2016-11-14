package com.zfgc.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
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
import com.zfgc.mappers.BrUsersIpAddressDbObjMapper;
import com.zfgc.mappers.UsersDbObjMapper;
import com.zfgc.model.users.IpAddress;
import com.zfgc.model.users.UserHashInfo;
import com.zfgc.model.users.Users;

@Component
public class UsersDao extends AbstractDao {
	@Autowired 
	UsersDbObjMapper usersDbObjMapper;

	@Autowired
	BrUsersIpAddressDbObjMapper brUsersIpAddressDbObjMapper;
	
	Logger LOGGER = Logger.getLogger(UsersDao.class);
	
	public UsersDbObj createUser(Users user) throws Exception{
		UsersDbObj usersDbObj = mapper.map(user, UsersDbObj.class);
		usersDbObj.setPassword(user.getUserHashInfo().getPassword());
		usersDbObj.setPassSalt(user.getUserHashInfo().getPassSalt());
		usersDbObj.setPrimaryIp(user.getPrimaryIpAddress().getIpAddress());
		usersDbObj.setEmailAddress(user.getEmailAddress().getEmailAddress());
		try{
			usersDbObjMapper.insertSelective(usersDbObj);
		}
		catch(Exception ex){
			LOGGER.error("Error creating user " + usersDbObj.getLoginName());
			throw new Exception(ex.getMessage());
		}
		
		return usersDbObj;
	}
	
	public UserHashInfo getUserPasswordAndSaltById(Integer usersId) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT PASSWORD, PASS_SALT \n")
		   .append("FROM users \n")
		   .append("WHERE USERS_ID = :userId");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("usersId", usersId);
		
		try{
			UserHashInfo hashInfo = (UserHashInfo)jdbcTemplate.queryForObject(sql.toString(), params, new BeanPropertyRowMapper(UserHashInfo.class));
			return hashInfo;
		}
		catch(Exception ex){
			LOGGER.error("Error getting password for user " + usersId);
			throw new Exception(ex.getMessage());
		}
	}
	
	public UserHashInfo getUserPasswordAndSaltByName(String loginName) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT PASSWORD, PASS_SALT \n")
		   .append("FROM users \n")
		   .append("WHERE LOGIN_NAME = :loginName");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("loginName", loginName);
		
		try{
			UserHashInfo hashInfo = (UserHashInfo)jdbcTemplate.queryForObject(sql.toString(), params, new BeanPropertyRowMapper(UserHashInfo.class));
			return hashInfo;
		}
		catch(Exception ex){
			LOGGER.error("Error getting password for user " + loginName);
			throw new Exception(ex.getMessage());
		}
	}
	
	public UserHashInfo getUserPasswordAndSaltByDisplayName(String displayName) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT PASSWORD, PASS_SALT \n")
		   .append("FROM users \n")
		   .append("WHERE DISPLAY_NAME = :displayName");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("displayName",displayName);
		
		try{
			UserHashInfo hashInfo = (UserHashInfo)jdbcTemplate.queryForObject(sql.toString(), params, new BeanPropertyRowMapper(UserHashInfo.class));
			return hashInfo;
		}
		catch(Exception ex){
			LOGGER.error("Error getting password for user " + displayName);
			throw new Exception(ex.getMessage());
		}
	}
	
	public Users getUserByLoginName(String loginName) throws Exception{
		UsersDbObjExample usersDbObjExample = new UsersDbObjExample();
		usersDbObjExample.createCriteria().andLoginNameEqualTo(loginName);
		
		try{
			List<UsersDbObj> usersDbObj = usersDbObjMapper.selectByExample(usersDbObjExample);
			
			if(usersDbObj != null && usersDbObj.size() > 0){
				return mapper.map(usersDbObj.get(0), Users.class);
			}
		}
		catch(Exception ex){
			LOGGER.error("Error finding login name " + loginName);
			throw new Exception(ex.getMessage());
		}

		return null;
	}
	
	public Users getUserByDisplayName(String displayName) throws Exception{
		UsersDbObjExample usersDbObjExample = new UsersDbObjExample();
		usersDbObjExample.createCriteria().andDisplayNameEqualTo(displayName);
		
		try{
			List<UsersDbObj> usersDbObj = usersDbObjMapper.selectByExample(usersDbObjExample);
			
			if(usersDbObj != null && usersDbObj.size() > 0){
				return mapper.map(usersDbObj.get(0), Users.class);
			}
		}
		catch(Exception ex){
			LOGGER.error("Error finding display name " + displayName);
			throw new Exception(ex.getMessage());
		}
		
		return null;
	}
	
	public Boolean doesLoginNameExist(String loginName) throws Exception{
		UsersDbObjExample usersDbObjExample = new UsersDbObjExample();
		usersDbObjExample.createCriteria().andLoginNameEqualTo(loginName);
		
		try{
			return usersDbObjMapper.countByExample(usersDbObjExample) > 0;
		}
		catch(Exception ex){
			LOGGER.error("Error finding login name " + loginName);
			throw new Exception(ex.getMessage());
		}
	}
	
	public Boolean doesDisplayNameExist(String displayName) throws Exception{
		UsersDbObjExample usersDbObjExample = new UsersDbObjExample();
		usersDbObjExample.createCriteria().andDisplayNameEqualTo(displayName);
		
		try{
			return usersDbObjMapper.countByExample(usersDbObjExample) > 0;
		}
		catch(Exception ex){
			LOGGER.error("Error finding display name " + displayName);
			throw new Exception(ex.getMessage());
		}
	}
	
	public Integer incrementLoginFails(String loginName) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE USERS \n")
		   .append("SET LOGIN_FAILED_ATTEMPTS = \n")
		   .append("(SELECT LOGIN_FAILED_ATTEMPTS + 1 FROM USERS WHERE LOGIN_NAME = :loginName) \n")
		   .append("WHERE LOGIN_NAME = :loginName");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("loginName",loginName);
		
		try{
			jdbcTemplate.update(sql.toString(), params);
		
			sql = new StringBuilder();
			sql.append("SELECT LOGIN_FAILED_ATTEMPS FROM USERS WHERE LOGIN_NAME = :loginName");
		
			return jdbcTemplate.queryForObject(sql.toString(), params, Integer.class);
		}
		catch(Exception ex){
			logDbGeneralError(LOGGER, "USERS");
			throw new Exception(ex.getMessage());
		}
	}
	
	public void lockAccount(String loginName, Date lockTime) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE USERS \n")
		   .append("SET LOCKED_UNTIL = :lockTime \n")
		   .append("WHERE LOGIN_NAME = :loginName");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("loginName",loginName);
		params.addValue("lockTime", lockTime);
		
		try{
			jdbcTemplate.update(sql.toString(), params);
		}
		catch(Exception ex){
			logDbUpdateError(LOGGER,"USERS");
			throw new Exception(ex.getMessage());
		}
	}
	
	public void unlockAccount(String loginName) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE USERS \n")
		   .append("SET LOCKED_UNTIL = null, LOGIN_FAILED_ATTEMPS = 0 \n")
		   .append("WHERE LOGIN_NAME = :loginName");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("loginName",loginName);
		
		try{
			jdbcTemplate.update(sql.toString(), params);
		}
		catch(Exception ex){
			logDbUpdateError(LOGGER,"USERS");
			throw new Exception(ex.getMessage());
		}
	}
	
	public Date getAccountLockTime(String loginName) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT LOCKED_UNTIL \n")
		   .append("FROM USERS \n")
		   .append("WHERE LOGIN_NAME = :loginName");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("loginName",loginName);
		
		try{
			return jdbcTemplate.queryForObject(sql.toString(), params, Date.class);
		}
		catch(Exception ex){
			logDbGeneralError(LOGGER,"USERS");
			throw new Exception(ex.getMessage());
		}
	}

	@Transactional
	public void linkUserToIp(Users user, IpAddress ipAddress, Boolean setPrimary) throws Exception{
		if(setPrimary){
			UsersDbObj tempUser = new UsersDbObj();
			tempUser.setUsersId(user.getUsersId());
			tempUser.setPrimaryIp(ipAddress.getIpAddress());
			
			try{
				usersDbObjMapper.updateByPrimaryKeySelective(tempUser);
			}
			catch(Exception ex){
				super.logDbUpdateError(LOGGER, "USERS");
				throw new Exception(ex.getMessage());
			}
		}
		
		BrUsersIpAddressDbObjKey brUsersIpAddress = new BrUsersIpAddressDbObjKey();
		brUsersIpAddress.setIpAddress(ipAddress.getIpAddress());
		brUsersIpAddress.setUsersId(user.getUsersId());
		
		try{
			brUsersIpAddressDbObjMapper.insert(brUsersIpAddress);
		}
		catch(DuplicateKeyException ex){
			super.logDbDuplicateKeyError(LOGGER, "BR_USERS_IP_ADDRESS", brUsersIpAddress.getUsersId() + ", " + brUsersIpAddress.getIpAddress());
		}
		catch(Exception ex){
			super.logDbInsertError(LOGGER, "BR_USERS_IP_ADDRESS");
			throw new Exception(ex.getMessage());
		}

	}
	
	
}
