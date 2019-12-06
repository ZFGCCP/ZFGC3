package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.UserEmailViewDbObj;
import com.zfgc.dbobj.UserEmailViewDbObjExample;
import com.zfgc.mappers.UserEmailViewDbObjMapper;
import com.zfgc.model.users.UserEmailView;

@Component
public class UserEmailViewDao extends AbstractDao<UserEmailViewDbObjExample, UserEmailViewDbObj, UserEmailView>{

	@Autowired
	private UserEmailViewDbObjMapper userEmailViewDbObjMapper;
	
	@Override
	public List<UserEmailViewDbObj> get(UserEmailViewDbObjExample ex) throws RuntimeException {
		return userEmailViewDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(UserEmailView obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(UserEmailView obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(UserEmailView obj, UserEmailViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(UserEmailView obj, UserEmailViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByExample(UserEmailView obj, UserEmailViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}