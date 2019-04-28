package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.PmConversationDbObj;
import com.zfgc.dbobj.PmConversationDbObjExample;
import com.zfgc.mappers.PmConversationDbObjMapper;
import com.zfgc.model.pm.PmConversation;

@Component
public class PmConversationDao extends AbstractDao<PmConversationDbObjExample, PmConversationDbObj, PmConversation> {

	@Autowired
	private PmConversationDbObjMapper pmConversationDbObjMapper;
	
	@Override
	public List<PmConversationDbObj> get(PmConversationDbObjExample ex)
			throws RuntimeException {
		return pmConversationDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(PmConversation obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(PmConversation obj) throws RuntimeException {
		PmConversationDbObj dbObj = mapper.map(obj, PmConversationDbObj.class);
		
		if(dbObj.getPmConversationId() == null){
			pmConversationDbObjMapper.insert(dbObj);
			obj.setPmConversationId(dbObj.getPmConversationId());
		}
		else{
			pmConversationDbObjMapper.updateByPrimaryKey(dbObj);
		}
		
	}

	@Override
	public void updateByExample(PmConversation obj,
			PmConversationDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(PmConversation obj,
			PmConversationDbObjExample ex) throws RuntimeException {
				return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long countByExample(PmConversation obj,
			PmConversationDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

}
