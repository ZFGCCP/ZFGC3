package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.UserViewingForumViewDbObj;
import com.zfgc.dbobj.UserViewingForumViewDbObjExample;
import com.zfgc.mappers.UserViewingForumViewDbObjMapper;
import com.zfgc.model.users.UserViewingForumView;

@Component
public class UserViewingForumViewDao extends AbstractDao<UserViewingForumViewDbObjExample, UserViewingForumViewDbObj, UserViewingForumView>{

	@Autowired
	private UserViewingForumViewDbObjMapper userViewingForumViewDbObjMapper;
	
	@Override
	public List<UserViewingForumViewDbObj> get(UserViewingForumViewDbObjExample ex) throws RuntimeException {
		return userViewingForumViewDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(UserViewingForumView obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(UserViewingForumView obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(UserViewingForumView obj, UserViewingForumViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(UserViewingForumView obj, UserViewingForumViewDbObjExample ex)
			throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByExample(UserViewingForumView obj, UserViewingForumViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}