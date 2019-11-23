package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.UserPasswordResetViewDbObj;
import com.zfgc.dbobj.UserPasswordResetViewDbObjExample;
import com.zfgc.mappers.UserPasswordResetViewDbObjMapper;
import com.zfgc.model.users.NewPassword;

@Component
public class UserPasswordResetViewDao extends AbstractDao<UserPasswordResetViewDbObjExample, UserPasswordResetViewDbObj, NewPassword>{

	@Autowired
	private UserPasswordResetViewDbObjMapper userPasswordResetViewDbObjMapper;
	
	@Override
	public List<UserPasswordResetViewDbObj> get(UserPasswordResetViewDbObjExample ex) throws RuntimeException {
		return userPasswordResetViewDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(NewPassword obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(NewPassword obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(NewPassword obj, UserPasswordResetViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(NewPassword obj, UserPasswordResetViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByExample(NewPassword obj, UserPasswordResetViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}