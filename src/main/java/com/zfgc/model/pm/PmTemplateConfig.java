package com.zfgc.model.pm;

import java.util.List;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.Users;

public class PmTemplateConfig extends BaseZfgcModel{

	private Integer pmConversationId;
	private List<Users> receivers;
	
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Users> getReceivers() {
		return receivers;
	}

	public void setReceivers(List<Users> receivers) {
		this.receivers = receivers;
	}

	public Integer getPmConversationId() {
		return pmConversationId;
	}

	public void setPmConversationId(Integer pmConversationId) {
		this.pmConversationId = pmConversationId;
	}
	
}