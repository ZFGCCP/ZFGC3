package com.zfgc.model.pm;

import java.util.Date;

import com.zfgc.model.BaseZfgcModel;

public class PmArchiveBoxView extends BaseZfgcModel{

	private Integer pmConversationId;
    private Integer personalMessageId;
    private Integer senderId;
    private Integer receiverId;
    private Date sentDt;
    private Boolean sendCopyFlag;
    private Boolean readFlag;
    private String message;
    private String subject;

	public Integer getPmConversationId() {
		return pmConversationId;
	}

	public void setPmConversationId(Integer pmConversationId) {
		this.pmConversationId = pmConversationId;
	}

	public Integer getPersonalMessageId() {
		return personalMessageId;
	}

	public void setPersonalMessageId(Integer personalMessageId) {
		this.personalMessageId = personalMessageId;
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

	public Date getSentDt() {
		return sentDt;
	}

	public void setSentDt(Date sentDt) {
		this.sentDt = sentDt;
	}

	public Boolean getSendCopyFlag() {
		return sendCopyFlag;
	}

	public void setSendCopyFlag(Boolean sendCopyFlag) {
		this.sendCopyFlag = sendCopyFlag;
	}

	public Boolean getReadFlag() {
		return readFlag;
	}

	public void setReadFlag(Boolean readFlag) {
		this.readFlag = readFlag;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}