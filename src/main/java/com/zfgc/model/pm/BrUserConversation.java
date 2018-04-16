package com.zfgc.model.pm;

import com.zfgc.model.BaseZfgcModel;

public class BrUserConversation extends BaseZfgcModel {
	
	public Integer usersId;
	public Integer pmConversationId;
	public Integer getUsersId() {
		return usersId;
	}
	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public Integer getPmConversationId() {
		return pmConversationId;
	}
	public void setPmConversationId(Integer pmConversationId) {
		this.pmConversationId = pmConversationId;
	}
	
}