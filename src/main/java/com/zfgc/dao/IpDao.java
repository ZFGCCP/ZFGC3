package com.zfgc.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.IpAddressDbObj;
import com.zfgc.dbobj.IpAddressDbObjExample;
import com.zfgc.mappers.IpAddressDbObjMapper;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.IpAddress;

@Component
public class IpDao extends AbstractDao<IpAddressDbObjExample, IpAddressDbObj, IpAddress> {
	
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
	
	public IpAddressDbObj getPrimaryIpByToken(String token){
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT I.* \n")
		   .append("FROM IP_ADDRESS I \n")
		   .append("INNER JOIN USERS U ON U.PRIMARY_IP = I.IP_ADDRESS \n")
		   .append("INNER JOIN AUTH_TOKEN A ON U.USER_ID = A.USER_ID \n")
		   .append("WHERE A.AUTH_TOKEN = :token");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("token", token);
		
		try{
			return (IpAddressDbObj)jdbcTemplate.queryForObject(sql.toString(), params, new BeanPropertyRowMapper(IpAddressDbObj.class));
		}
		catch(Exception ex){
			LOGGER.error("Error getting primary IP for " + token);
			return null;
		}
	}
	
	public Integer incrementLoginFails(String ipAddress) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE IP_ADDRESS \n")
		   .append("SET LOGIN_ATTEMPTS = LOGIN_ATTEMPTS + 1 \n")
		   .append("WHERE IP_ADDRESS = :ipAddress");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ipAddress",ipAddress);
		
		try{
			jdbcTemplate.update(sql.toString(), params);
		
			sql = new StringBuilder();
			sql.append("SELECT LOGIN_ATTEMPS FROM IP_ADDRESS WHERE IP_ADDRESS = :ipAddress");
		
			return jdbcTemplate.queryForObject(sql.toString(), params, Integer.class);
		}
		catch(Exception ex){
			logDbGeneralError(LOGGER, "USERS");
			throw new Exception(ex.getMessage());
		}
	}
	
	public void lockIpAddress(IpAddress ip, Date lockTime) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE IP_ADDRESS \n")
		   .append("SET LOCKED_UNTIL = :lockTime \n")
		   .append("WHERE IP_ADDRESS = :ipAddress");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ipAddress",ip.getIpAddress());
		params.addValue("lockTime", lockTime);
		
		try{
			jdbcTemplate.update(sql.toString(), params);
		}
		catch(Exception ex){
			logDbUpdateError(LOGGER,"IP_ADDRESS");
			throw new Exception(ex.getMessage());
		}
	}
	
	public Date getIpLockTime(IpAddress ipAddress) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT LOCKED_UNTIL \n")
		   .append("FROM IP_ADDRESS \n")
		   .append("WHERE IP_ADDRESS = :ipAddress");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ipAddress",ipAddress.getIpAddress());
		
		try{
			return jdbcTemplate.queryForObject(sql.toString(), params, Date.class);
		}
		catch(Exception ex){
			logDbGeneralError(LOGGER,"IP_ADDRESS");
			throw new Exception(ex.getMessage());
		}
	}
	
	public void unlockIp(IpAddress ipAddress) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE IP_ADDRESS \n")
		   .append("SET LOCKED_UNTIL = null, LOGIN_ATTEMPTS = 0 \n")
		   .append("WHERE IP_ADDRESS = :ipAddress");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ipAddress",ipAddress.getIpAddress());
		
		try{
			jdbcTemplate.update(sql.toString(), params);
		}
		catch(Exception ex){
			logDbUpdateError(LOGGER,"IP_ADDRESS");
			throw new Exception(ex.getMessage());
		}
	}
	
	public Integer incrementLoginFails(IpAddress ipAddress) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE IP_ADDRESS \n")
		   .append("SET LOGIN_ATTEMPTS = LOGIN_ATTEMPTS + 1  \n")
		   .append("WHERE IP_ADDRESS = :ipAddress");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ipAddress",ipAddress.getIpAddress());
		
		try{
			jdbcTemplate.update(sql.toString(), params);
		
			sql = new StringBuilder();
			sql.append("SELECT LOGIN_ATTEMPTS FROM IP_ADDRESS WHERE IP_ADDRESS = :ipAddress");
		
			return jdbcTemplate.queryForObject(sql.toString(), params, Integer.class);
		}
		catch(Exception ex){
			logDbGeneralError(LOGGER, "IP_ADDRESS");
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	public List<IpAddressDbObj> get(IpAddressDbObjExample ex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void hardDelete(IpAddress obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(IpAddress obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(IpAddress obj, IpAddressDbObjExample ex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(IpAddress obj, IpAddressDbObjExample ex) {
		return null;
		// TODO Auto-generated method stub
		
	}

}
