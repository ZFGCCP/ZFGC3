package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.PollDbObj;
import com.zfgc.dbobj.PollDbObjExample;
import com.zfgc.mappers.PollDbObjMapper;
import com.zfgc.model.forum.Poll;

@Component
public class PollDao extends AbstractDao<PollDbObjExample, PollDbObj, Poll>{

	@Autowired
	private PollDbObjMapper pollDbObjMapper;
	
	@Override
	public List<PollDbObj> get(PollDbObjExample ex) throws RuntimeException {
		return pollDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(Poll obj) throws RuntimeException {
		pollDbObjMapper.deleteByPrimaryKey(obj.getPollId());
	}

	@Override
	public void updateOrInsert(Poll obj) throws RuntimeException {
		PollDbObj dbObj = mapper.map(obj, PollDbObj.class);
		if(dbObj.getPollId() == null || dbObj.getPollId() == -1) {
			pollDbObjMapper.insert(dbObj);
			obj.setPollId(dbObj.getPollId());
		}
		else {
			pollDbObjMapper.updateByPrimaryKey(dbObj);
		}
		
	}

	@Override
	public void updateByExample(Poll obj, PollDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(Poll obj, PollDbObjExample ex) throws RuntimeException {
		return pollDbObjMapper.deleteByExample(ex);
	}

	@Override
	public Long countByExample(Poll obj, PollDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}