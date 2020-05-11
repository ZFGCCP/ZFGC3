package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.ThreadPostDbObj;
import com.zfgc.dbobj.ThreadPostDbObjExample;
import com.zfgc.mappers.ThreadPostDbObjMapper;
import com.zfgc.model.forum.ThreadPost;

@Component
public class ThreadPostDao extends AbstractDao<ThreadPostDbObjExample, ThreadPostDbObj, ThreadPost>{

	@Autowired
	private ThreadPostDbObjMapper threadPostDbObjMapper;
	
	@Override
	public List<ThreadPostDbObj> get(ThreadPostDbObjExample ex) throws RuntimeException {
		return threadPostDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(ThreadPost obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(ThreadPost obj) throws RuntimeException {
		ThreadPostDbObj dbObj = mapper.map(obj, ThreadPostDbObj.class);
		
		if(dbObj.getThreadPostId() == null || dbObj.getThreadPostId().equals(-1)) {
			threadPostDbObjMapper.insert(dbObj);
		}
		else {
			threadPostDbObjMapper.updateByPrimaryKey(dbObj);
		}
		
		obj.setThreadPostId(dbObj.getThreadPostId());
		
	}

	@Override
	public void updateByExample(ThreadPost obj, ThreadPostDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(ThreadPost obj, ThreadPostDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByExample(ThreadPost obj, ThreadPostDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}