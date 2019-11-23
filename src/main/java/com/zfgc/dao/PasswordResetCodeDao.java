package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.PasswordResetCodeDbObj;
import com.zfgc.dbobj.PasswordResetCodeDbObjExample;
import com.zfgc.mappers.PasswordResetCodeDbObjMapper;
import com.zfgc.model.users.PasswordResetCode;

@Component
public class PasswordResetCodeDao extends AbstractDao<PasswordResetCodeDbObjExample, PasswordResetCodeDbObj, PasswordResetCode>{

	@Autowired
	private PasswordResetCodeDbObjMapper passwordResetCodeDbObjMapper;
	
	@Override
	public List<PasswordResetCodeDbObj> get(PasswordResetCodeDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return passwordResetCodeDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(PasswordResetCode obj) throws RuntimeException {
		passwordResetCodeDbObjMapper.deleteByPrimaryKey(obj.getPasswordResetCodeId());
	}

	@Override
	public void updateOrInsert(PasswordResetCode obj) throws RuntimeException {
		PasswordResetCodeDbObj dbObj = mapper.map(obj, PasswordResetCodeDbObj.class);
		passwordResetCodeDbObjMapper.insert(dbObj);
		obj.setPasswordResetCodeId(dbObj.getPasswordResetCodeId());
	}

	@Override
	public void updateByExample(PasswordResetCode obj, PasswordResetCodeDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(PasswordResetCode obj, PasswordResetCodeDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByExample(PasswordResetCode obj, PasswordResetCodeDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}