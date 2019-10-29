package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.UserPermissionViewDbObj;
import com.zfgc.dbobj.UserPermissionViewDbObjExample;
import com.zfgc.mappers.UserPermissionViewDbObjMapper;
import com.zfgc.model.users.UserPermissionView;

@Component
public class UserPermissionViewDao extends AbstractDao<UserPermissionViewDbObjExample,  UserPermissionViewDbObj, UserPermissionView>{

	@Autowired
	private UserPermissionViewDbObjMapper userPermissionViewDbObjMapper;
	
	@Override
	public List<UserPermissionViewDbObj> get(UserPermissionViewDbObjExample ex) throws RuntimeException {
		return userPermissionViewDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(UserPermissionView obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(UserPermissionView obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(UserPermissionView obj, UserPermissionViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(UserPermissionView obj, UserPermissionViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByExample(UserPermissionView obj, UserPermissionViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}