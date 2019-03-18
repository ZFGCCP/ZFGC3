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
	public List<PersonalMessageDbObjWithBLOBs> get(PersonalMessageDbObjExample ex) throws RuntimeException{
		try {
			return personalMessageDbObjMapper.selectByExampleWithBLOBs(ex);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void hardDelete(PersonalMessage obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(PersonalMessage obj) throws RuntimeException {
		PersonalMessageDbObjWithBLOBs dbObj = mapper.map(obj, PersonalMessageDbObjWithBLOBs.class);
		
		if(dbObj.getPersonalMessageId() == null || dbObj.getPersonalMessageId() == -1){
			personalMessageDbObjMapper.insert(dbObj);
		}
	}

	@Override
	public void updateByExample(PersonalMessage obj,
			PersonalMessageDbObjExample ex) throws RuntimeException {
		PersonalMessageDbObjWithBLOBs dbObj = mapper.map(obj, PersonalMessageDbObjWithBLOBs.class);
		
		personalMessageDbObjMapper.updateByExample(dbObj, ex);
		
	}

	@Override
	public Integer deleteByExample(PersonalMessage obj,
			PersonalMessageDbObjExample ex) throws RuntimeException {
				return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer countByExample(PersonalMessage obj,
			PersonalMessageDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

}
