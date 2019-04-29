package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.BrMemberGroupUserDbObj;
import com.zfgc.dbobj.BrMemberGroupUserDbObjExample;
import com.zfgc.mappers.BrMemberGroupUserDbObjMapper;
import com.zfgc.model.bridge.BrMemberGroupUser;

@Component
public class BrMemberGroupUserDao extends AbstractDao<BrMemberGroupUserDbObjExample, BrMemberGroupUserDbObj, BrMemberGroupUser>{

	@Autowired
	private BrMemberGroupUserDbObjMapper brMemberGroupUserDbObjMapper;
	
	@Override
	public List<BrMemberGroupUserDbObj> get(BrMemberGroupUserDbObjExample ex)
			throws RuntimeException {
		return brMemberGroupUserDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(BrMemberGroupUser obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(BrMemberGroupUser obj) throws RuntimeException {
		BrMemberGroupUserDbObj dbObj = mapper.map(obj, BrMemberGroupUserDbObj.class);
		brMemberGroupUserDbObjMapper.insert(dbObj);
	}

	@Override
	public void updateByExample(BrMemberGroupUser obj,
			BrMemberGroupUserDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(BrMemberGroupUser obj,
			BrMemberGroupUserDbObjExample ex) throws RuntimeException {
		return brMemberGroupUserDbObjMapper.deleteByExample(ex);
	}

	@Override
	public Long countByExample(BrMemberGroupUser obj,
			BrMemberGroupUserDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}