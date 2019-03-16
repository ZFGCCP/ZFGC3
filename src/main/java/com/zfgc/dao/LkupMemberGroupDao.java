package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.LkupMemberGroupDbObj;
import com.zfgc.dbobj.LkupMemberGroupDbObjExample;
import com.zfgc.mappers.LkupMemberGroupDbObjMapper;
import com.zfgc.model.lkup.LkupMemberGroup;

@Component
public class LkupMemberGroupDao extends AbstractDao<LkupMemberGroupDbObjExample, LkupMemberGroupDbObj, LkupMemberGroup>{

	@Autowired
	LkupMemberGroupDbObjMapper lkupMemberGroupDbObjMapper;
	
	@Override
	public List<LkupMemberGroupDbObj> get(LkupMemberGroupDbObjExample ex) throws Exception {
		return lkupMemberGroupDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(LkupMemberGroup obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(LkupMemberGroup obj) throws Exception {
		LkupMemberGroupDbObj dbObj = mapper.map(obj, LkupMemberGroupDbObj.class);
		
		if(dbObj.getMemberGroupId() == -1) {
			lkupMemberGroupDbObjMapper.insert(dbObj);
			obj.setMemberGroupId(dbObj.getMemberGroupId());
		}
		else {
			lkupMemberGroupDbObjMapper.updateByPrimaryKey(dbObj);
		}
		
	}

	@Override
	public void updateByExample(LkupMemberGroup obj, LkupMemberGroupDbObjExample ex) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(LkupMemberGroup obj, LkupMemberGroupDbObjExample ex) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countByExample(LkupMemberGroup obj, LkupMemberGroupDbObjExample ex) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}