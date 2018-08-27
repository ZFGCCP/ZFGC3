package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.BrUserConversationDbObj;
import com.zfgc.dbobj.BrUserConversationDbObjExample;
import com.zfgc.dbobj.BrUserConversationDbObjKey;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.mappers.BrUserConversationDbObjMapper;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.pm.BrUserConversation;

@Component
public class BrUserConversationDao extends AbstractDao<BrUserConversationDbObjExample,BrUserConversationDbObj,BrUserConversation>{

	@Autowired
	BrUserConversationDbObjMapper dbObjMapper;
	
	@Override
	public List<BrUserConversationDbObj> get(
			BrUserConversationDbObjExample ex) throws Exception {
		return dbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(BrUserConversation obj) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateOrInsert(BrUserConversation obj) {
		BrUserConversationDbObj dbObj = mapper.map(obj, BrUserConversationDbObj.class);
		dbObjMapper.insert(dbObj);
	}

	@Override
	public void updateByExample(BrUserConversation obj,
			BrUserConversationDbObjExample ex) throws Exception {
		try{
			BrUserConversationDbObj dbObj = mapper.map(obj, BrUserConversationDbObj.class);
			dbObjMapper.updateByExample(dbObj, ex);
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public Integer deleteByExample(BrUserConversation obj,
			BrUserConversationDbObjExample ex) throws Exception, ZfgcNotFoundException {
		
		Integer resultCount = dbObjMapper.deleteByExample(ex);
		
		if(resultCount == 0){
			throw new ZfgcNotFoundException("Conversation");
		}
		
		return resultCount;
	}

	@Override
	public Integer countByExample(BrUserConversation obj,
			BrUserConversationDbObjExample ex) throws Exception {
		try{
			return dbObjMapper.countByExample(ex);
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
}