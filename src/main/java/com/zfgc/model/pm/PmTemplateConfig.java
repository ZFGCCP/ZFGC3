package com.zfgc.model.pm;

import java.util.List;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.Users;

public class PmTemplateConfig extends BaseZfgcModel{

	private Integer pmConversationId;
	private String subject;
	private List<Integer> receivers;
	
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> getReceivers() {
		return receivers;
	}

	public void setReceivers(List<Integer> receivers) {
		this.receivers = receivers;
	}

	public Integer getPmConversationId() {
		return pmConversationId;
	}

	public void setPmConversationId(Integer pmConversationId) {
		this.pmConversationId = pmConversationId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}