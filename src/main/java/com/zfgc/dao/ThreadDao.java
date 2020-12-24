package com.zfgc.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.zfgc.model.forum.Thread;
import com.zfgc.dbobj.ForumDbObj;
import com.zfgc.dbobj.ThreadDbObj;
import com.zfgc.dbobj.ThreadDbObjExample;
import com.zfgc.mappers.ThreadDbObjMapper;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.Users;

@Component
public class ThreadDao extends AbstractDao<ThreadDbObjExample, ThreadDbObj, Thread> {
	private Logger LOGGER = LogManager.getLogger(ThreadDao.class);
	
	@Autowired
	ThreadDbObjMapper threadDbObjMapper;
	
	
	@Override
	public List<ThreadDbObj> get(ThreadDbObjExample ex) throws RuntimeException {
		return threadDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(Thread obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(Thread obj) throws RuntimeException {
		ThreadDbObj dbObj = mapper.map(obj, ThreadDbObj.class);
		if(dbObj.getThreadId() == null || dbObj.getThreadId().equals(-1)) {
			threadDbObjMapper.insert(dbObj);
		}
		else {
			threadDbObjMapper.updateByPrimaryKey(dbObj);
		}
		
		obj.setThreadId(dbObj.getThreadId());
		
	}

	@Override
	public void updateByExample(Thread obj, ThreadDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(Thread obj, ThreadDbObjExample ex) throws RuntimeException {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long countByExample(Thread obj, ThreadDbObjExample ex)
			throws RuntimeException {
		return (long) threadDbObjMapper.countByExample(ex);
	}
}
