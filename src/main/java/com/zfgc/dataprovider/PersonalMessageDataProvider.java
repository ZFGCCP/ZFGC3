package com.zfgc.dataprovider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.PersonalMessageDao;
import com.zfgc.dbobj.PersonalMessageDbObj;
import com.zfgc.dbobj.PersonalMessageDbObjExample;
import com.zfgc.dbobj.PersonalMessageDbObjWithBLOBs;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.pm.PersonalMessage;
import com.zfgc.model.users.Users;

@Component
public class PersonalMessageDataProvider extends AbstractDataProvider {

	@Autowired
	PersonalMessageDao personalMessageDao;
	
	public void saveMessage(PersonalMessage pm){
		personalMessageDao.updateOrInsert(pm);
	}
	
	public PersonalMessage getInboxMessage(Integer messageId) throws ZfgcNotFoundException{
		PersonalMessageDbObjExample ex = new PersonalMessageDbObjExample();
		ex.createCriteria().andPersonalMessageIdEqualTo(messageId);
		
		List<PersonalMessageDbObjWithBLOBs> dbObj = personalMessageDao.get(ex);
		
		if(dbObj.size() == 0){
			throw new ZfgcNotFoundException("Cannot find PM with the ID " + messageId);
		}
		
		return mapper.map(dbObj.get(0), PersonalMessage.class);
	}
}
