package com.zfgc.model.pm;

import java.util.Date;
import java.util.List;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.Users;

public class PmConversation extends BaseZfgcModel {

	private Integer pmConversationId;
	private Date startDt;
	private List<PersonalMessage> messages;
	private Integer initiatorId;
	private Boolean isSelected;
	private List<Users> participants;
	
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

	public Boolean getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}

	public List<Users> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Users> participants) {
		this.participants = participants;
	}
	
}