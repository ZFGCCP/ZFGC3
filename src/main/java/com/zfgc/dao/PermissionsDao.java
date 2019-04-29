package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.PermissionsDbObj;
import com.zfgc.dbobj.PermissionsDbObjExample;
import com.zfgc.mappers.PermissionsDbObjMapper;
import com.zfgc.model.users.Permissions;

@Component
public class PermissionsDao extends AbstractDao<PermissionsDbObjExample, PermissionsDbObj, Permissions>{

	@Autowired
	PermissionsDbObjMapper permissionsDbObjMapper;
	
	@Override
	public List<PermissionsDbObj> get(PermissionsDbObjExample ex)
			throws RuntimeException {
		return permissionsDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(Permissions obj) throws RuntimeException {
		
		
	}

	@Override
	public void updateOrInsert(Permissions obj) throws RuntimeException {
		PermissionsDbObj dbObj = mapper.map(obj, PermissionsDbObj.class);
		permissionsDbObjMapper.insert(dbObj);
	}

	@Override
	public void updateByExample(Permissions obj, PermissionsDbObjExample ex)
			throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(Permissions obj, PermissionsDbObjExample ex)
			throws RuntimeException {
		return permissionsDbObjMapper.deleteByExample(ex);
	}

	@Override
	public Long countByExample(Permissions obj, PermissionsDbObjExample ex)
			throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}