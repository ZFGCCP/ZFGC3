package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.UserSecuritySettingsDbObj;
import com.zfgc.dbobj.UserSecuritySettingsDbObjExample;
import com.zfgc.mappers.UserSecuritySettingsDbObjMapper;
import com.zfgc.model.users.UserSecurityInfo;

@Component
public class UserSecuritySettingsDao extends AbstractDao<UserSecuritySettingsDbObjExample,UserSecuritySettingsDbObj,UserSecurityInfo>{

	@Autowired
	private UserSecuritySettingsDbObjMapper userSecuritySettingsDbObjMapper;
	
	public void updateUserPassword(Integer usersId, String password) throws Exception{
		userSecuritySettingsDbObjMapper.updateUserPassword(usersId, password);
	}
	
	@Override
	public List<UserSecuritySettingsDbObj> get(UserSecuritySettingsDbObjExample ex) throws RuntimeException {
		return userSecuritySettingsDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(UserSecurityInfo obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(UserSecurityInfo obj) throws RuntimeException {
		UserSecuritySettingsDbObj dbObj = mapper.map(obj, UserSecuritySettingsDbObj.class);
		
		if(obj.getUserSecuritySettingsId() == null || obj.getUserSecuritySettingsId() == -1) {
			userSecuritySettingsDbObjMapper.insert(dbObj);
			obj.setUserSecuritySettingsId(dbObj.getUserSecuritySettingsId());
		}
		else {
			userSecuritySettingsDbObjMapper.updateByPrimaryKey(dbObj);
		}
		
	}

	@Override
	public void updateByExample(UserSecurityInfo obj, UserSecuritySettingsDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(UserSecurityInfo obj, UserSecuritySettingsDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countByExample(UserSecurityInfo obj, UserSecuritySettingsDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}