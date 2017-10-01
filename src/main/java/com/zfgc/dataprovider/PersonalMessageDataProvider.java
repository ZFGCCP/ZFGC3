package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.PersonalMessageDao;
import com.zfgc.dao.PmInBoxDao;
import com.zfgc.dao.PmOutBoxDao;
import com.zfgc.dbobj.InboxViewDbObjExample;
import com.zfgc.dbobj.InboxViewDbObjWithBLOBs;
import com.zfgc.dbobj.OutboxViewDbObjExample;
import com.zfgc.dbobj.OutboxViewDbObjWithBLOBs;
import com.zfgc.dbobj.PersonalMessageDbObj;
import com.zfgc.dbobj.PersonalMessageDbObjExample;
import com.zfgc.dbobj.PersonalMessageDbObjWithBLOBs;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.pm.PersonalMessage;
import com.zfgc.model.pm.PmBox;
import com.zfgc.model.users.Users;

@Component
public class PersonalMessageDataProvider extends AbstractDataProvider {

	@Autowired
	PersonalMessageDao personalMessageDao;
	
	@Autowired
	PmOutBoxDao pmOutBoxDao;
	
	@Autowired
	PmInBoxDao pmInBoxDao;
	
	public PmBox getOutbox(Users zfgcUser) throws Exception{
		OutboxViewDbObjExample ex = new OutboxViewDbObjExample();
		ex.createCriteria().andSenderIdEqualTo(zfgcUser.getUsersId());
		
		List<OutboxViewDbObjWithBLOBs> dbObj = pmOutBoxDao.get(ex);
		PmBox result = new PmBox();
		for(OutboxViewDbObjWithBLOBs msg : dbObj){
			result.getMessageList().add(mapper.map(msg, PersonalMessage.class));
		}
		
		return result;
	}
	
	public PmBox getInbox(Users zfgcUser) throws Exception{
		InboxViewDbObjExample ex = new InboxViewDbObjExample();
		ex.createCriteria().andSenderIdEqualTo(zfgcUser.getUsersId());
		
		List<InboxViewDbObjWithBLOBs> dbObj = pmInBoxDao.get(ex);
		PmBox result = new PmBox();
		for(InboxViewDbObjWithBLOBs msg : dbObj){
			result.getMessageList().add(mapper.map(msg, PersonalMessage.class));
		}
		
		return result;
	}
	
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
	
	public List<PersonalMessage> getMessagesByConversation(Integer conversationId) throws ZfgcNotFoundException{
		PersonalMessageDbObjExample ex = new PersonalMessageDbObjExample();
		ex.createCriteria().andPmConversationIdEqualTo(conversationId);
		
		List<PersonalMessageDbObjWithBLOBs> dbObj = personalMessageDao.get(ex);
		List<PersonalMessage> obj = new ArrayList<>();
		
		if(dbObj.size() == 0){
			throw new ZfgcNotFoundException("Cannot find PMs for conversation " + conversationId);
		}
		
		for(PersonalMessageDbObjWithBLOBs db : dbObj){
			obj.add(mapper.map(db,PersonalMessage.class));
		}
		
		return obj;
	}
}
