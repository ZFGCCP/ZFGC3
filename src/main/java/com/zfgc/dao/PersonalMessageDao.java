package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.PersonalMessageDbObj;
import com.zfgc.dbobj.PersonalMessageDbObjExample;
import com.zfgc.dbobj.PersonalMessageDbObjWithBLOBs;
import com.zfgc.mappers.PersonalMessageDbObjMapper;
import com.zfgc.model.pm.PersonalMessage;

@Component
public class PersonalMessageDao extends AbstractDao<PersonalMessageDbObjExample, PersonalMessageDbObjWithBLOBs, PersonalMessage>{

	@Autowired
	PersonalMessageDbObjMapper personalMessageDbObjMapper;
	
	@Override
	public List<PersonalMessageDbObjWithBLOBs> get(PersonalMessageDbObjExample ex) {
		return personalMessageDbObjMapper.selectByExampleWithBLOBs(ex);
	}

	@Override
	public void hardDelete(PersonalMessage obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(PersonalMessage obj) {
		PersonalMessageDbObjWithBLOBs dbObj = mapper.map(obj, PersonalMessageDbObjWithBLOBs.class);
		
		if(dbObj.getPersonalMessageId() == null || dbObj.getPersonalMessageId() == -1){
			personalMessageDbObjMapper.insert(dbObj);
		}
		else{
			personalMessageDbObjMapper.updateByPrimaryKey(dbObj);
		}
		
	}

	@Override
	public void updateByExample(PersonalMessage obj,
			PersonalMessageDbObjExample ex) {
		PersonalMessageDbObjWithBLOBs dbObj = mapper.map(obj, PersonalMessageDbObjWithBLOBs.class);
		
		personalMessageDbObjMapper.updateByExample(dbObj, ex);
		
	}

	@Override
	public Integer deleteByExample(PersonalMessage obj,
			PersonalMessageDbObjExample ex) {
				return null;
		// TODO Auto-generated method stub
		
	}

}
