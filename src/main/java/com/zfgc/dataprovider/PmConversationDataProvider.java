package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.BrUserConversationDao;
import com.zfgc.dao.PmConversationBoxViewDao;
import com.zfgc.dao.PmConversationDao;
import com.zfgc.dbobj.BrUserConversationDbObjExample;
import com.zfgc.dbobj.PmConversationBoxViewDbObj;
import com.zfgc.dbobj.PmConversationBoxViewDbObjExample;
import com.zfgc.dbobj.PmConversationBoxViewDbObjWithBLOBs;
import com.zfgc.dbobj.PmConversationDbObj;
import com.zfgc.dbobj.PmConversationDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.pm.PmConversation;
import com.zfgc.model.pm.PmConversationView;
import com.zfgc.model.users.Users;
import com.zfgc.util.time.ZfgcTimeUtils;

@Component
public class PmConversationDataProvider extends AbstractDataProvider{
	
	@Autowired
	PmConversationDao pmConversationDao;
	
	@Autowired
	PmConversationBoxViewDao pmConversationBoxViewDao;
	
	@Autowired
	BrUserConversationDao brUserConversationDao;
	
	public PmConversation createConversation(Integer initiator){
		PmConversation obj = new PmConversation();
		obj.setStartDt(ZfgcTimeUtils.getToday());
		obj.setInitiatorId(initiator);
		
		pmConversationDao.updateOrInsert(obj);
		
		return obj;
	}
	
	public List<PmConversationView> getBoxViewByUsersId(Users user) throws Exception{
		Integer usersId = user.getUsersId();
		PmConversationBoxViewDbObjExample ex = new PmConversationBoxViewDbObjExample();
		ex.createCriteria().andUsersIdEqualTo(usersId);
		
		try {
			List<PmConversationBoxViewDbObjWithBLOBs> dbObj = pmConversationBoxViewDao.get(ex);
			List<PmConversationView> result = new ArrayList<>();
			
			for(PmConversationBoxViewDbObjWithBLOBs obj : dbObj){
				result.add(mapper.map(obj, PmConversationView.class));
			}
			
			return result;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} 
	}
	
	public PmConversation getConversation(Integer convoId) throws ZfgcNotFoundException, Exception {
		PmConversationDbObjExample ex = new PmConversationDbObjExample();
		ex.createCriteria().andPmConversationIdEqualTo(convoId);
		List<PmConversationDbObj> conversations = null;
		PmConversation result = null;
		
		try {
			conversations = pmConversationDao.get(ex);
			result = null;
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		
		if(conversations.size() > 0) {
			result = mapper.map(conversations.get(0),PmConversation.class);
			
			return result;
		}
		else {
			throw new ZfgcNotFoundException("conversation");
		}
	}
	
	public void deleteConversationFromBox(PmConversation convo, Users zfgcUser) throws ZfgcNotFoundException, Exception{
		BrUserConversationDbObjExample ex = brUserConversationDao.getExample();
		ex.createCriteria().andUsersIdEqualTo(zfgcUser.getUsersId()).andPmConversationIdEqualTo(convo.getPmConversationId());
		
		brUserConversationDao.deleteByExample(null, ex);
	}
}