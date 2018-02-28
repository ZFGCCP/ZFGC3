package com.zfgc.model.pm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.Users;

public class PersonalMessage extends BaseZfgcModel {

    private Integer personalMessageId;
    private Integer senderId;
    private Integer receiverId;
    private Date sentDt;
    private String subject;
    private String message;
    private Boolean readFlag = false;
    private Boolean sendCopyFlag = false;
    private Integer pmConversationId;
    
    private List<Users> receivers = new ArrayList<>();
	
	public Integer getPersonalMessageId() {
		return personalMessageId;
	}

	public void setPersonalMessageId(Integer personalMessageId) {
		this.personalMessageId = personalMessageId;
	}

	public Date getSentDt() {
		return sentDt;
	}

	public void setSentDt(Date sentDt) {
		this.sentDt = sentDt;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getReadFlag() {
		return readFlag;
	}

	public void setReadFlag(Boolean readFlag) {
		this.readFlag = readFlag;
	}

	public Integer getSenderId() {
		return senderId;
	}

	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}

	public Integer getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Integer receiverId) {
		this.receiverId = receiverId;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseZfgcModel copy(BaseZfgcModel other) {
		PersonalMessage copyTo = new PersonalMessage();
		
		copyTo.setPersonalMessageId(((PersonalMessage)other).getPersonalMessageId());
		copyTo.setMessage(((PersonalMessage)other).getMessage());
		copyTo.setReadFlag(((PersonalMessage)other).getReadFlag());
		copyTo.setSentDt(((PersonalMessage)other).getSentDt());
		copyTo.setSubject(((PersonalMessage)other).getSubject());
		copyTo.setSenderId(((PersonalMessage)other).getSenderId());
		copyTo.setReceiverId(((PersonalMessage)other).getReceiverId());
		copyTo.setSendCopyFlag(((PersonalMessage)other).getSendCopyFlag());
		copyTo.setPmConversationId(((PersonalMessage)other).getPmConversationId());
		
		return copyTo;
	}

	public Boolean getSendCopyFlag() {
		return sendCopyFlag;
	}

	public void setSendCopyFlag(Boolean sendCopyFlag) {
		this.sendCopyFlag = sendCopyFlag;
	}

	public Integer getPmConversationId() {
		return pmConversationId;
	}

	public void setPmConversationId(Integer pmConversationId) {
		this.pmConversationId = pmConversationId;
	}

	public List<Users> getReceivers() {
		return receivers;
	}

	public void setReceivers(List<Users> receivers) {
		this.receivers = receivers;
	}

}
