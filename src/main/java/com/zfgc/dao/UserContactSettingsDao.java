package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.UserContactSettingsDbObj;
import com.zfgc.dbobj.UserContactSettingsDbObjExample;
import com.zfgc.mappers.UserContactSettingsDbObjMapper;
import com.zfgc.model.users.UserContactInfo;

@Component
public class UserContactSettingsDao extends AbstractDao<UserContactSettingsDbObjExample, UserContactSettingsDbObj, UserContactInfo>{

	@Autowired
	private UserContactSettingsDbObjMapper userContactSettingsDbObjMapper;
	
	@Override
	public List<UserContactSettingsDbObj> get(UserContactSettingsDbObjExample ex)
			throws RuntimeException {
		return userContactSettingsDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(UserContactInfo obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(UserContactInfo obj) throws RuntimeException {
		UserContactSettingsDbObj data = mapper.map(obj, UserContactSettingsDbObj.class);
		data.setEmailAddressId(obj.getEmail().getEmailAddressId());
		
		if(obj.getUserContactSettingsId() == null || obj.getUserContactSettingsId() == -1) {
			userContactSettingsDbObjMapper.insert(data);
			obj.setUserContactSettingsId(data.getUserContactSettingsId());
		}
		else {
			userContactSettingsDbObjMapper.updateByPrimaryKey(data);
		}
		
	}

	@Override
	public void updateByExample(UserContactInfo obj,
			UserContactSettingsDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(UserContactInfo obj,
			UserContactSettingsDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByExample(UserContactInfo obj,
			UserContactSettingsDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}