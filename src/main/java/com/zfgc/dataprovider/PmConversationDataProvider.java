package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.dao.BrPmConversationArchiveDao;
import com.zfgc.dao.BrPmConversationUserInviteDao;
import com.zfgc.dao.BrUserConversationDao;
import com.zfgc.dao.PmArchiveBoxViewDao;
import com.zfgc.dao.PmConversationBoxViewDao;
import com.zfgc.dao.PmConversationDao;
import com.zfgc.dbobj.BrPmConversationArchiveDbObj;
import com.zfgc.dbobj.BrPmConversationArchiveDbObjExample;
import com.zfgc.dbobj.BrPmConversationUserInviteDbObj;
import com.zfgc.dbobj.BrPmConversationUserInviteDbObjExample;
import com.zfgc.dbobj.BrUserConversationDbObj;
import com.zfgc.dbobj.BrUserConversationDbObjExample;
import com.zfgc.dbobj.BrUserConversationDbObjKey;
import com.zfgc.dbobj.PmArchiveBoxViewDbObj;
import com.zfgc.dbobj.PmArchiveBoxViewDbObjExample;
import com.zfgc.dbobj.PmConversationBoxViewDbObj;
import com.zfgc.dbobj.PmConversationBoxViewDbObjExample;
import com.zfgc.dbobj.PmConversationBoxViewDbObjExample.Criteria;
import com.zfgc.dbobj.PmConversationBoxViewDbObjWithBLOBs;
import com.zfgc.dbobj.PmConversationDbObj;
import com.zfgc.dbobj.PmConversationDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.pm.BrPmConversationArchive;
import com.zfgc.model.pm.BrPmConversationUserInvite;
import com.zfgc.model.pm.BrUserConversation;
import com.zfgc.model.pm.PmArchiveBoxView;
import com.zfgc.model.pm.PmConversation;
import com.zfgc.model.pm.PmConversationView;
import com.zfgc.model.pm.PmPrune;
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
	
	@Autowired
	BrPmConversationArchiveDao brPmConversationArchiveDao;
	
	@Autowired
	PmArchiveBoxViewDao pmArchiveBoxViewDao;
	
	@Autowired
	BrPmConversationUserInviteDao brPmConversationUserInviteDao;
	
	@Transactional
	public void addToArchive(BrPmConversationArchive obj){
		brPmConversationArchiveDao.updateOrInsert(obj);
	}
	
	@Transactional
	public PmConversation createConversation(Integer initiator, List<Integer> participants, String subject){
		PmConversation obj = new PmConversation();
		obj.setStartDt(ZfgcTimeUtils.getToday());
		obj.setSubject(subject);
		obj.setInitiatorId(initiator);
		
		pmConversationDao.updateOrInsert(obj);
		
		for(Integer participant : participants) {
			BrUserConversation userToConvoMapping = new BrUserConversation();
			userToConvoMapping.setUsersId(participant);
			userToConvoMapping.setPmConversationId(obj.getPmConversationId());
			brUserConversationDao.updateOrInsert(userToConvoMapping);
		}
		
		return obj;
	}
	
	public void addUserMappingToConvo(Integer conversationId, Integer usersId) {
		BrUserConversation mapping = new BrUserConversation();
		mapping.setPmConversationId(conversationId);
		mapping.setUsersId(usersId);
		mapping.setReadFlag(false);
		
		brUserConversationDao.updateOrInsert(mapping);
	}
	
	public List<PmConversationView> getBoxViewByUsersId(Users user) throws Exception{
		Integer usersId = user.getUsersId();
		PmConversationBoxViewDbObjExample ex = new PmConversationBoxViewDbObjExample();
		ex.createCriteria().andReceiverIdEqualTo(usersId).andSenderIdNotEqualTo(usersId);
		
		ex.or().andSenderIdEqualTo(usersId).andReceiverIdEqualTo(usersId);
		
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
	
	public List<PmConversationView> getSentBoxViewByUsersId(Users user) throws Exception{
		Integer usersId = user.getUsersId();
		PmConversationBoxViewDbObjExample ex = new PmConversationBoxViewDbObjExample();
		ex.createCriteria().andSenderIdEqualTo(usersId).andReceiverIdEqualTo(usersId);
		
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
	
	public List<PmConversationView> getInBoxViewByUsersId(Users user) throws Exception{
		Integer usersId = user.getUsersId();
		PmConversationBoxViewDbObjExample ex = new PmConversationBoxViewDbObjExample();
		ex.createCriteria().andReceiverIdEqualTo(usersId).andSenderIdNotEqualTo(usersId);
		
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
	
	public PmConversation getConversation(Integer convoId) throws RuntimeException {
		PmConversationDbObjExample ex = new PmConversationDbObjExample();
		ex.createCriteria().andPmConversationIdEqualTo(convoId);
		List<PmConversationDbObj> conversations = null;
		PmConversation result = null;
		
		conversations = pmConversationDao.get(ex);
		result = null;
		
		if(conversations.size() > 0) {
			result = mapper.map(conversations.get(0),PmConversation.class);
			
			return result;
		}
		else {
			throw new ZfgcNotFoundException("conversation");
		}
	}
	
	public void deleteConversationFromBox(PmConversation convo, Users zfgcUser) throws RuntimeException{
		BrUserConversationDbObjExample ex = brUserConversationDao.getExample();
		ex.createCriteria().andUsersIdEqualTo(zfgcUser.getUsersId()).andPmConversationIdEqualTo(convo.getPmConversationId());
		
		brUserConversationDao.deleteByExample(null, ex);
	}
	
	public void bulkDeleteConversation(List<Integer> ids, Users zfgcUser) throws RuntimeException{
		BrUserConversationDbObjExample ex = brUserConversationDao.getExample();
		ex.createCriteria().andUsersIdEqualTo(zfgcUser.getUsersId()).andPmConversationIdIn(ids);
		
		brUserConversationDao.deleteByExample(null,ex);
	}
	
	public List<PmArchiveBoxView> getArchiveBox(Users zfgcUser) throws RuntimeException{
		PmArchiveBoxViewDbObjExample sendEx = pmArchiveBoxViewDao.getExample();
		sendEx.createCriteria().andSenderIdEqualTo(zfgcUser.getUsersId()).andSendCopyFlagEqualTo(true);
		
		PmArchiveBoxViewDbObjExample receiveEx = pmArchiveBoxViewDao.getExample();
		receiveEx.createCriteria().andReceiverIdEqualTo(zfgcUser.getUsersId()).andSendCopyFlagEqualTo(false);
		
		List<PmArchiveBoxViewDbObj> dbObj = new ArrayList<>();
		dbObj.addAll(pmArchiveBoxViewDao.get(sendEx));
		dbObj.addAll(pmArchiveBoxViewDao.get(receiveEx));
		
		List<PmArchiveBoxView> result = new ArrayList<>(dbObj.size());
		
		for(PmArchiveBoxViewDbObj db : dbObj){
			result.add(mapper.map(db, PmArchiveBoxView.class));
		}
		
		return result;
	}
	
	public List<Integer> getConvosToBePruned(PmPrune prune, Users zfgcUser) throws RuntimeException{
		PmConversationBoxViewDbObjExample pruneEx = pmConversationBoxViewDao.getExample();
		Criteria crit = pruneEx.createCriteria();
		
		if(prune.getOlderThanDt() != null){
			crit = crit.andStartDtLessThan(prune.getOlderThanDt());
		}
		
		if(prune.getInactiveForDt() != null){
			crit = crit.andSentDtLessThanOrEqualTo(prune.getInactiveForDt());
		}
		
		if(prune.getDeleteStartedUserId() != null){
			crit = crit.andInitiatorIdEqualTo(prune.getDeleteStartedUserId());
		}
		
		if(prune.getStartedByMeFlag()){
			crit = crit.andInitiatorIdEqualTo(zfgcUser.getUsersId());
		}
		
		List<PmConversationBoxViewDbObjWithBLOBs> dbs = pmConversationBoxViewDao.get(pruneEx);
		List<Integer> results = new ArrayList<>();
		
		for(PmConversationBoxViewDbObjWithBLOBs db : dbs){
			results.add(db.getPmConversationId());
		}
		
		return results;
		
	}
	
	public BrPmConversationUserInvite getConvoInvite(Integer pmConversationId, Integer usersId) throws RuntimeException{
		BrPmConversationUserInviteDbObjExample ex = new BrPmConversationUserInviteDbObjExample(); 
		ex.createCriteria().andUsersIdEqualTo(usersId).andPmConversationIdEqualTo(pmConversationId);
		List<BrPmConversationUserInviteDbObj> result = null;
		try {
			result = brPmConversationUserInviteDao.get(ex);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
		
		if(result.isEmpty()){
			return null;
		}
		
		return mapper.map(result.get(0),BrPmConversationUserInvite.class);
	}
	
	public boolean isUserPartOfConvo(Integer pmConversationId, Integer usersId) throws RuntimeException{
		BrUserConversationDbObjExample ex = brUserConversationDao.getExample();
		ex.createCriteria().andUsersIdEqualTo(usersId).andPmConversationIdEqualTo(pmConversationId);
		List<BrUserConversationDbObj> result = null;
		try {
			result = brUserConversationDao.get(ex);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return result.size() > 0;
	}
	
	public boolean isConvoArchived(Integer pmConversationId, Integer usersId) throws RuntimeException{
		BrPmConversationArchiveDbObjExample ex = brPmConversationArchiveDao.getExample();
		ex.createCriteria().andPmConversationIdEqualTo(pmConversationId).andUsersIdEqualTo(usersId);
		List<BrPmConversationArchiveDbObj> result = null;
		
		result = brPmConversationArchiveDao.get(ex);
		
		return result.size() > 0;
	}
	
	public Date getArchivalDate(Integer pmConversationId, Integer usersId) throws ZfgcNotFoundException, Exception{
		BrPmConversationArchiveDbObjExample ex = brPmConversationArchiveDao.getExample();
		ex.createCriteria().andPmConversationIdEqualTo(pmConversationId).andUsersIdEqualTo(usersId);
		List<BrPmConversationArchiveDbObj> result = null;
		
		result = brPmConversationArchiveDao.get(ex);
		
		if(result.size() == 0) {
			throw new ZfgcNotFoundException("Archived Conversation " + pmConversationId);
		}
		
		return result.get(0).getArchiveDt();
	}
	
	public void createInvite(BrPmConversationUserInvite invite) throws RuntimeException {
		brPmConversationUserInviteDao.updateOrInsert(invite);
	}
	
	public void deleteInvite(BrPmConversationUserInvite invite) {
		brPmConversationUserInviteDao.hardDelete(invite);
	}
	
	public void setConvoToRead(Integer convoId, Integer usersId) throws RuntimeException{
		BrUserConversation convo = new BrUserConversation();
		convo.setUsersId(usersId);
		convo.setPmConversationId(convoId);
		convo.setReadFlag(true);
		
		BrUserConversationDbObjExample ex = brUserConversationDao.getExample();
		ex.createCriteria().andPmConversationIdEqualTo(convo.getPmConversationId()).andUsersIdEqualTo(usersId);
		brUserConversationDao.updateByExample(convo, ex);
	}
	
	public void setConvoToUnRead(Integer convoId, Integer usersId) throws RuntimeException{
		BrUserConversation convo = new BrUserConversation();
		convo.setUsersId(usersId);
		convo.setPmConversationId(convoId);
		convo.setReadFlag(false);
		
		BrUserConversationDbObjExample ex = brUserConversationDao.getExample();
		ex.createCriteria().andPmConversationIdEqualTo(convo.getPmConversationId()).andUsersIdEqualTo(usersId);
		brUserConversationDao.updateByExample(convo, ex);
	}
	
	public Long countUnread(Integer usersId) throws RuntimeException{
		BrUserConversationDbObjExample ex = brUserConversationDao.getExample();
		ex.createCriteria().andUsersIdEqualTo(usersId).andReadFlagEqualTo(false);
		
		return brUserConversationDao.countByExample(null, ex);
	}
	
	public void updateConversationSubject(Integer convoId, String newSubject) {
		PmConversation convo = new PmConversation();
		convo.setSubject(newSubject);
		
		PmConversationDbObjExample ex = pmConversationDao.getExample();
		ex.createCriteria().andPmConversationIdEqualTo(convoId);
		
		pmConversationDao.updateByExample(convo, ex);
	}
}