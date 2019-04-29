package com.zfgc.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.EmailAddressDao;
import com.zfgc.model.users.EmailAddress;

@Component
public class EmailAddressDataProvider extends AbstractDataProvider{
	@Autowired
	private EmailAddressDao emailAddressDao;
	
	public EmailAddress createNewEmail(EmailAddress email) throws Exception {
		emailAddressDao.updateOrInsert(email);
		return email;
	}
}