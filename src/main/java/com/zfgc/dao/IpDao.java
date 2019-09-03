package com.zfgc.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.IpAddressDbObj;
import com.zfgc.dbobj.IpAddressDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.mappers.IpAddressDbObjMapper;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.IpAddress;

@Component
public class IpDao extends AbstractDao<IpAddressDbObjExample, IpAddressDbObj, IpAddress> {
	
	@Autowired
	IpAddressDbObjMapper ipAddressDbObjMapper;
	
	private Logger LOGGER = LogManager.getLogger(IpDao.class);

	@Override
	public List<IpAddressDbObj> get(IpAddressDbObjExample ex) throws ZfgcNotFoundException, RuntimeException {
		List<IpAddressDbObj> dbObj = ipAddressDbObjMapper.selectByExample(ex);
		
		if(dbObj.size() > 0) {
			return dbObj;
		}
		
		throw new ZfgcNotFoundException("IP Address not found");
	}

	@Override
	public void hardDelete(IpAddress obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(IpAddress obj) throws RuntimeException {
		IpAddressDbObj dbObj = mapper.map(obj, IpAddressDbObj.class);
		if(obj.getIpAddressId() == null) {
			ipAddressDbObjMapper.insert(dbObj);
			obj.setIpAddressId(dbObj.getIpAddressId());
		}
		else {
			ipAddressDbObjMapper.updateByPrimaryKey(dbObj);
		}
		
	}

	@Override
	public void updateByExample(IpAddress obj, IpAddressDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(IpAddress obj, IpAddressDbObjExample ex) throws RuntimeException {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long countByExample(IpAddress obj, IpAddressDbObjExample ex)
			throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

}
