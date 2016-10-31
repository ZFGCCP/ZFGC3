package com.zfgc.dao;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.UsersDbObj;
import com.zfgc.mappers.UsersDbObjMapper;
import com.zfgc.model.users.UserHashInfo;
import com.zfgc.model.users.Users;

@Component
public class UsersDao extends AbstractDao {
	@Autowired 
	UsersDbObjMapper usersDbObjMapper;
	
	@Autowired
	DozerBeanMapper mapper;
	
	Logger LOGGER = Logger.getLogger(UsersDao.class);
	
	public UsersDbObj createUser(Users user) throws Exception{
		UsersDbObj usersDbObj = mapper.map(user, UsersDbObj.class);
		usersDbObj.setPassword(user.getUserHashInfo().getPassword());
		usersDbObj.setPassSalt(user.getUserHashInfo().getPassSalt());
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
	
	public UserHashInfo getUSerPasswordAndSaltByName(String loginName) throws Exception{
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
}
