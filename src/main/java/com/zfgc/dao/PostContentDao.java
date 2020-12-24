package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.PostContentDbObj;
import com.zfgc.dbobj.PostContentDbObjExample;
import com.zfgc.mappers.PostContentDbObjMapper;
import com.zfgc.model.forum.PostContent;

@Component
public class PostContentDao extends AbstractDao<PostContentDbObjExample, PostContentDbObj, PostContent>{

	@Autowired
	private PostContentDbObjMapper postContentDbObjMapper;
	
	@Override
	public List<PostContentDbObj> get(PostContentDbObjExample ex) throws RuntimeException {
		return postContentDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(PostContent obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(PostContent obj) throws RuntimeException {
		PostContentDbObj dbObj = mapper.map(obj, PostContentDbObj.class);
		if(dbObj.getPostContentId() == null || dbObj.getPostContentId().equals(-1)) {
			postContentDbObjMapper.insert(dbObj);
		}
		else {
			postContentDbObjMapper.updateByPrimaryKey(dbObj);
		}
		
		obj = mapper.map(dbObj, PostContent.class);
	}

	@Override
	public void updateByExample(PostContent obj, PostContentDbObjExample ex) throws RuntimeException {
		PostContentDbObj dbObj = mapper.map(obj, PostContentDbObj.class);
		postContentDbObjMapper.updateByPrimaryKeySelective(dbObj);
	}

	@Override
	public Integer deleteByExample(PostContent obj, PostContentDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByExample(PostContent obj, PostContentDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}