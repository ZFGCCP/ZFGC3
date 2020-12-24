package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.BrForumPermissionsDbObj;
import com.zfgc.dbobj.BrForumPermissionsDbObjExample;
import com.zfgc.mappers.BrForumPermissionsDbObjMapper;
import com.zfgc.model.users.permissions.BrForumPermissions;

@Component
public class BrForumPermissionsDao extends AbstractDao<BrForumPermissionsDbObjExample, BrForumPermissionsDbObj, BrForumPermissions>{

	@Autowired
	private BrForumPermissionsDbObjMapper brForumPermissionsDbObjMapper;
	
	@Override
	public List<BrForumPermissionsDbObj> get(BrForumPermissionsDbObjExample ex) throws RuntimeException {
		return brForumPermissionsDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(BrForumPermissions obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(BrForumPermissions obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(BrForumPermissions obj, BrForumPermissionsDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(BrForumPermissions obj, BrForumPermissionsDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByExample(BrForumPermissions obj, BrForumPermissionsDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}