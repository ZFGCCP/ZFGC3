package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.BrUserConversationDbObjExample;
import com.zfgc.dbobj.BrUserConversationDbObjKey;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.mappers.BrUserConversationDbObjMapper;
import com.zfgc.model.BaseZfgcModel;

@Component
public class BrUserConversationDao extends AbstractDao<BrUserConversationDbObjExample,BrUserConversationDbObjKey,BaseZfgcModel>{

	@Autowired
	BrUserConversationDbObjMapper dbObjMapper;
	
	@Override
	public List<BrUserConversationDbObjKey> get(
			BrUserConversationDbObjExample ex) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void hardDelete(BaseZfgcModel obj) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateOrInsert(BaseZfgcModel obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(BaseZfgcModel obj,
			BrUserConversationDbObjExample ex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(BaseZfgcModel obj,
			BrUserConversationDbObjExample ex) throws Exception, ZfgcNotFoundException {
		
		Integer resultCount = dbObjMapper.deleteByExample(ex);
		
		if(resultCount == 0){
			throw new ZfgcNotFoundException("Conversation");
		}
		
		return resultCount;
	}
	
}