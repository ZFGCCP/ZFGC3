package com.zfgc.dataprovider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.EmailAddressDao;
import com.zfgc.dbobj.EmailAddressDbObj;
import com.zfgc.dbobj.EmailAddressDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.users.EmailAddress;

@Component
public class EmailAddressDataProvider extends AbstractDataProvider{
	@Autowired
	private EmailAddressDao emailAddressDao;
	
	public EmailAddress createNewEmail(EmailAddress email) {
		emailAddressDao.updateOrInsert(email);
		return email;
	}
	
	public EmailAddress getEmail(Integer addressId) {
		EmailAddressDbObjExample ex = emailAddressDao.getExample();
		ex.createCriteria().andEmailAddressIdEqualTo(addressId);
		
		List<EmailAddressDbObj> emails = emailAddressDao.get(ex);
		
		if(emails.size() > 0) {
			return mapper.map(emails.get(0), EmailAddress.class);
		}
		
		throw new ZfgcNotFoundException("Email " + addressId);
	}
}