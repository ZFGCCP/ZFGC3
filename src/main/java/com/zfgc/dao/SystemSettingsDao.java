package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.SystemSettingsDbObj;
import com.zfgc.dbobj.SystemSettingsDbObjExample;
import com.zfgc.mappers.SystemSettingsDbObjMapper;
import com.zfgc.model.system.SystemSettings;

@Component
public class SystemSettingsDao extends AbstractDao<SystemSettingsDbObjExample, SystemSettingsDbObj, SystemSettings>{

	@Autowired
	private SystemSettingsDbObjMapper systemSettingsDbObjMapper;
	
	@Override
	public List<SystemSettingsDbObj> get(SystemSettingsDbObjExample ex) throws RuntimeException {
		return systemSettingsDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(SystemSettings obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(SystemSettings obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(SystemSettings obj, SystemSettingsDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(SystemSettings obj, SystemSettingsDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByExample(SystemSettings obj, SystemSettingsDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}