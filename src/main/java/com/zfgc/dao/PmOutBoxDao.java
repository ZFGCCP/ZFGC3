package com.zfgc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.OutboxViewDbObjExample;
import com.zfgc.dbobj.OutboxViewDbObjWithBLOBs;
import com.zfgc.mappers.OutboxViewDbObjMapper;
import com.zfgc.model.pm.PmBox;

@Component
public class PmOutBoxDao extends AbstractDao<OutboxViewDbObjExample, OutboxViewDbObjWithBLOBs, PmBox> {

	@Autowired
	private OutboxViewDbObjMapper outboxVewDbObjMapper;
	
	@Override
	public List<OutboxViewDbObjWithBLOBs> get(OutboxViewDbObjExample ex)
			throws RuntimeException {
		List<OutboxViewDbObjWithBLOBs> outbox = outboxVewDbObjMapper.selectByExampleWithBLOBs(ex);
		
		return outbox;
	}

	@Override
	public void hardDelete(PmBox obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(PmBox obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(PmBox obj, OutboxViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(PmBox obj, OutboxViewDbObjExample ex) throws RuntimeException {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long countByExample(PmBox obj, OutboxViewDbObjExample ex)
			throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}


}
