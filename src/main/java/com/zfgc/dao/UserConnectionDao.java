package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.UserConnectionDbObj;
import com.zfgc.dbobj.UserConnectionDbObjExample;
import com.zfgc.mappers.UserConnectionDbObjMapper;
import com.zfgc.model.users.UserConnection;

@Component
public class UserConnectionDao extends AbstractDao<UserConnectionDbObjExample, UserConnectionDbObj, UserConnection>{

	@Autowired
	private UserConnectionDbObjMapper userConnectionDbObjMapper;
	
	@Override
	public List<UserConnectionDbObj> get(UserConnectionDbObjExample ex)
			throws RuntimeException {
		return userConnectionDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(UserConnection obj) throws RuntimeException {
		userConnectionDbObjMapper.deleteByPrimaryKey(obj.getUserConnectionId());
	}

	@Override
	public void updateOrInsert(UserConnection obj) throws RuntimeException {
		UserConnectionDbObj dbObj = mapper.map(obj, UserConnectionDbObj.class);
		
		if(dbObj.getUserConnectionId() == -1){
			userConnectionDbObjMapper.insert(dbObj);
			obj.setUserConnectionId(dbObj.getUserConnectionId());
		}
		else{
			userConnectionDbObjMapper.updateByPrimaryKey(dbObj);
		}
		
	}

	@Override
	public void updateByExample(UserConnection obj,
			UserConnectionDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(UserConnection obj,
			UserConnectionDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByExample(UserConnection obj, UserConnectionDbObjExample ex)
			throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}