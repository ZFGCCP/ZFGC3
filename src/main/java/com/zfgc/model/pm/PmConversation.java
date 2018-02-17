package com.zfgc.model.pm;

import java.util.Date;
import java.util.List;

import com.zfgc.model.BaseZfgcModel;

public class PmConversation extends BaseZfgcModel {

	private Integer pmConversationId;
	private Date startDt;
	private List<PersonalMessage> messages;
	private Integer initiatorId;
	
	public Integer getPmConversationId() {
		return pmConversationId;
	}

	public void setPmConversationId(Integer pmConversationId) {
		this.pmConversationId = pmConversationId;
	}

	public Date getStartDt() {
		return startDt;
	}

	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PersonalMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<PersonalMessage> messages) {
		this.messages = messages;
	}

	public Integer getInitiatorId() {
		return initiatorId;
	}

	public void setInitiatorId(Integer initiatorId) {
		this.initiatorId = initiatorId;
	}
	
}