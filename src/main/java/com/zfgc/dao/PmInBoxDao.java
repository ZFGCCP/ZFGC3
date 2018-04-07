package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.InboxViewDbObjExample;
import com.zfgc.dbobj.InboxViewDbObjWithBLOBs;
import com.zfgc.dbobj.OutboxViewDbObjWithBLOBs;
import com.zfgc.mappers.InboxViewDbObjMapper;
import com.zfgc.model.pm.PmBox;

@Component
public class PmInBoxDao extends AbstractDao<InboxViewDbObjExample,InboxViewDbObjWithBLOBs,PmBox>{

	@Autowired
	private InboxViewDbObjMapper inboxViewDbObjMapper;
	
	@Override
	public List<InboxViewDbObjWithBLOBs> get(InboxViewDbObjExample ex)
			throws Exception {
		List<InboxViewDbObjWithBLOBs> inbox = inboxViewDbObjMapper.selectByExampleWithBLOBs(ex);
		
		return inbox;
	}

	@Override
	public void hardDelete(PmBox obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(PmBox obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(PmBox obj, InboxViewDbObjExample ex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(PmBox obj, InboxViewDbObjExample ex) {
		return null;
		// TODO Auto-generated method stub
		
	}

}
