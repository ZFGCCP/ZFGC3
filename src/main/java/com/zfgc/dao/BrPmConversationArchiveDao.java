package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.BrPmConversationArchiveDbObj;
import com.zfgc.dbobj.BrPmConversationArchiveDbObjExample;
import com.zfgc.mappers.BrPmConversationArchiveDbObjMapper;
import com.zfgc.model.pm.BrPmConversationArchive;

@Component
public class BrPmConversationArchiveDao extends AbstractDao<BrPmConversationArchiveDbObjExample, BrPmConversationArchiveDbObj,BrPmConversationArchive>{

	@Autowired
	private BrPmConversationArchiveDbObjMapper dbObjMapper;
	
	@Override
	public List<BrPmConversationArchiveDbObj> get(
			BrPmConversationArchiveDbObjExample ex) throws Exception {
		// TODO Auto-generated method stub
		try {
			return dbObjMapper.selectByExample(ex);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void hardDelete(BrPmConversationArchive obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(BrPmConversationArchive obj) {
		BrPmConversationArchiveDbObj dbObj = mapper.map(obj, BrPmConversationArchiveDbObj.class);
		
		dbObjMapper.insert(dbObj);
	}

	@Override
	public void updateByExample(BrPmConversationArchive obj,
			BrPmConversationArchiveDbObjExample ex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(BrPmConversationArchive obj,
			BrPmConversationArchiveDbObjExample ex) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
