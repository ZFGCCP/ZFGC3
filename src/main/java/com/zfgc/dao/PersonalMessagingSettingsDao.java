package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.PersonalMessagingSettingsDbObj;
import com.zfgc.dbobj.PersonalMessagingSettingsDbObjExample;
import com.zfgc.mappers.PersonalMessagingSettingsDbObjMapper;
import com.zfgc.model.users.profile.PersonalMessagingSettings;

@Component
public class PersonalMessagingSettingsDao extends AbstractDao<PersonalMessagingSettingsDbObjExample, PersonalMessagingSettingsDbObj, PersonalMessagingSettings>{

	@Autowired
	private PersonalMessagingSettingsDbObjMapper personalMessagingSettingsDbObjMapper;
	
	@Override
	public List<PersonalMessagingSettingsDbObj> get(
			PersonalMessagingSettingsDbObjExample ex) throws RuntimeException {
		return personalMessagingSettingsDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(PersonalMessagingSettings obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(PersonalMessagingSettings obj) throws RuntimeException {
		PersonalMessagingSettingsDbObj dbObj = mapper.map(obj, PersonalMessagingSettingsDbObj.class);
		if(obj.getPersonalMessagingSettingsId() == null || obj.getPersonalMessagingSettingsId() == -1){
			personalMessagingSettingsDbObjMapper.insert(dbObj);
			obj.setPersonalMessagingSettingsId(dbObj.getPersonalMessagingSettingsId());
		}
		else{
			personalMessagingSettingsDbObjMapper.updateByPrimaryKey(dbObj);
		}
		
	}

	@Override
	public void updateByExample(PersonalMessagingSettings obj,
			PersonalMessagingSettingsDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(PersonalMessagingSettings obj,
			PersonalMessagingSettingsDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByExample(PersonalMessagingSettings obj,
			PersonalMessagingSettingsDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}