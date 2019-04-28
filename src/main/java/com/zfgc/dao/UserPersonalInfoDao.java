package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.UserPersonalInfoDbObj;
import com.zfgc.dbobj.UserPersonalInfoDbObjExample;
import com.zfgc.mappers.UserPersonalInfoDbObjMapper;
import com.zfgc.model.users.profile.PersonalInfo;

@Component
public class UserPersonalInfoDao extends AbstractDao<UserPersonalInfoDbObjExample, UserPersonalInfoDbObj, PersonalInfo>{

	@Autowired
	UserPersonalInfoDbObjMapper userPersonalInfoDbObjMapper;
	
	@Override
	public List<UserPersonalInfoDbObj> get(UserPersonalInfoDbObjExample ex)
			throws RuntimeException {
		return userPersonalInfoDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(PersonalInfo obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(PersonalInfo obj) throws RuntimeException {
		UserPersonalInfoDbObj dbObj = mapper.map(obj,UserPersonalInfoDbObj.class);
		if(obj.getUserPersonalInfoId() == null || obj.getUserPersonalInfoId() == -1){
			userPersonalInfoDbObjMapper.insert(dbObj);
			obj.setUserPersonalInfoId(dbObj.getUserPersonalInfoId());
		}
		else{
			userPersonalInfoDbObjMapper.updateByPrimaryKey(dbObj);
		}
		
	}

	@Override
	public void updateByExample(PersonalInfo obj,
			UserPersonalInfoDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(PersonalInfo obj,
			UserPersonalInfoDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByExample(PersonalInfo obj,
			UserPersonalInfoDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}