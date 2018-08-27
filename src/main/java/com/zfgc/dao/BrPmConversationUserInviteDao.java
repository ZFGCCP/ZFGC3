package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.BrPmConversationUserInviteDbObj;
import com.zfgc.dbobj.BrPmConversationUserInviteDbObjExample;
import com.zfgc.mappers.BrPmConversationUserInviteDbObjMapper;
import com.zfgc.model.pm.BrPmConversationUserInvite;

@Component
public class BrPmConversationUserInviteDao extends AbstractDao<BrPmConversationUserInviteDbObjExample,BrPmConversationUserInviteDbObj,BrPmConversationUserInvite>{

	@Autowired
	BrPmConversationUserInviteDbObjMapper brPmConversationUserInviteDbObjMapper;
	
	@Override
	public List<BrPmConversationUserInviteDbObj> get(
			BrPmConversationUserInviteDbObjExample ex) throws Exception {
		return brPmConversationUserInviteDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(BrPmConversationUserInvite obj) {
		BrPmConversationUserInviteDbObjExample ex = getExample();
		ex.createCriteria().andUsersIdEqualTo(obj.getUsersId()).andPmConversationIdEqualTo(obj.getPmConversationId());
		
		brPmConversationUserInviteDbObjMapper.deleteByExample(ex);
	}

	@Override
	public void updateOrInsert(BrPmConversationUserInvite obj) {
		BrPmConversationUserInviteDbObj dbObj = mapper.map(obj, BrPmConversationUserInviteDbObj.class);
		brPmConversationUserInviteDbObjMapper.insert(dbObj);
	}

	@Override
	public void updateByExample(BrPmConversationUserInvite obj,
			BrPmConversationUserInviteDbObjExample ex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(BrPmConversationUserInvite obj,
			BrPmConversationUserInviteDbObjExample ex) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countByExample(BrPmConversationUserInvite obj,
			BrPmConversationUserInviteDbObjExample ex) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}