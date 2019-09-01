package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.SystemDirectoryDbObj;
import com.zfgc.dbobj.SystemDirectoryDbObjExample;
import com.zfgc.mappers.SystemDirectoryDbObjMapper;
import com.zfgc.model.system.SystemDirectory;

@Component
public class SystemDirectoryDao extends AbstractDao<SystemDirectoryDbObjExample, SystemDirectoryDbObj, SystemDirectory>{

	@Autowired
	private SystemDirectoryDbObjMapper systemDirectoryDbObjMapper;
	
	@Override
	public List<SystemDirectoryDbObj> get(SystemDirectoryDbObjExample ex) throws RuntimeException {
		return systemDirectoryDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(SystemDirectory obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(SystemDirectory obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(SystemDirectory obj, SystemDirectoryDbObjExample ex) throws RuntimeException {
		SystemDirectoryDbObj dbObj = mapper.map(obj, SystemDirectoryDbObj.class);
		systemDirectoryDbObjMapper.updateByExampleSelective(dbObj, ex);
	}

	@Override
	public Integer deleteByExample(SystemDirectory obj, SystemDirectoryDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByExample(SystemDirectory obj, SystemDirectoryDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}