package com.zfgc.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.PersonalMessageDao;
import com.zfgc.model.pm.PersonalMessage;

@Component
public class PersonalMessageDataProvider extends AbstractDataProvider {

	@Autowired
	PersonalMessageDao personalMessageDao;
	
	public void saveMessage(PersonalMessage pm){
		personalMessageDao.updateOrInsert(pm);
	}
}
