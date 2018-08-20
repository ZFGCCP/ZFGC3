package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.PmConversationBoxViewDbObj;
import com.zfgc.dbobj.PmConversationBoxViewDbObjExample;
import com.zfgc.dbobj.PmConversationBoxViewDbObjWithBLOBs;
import com.zfgc.mappers.PmConversationBoxViewDbObjMapper;
import com.zfgc.model.pm.PmConversationView;

@Component
public class PmConversationBoxViewDao extends AbstractDao<PmConversationBoxViewDbObjExample, PmConversationBoxViewDbObjWithBLOBs, PmConversationView>{

	@Autowired
	PmConversationBoxViewDbObjMapper pmConversationBoxViewDbObjMapper;
	
	@Override
	public List<PmConversationBoxViewDbObjWithBLOBs> get(
			PmConversationBoxViewDbObjExample ex) throws Exception {
		return pmConversationBoxViewDbObjMapper.selectByExampleWithBLOBs(ex);
	}

	@Override
	public void hardDelete(PmConversationView obj) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public void updateOrInsert(PmConversationView obj) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void updateByExample(PmConversationView obj,
			PmConversationBoxViewDbObjExample ex) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public Integer deleteByExample(PmConversationView obj,
			PmConversationBoxViewDbObjExample ex) {
				return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer countByExample(PmConversationView obj,
			PmConversationBoxViewDbObjExample ex) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}