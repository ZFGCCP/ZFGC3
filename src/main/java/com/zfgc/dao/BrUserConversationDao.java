package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.BrUserConversationDbObjExample;
import com.zfgc.dbobj.BrUserConversationDbObjKey;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.mappers.BrUserConversationDbObjMapper;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.pm.BrUserConversation;

@Component
public class BrUserConversationDao extends AbstractDao<BrUserConversationDbObjExample,BrUserConversationDbObjKey,BrUserConversation>{

	@Autowired
	BrUserConversationDbObjMapper dbObjMapper;
	
	@Override
	public List<BrUserConversationDbObjKey> get(
			BrUserConversationDbObjExample ex) throws Exception {
		return dbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(BrUserConversation obj) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateOrInsert(BrUserConversation obj) {
		BrUserConversationDbObjKey dbObj = mapper.map(obj, BrUserConversationDbObjKey.class);
		dbObjMapper.insert(dbObj);
	}

	@Override
	public void updateByExample(BrUserConversation obj,
			BrUserConversationDbObjExample ex) {
		// TODO Auto-generated method stub
		
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
	
}