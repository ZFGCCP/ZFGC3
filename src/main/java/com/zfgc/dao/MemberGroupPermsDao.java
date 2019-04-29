package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.MemberGroupPermsDbObj;
import com.zfgc.dbobj.MemberGroupPermsDbObjExample;
import com.zfgc.mappers.MemberGroupPermsDbObjMapper;
import com.zfgc.model.users.MemberGroupPerms;

@Component
public class MemberGroupPermsDao extends AbstractDao<MemberGroupPermsDbObjExample, MemberGroupPermsDbObj, MemberGroupPerms> {

	@Autowired
	MemberGroupPermsDbObjMapper memberGroupPermsDbObjMapper;
	
	@Override
	public List<MemberGroupPermsDbObj> get(MemberGroupPermsDbObjExample ex)
			throws RuntimeException {
		return memberGroupPermsDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(MemberGroupPerms obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(MemberGroupPerms obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(MemberGroupPerms obj,
			MemberGroupPermsDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(MemberGroupPerms obj,
			MemberGroupPermsDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByExample(MemberGroupPerms obj,
			MemberGroupPermsDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

}
