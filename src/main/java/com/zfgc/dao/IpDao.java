package com.zfgc.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.IpAddressDbObj;
import com.zfgc.mappers.IpAddressDbObjMapper;
import com.zfgc.model.users.IpAddress;

@Component
public class IpDao extends AbstractDao {
	
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
}
