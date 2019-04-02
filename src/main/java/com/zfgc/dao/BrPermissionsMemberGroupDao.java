package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.BrPermissionsMemberGroupDbObjExample;
import com.zfgc.dbobj.BrPermissionsMemberGroupDbObjKey;
import com.zfgc.mappers.BrPermissionsMemberGroupDbObjMapper;
import com.zfgc.model.users.BrPermissionsMemberGroup;

@Component
public class BrPermissionsMemberGroupDao extends AbstractDao<BrPermissionsMemberGroupDbObjExample, BrPermissionsMemberGroupDbObjKey, BrPermissionsMemberGroup>{

	@Autowired
	BrPermissionsMemberGroupDbObjMapper brPermissionsMemberGroupDbObjMapper;
	
	@Override
	public List<BrPermissionsMemberGroupDbObjKey> get(
			BrPermissionsMemberGroupDbObjExample ex) throws RuntimeException {
		return brPermissionsMemberGroupDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(BrPermissionsMemberGroup obj)
			throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(BrPermissionsMemberGroup obj)
			throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(BrPermissionsMemberGroup obj,
			BrPermissionsMemberGroupDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(BrPermissionsMemberGroup obj,
			BrPermissionsMemberGroupDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countByExample(BrPermissionsMemberGroup obj,
			BrPermissionsMemberGroupDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}