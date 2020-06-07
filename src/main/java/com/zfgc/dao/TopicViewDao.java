package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.TopicViewDbObj;
import com.zfgc.dbobj.TopicViewDbObjExample;
import com.zfgc.mappers.TopicViewDbObjMapper;
import com.zfgc.model.forum.Topic;

@Component
public class TopicViewDao extends AbstractDao<TopicViewDbObjExample, TopicViewDbObj, Topic>{

	@Autowired
	private TopicViewDbObjMapper topicViewDbObjMapper;
	
	@Override
	public List<TopicViewDbObj> get(TopicViewDbObjExample ex) throws RuntimeException {
		return topicViewDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(Topic obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(Topic obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(Topic obj, TopicViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(Topic obj, TopicViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByExample(Topic obj, TopicViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}