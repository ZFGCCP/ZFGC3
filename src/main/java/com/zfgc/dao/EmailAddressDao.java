package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.EmailAddressDbObj;
import com.zfgc.dbobj.EmailAddressDbObjExample;
import com.zfgc.mappers.EmailAddressDbObjMapper;
import com.zfgc.model.users.EmailAddress;

@Component
public class EmailAddressDao extends AbstractDao<EmailAddressDbObjExample, EmailAddressDbObj, EmailAddress>{

	@Autowired
	private EmailAddressDbObjMapper emailAddressDbObjMapper;
	
	@Override
	public List<EmailAddressDbObj> get(EmailAddressDbObjExample ex) throws Exception {
		return emailAddressDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(EmailAddress obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(EmailAddress obj) throws Exception {
		EmailAddressDbObj dbObj = mapper.map(obj, EmailAddressDbObj.class);
		if(obj.getEmailAddressId() == null || obj.getEmailAddressId() == -1) {
			emailAddressDbObjMapper.insert(dbObj);
			obj.setEmailAddressId(dbObj.getEmailAddressId());
		}
		else {
			EmailAddressDbObjExample ex = new EmailAddressDbObjExample();
			ex.createCriteria().andEmailAddressIdEqualTo(obj.getEmailAddressId());
			emailAddressDbObjMapper.updateByExample(dbObj, ex);
		}
	}

	@Override
	public void updateByExample(EmailAddress obj, EmailAddressDbObjExample ex) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(EmailAddress obj, EmailAddressDbObjExample ex) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countByExample(EmailAddress obj, EmailAddressDbObjExample ex) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}