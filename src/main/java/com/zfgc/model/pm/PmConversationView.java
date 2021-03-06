package com.zfgc.model.pm;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.zfgc.constants.pm.PmConstants;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.util.time.ZfgcTimeUtils;

public class PmConversationView extends BaseZfgcModel{
	private Integer pmConversationId;
    private Integer senderId;
    private String senderName;
	private String receiverName;
    private Integer receiverId;
    private Integer initiatorId;
    private String initiatorName;
    private Integer personalMessageId;
    private Date sentDt;
    private Date startDt;
    private String subject;
    private String message;
    private Boolean isSelected;
    private boolean isArchived = false;
	
	public boolean isArchived() {
		return isArchived;
	}

	public void setArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}

	public PmConstants.BoxType getBoxType() {
		if(isArchived) {
			return PmConstants.BoxType.ARCHIVE;
		}
		
		if(super.getUserId() == senderId && super.getUserId() == receiverId) {
			return PmConstants.BoxType.OUTBOX;
		}
		
		return PmConstants.BoxType.INBOX;
	}

	public Integer getPmConversationId() {
		return pmConversationId;
	}

	public void setPmConversationId(Integer pmConversationId) {
		this.pmConversationId = pmConversationId;
	}

	public Integer getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Integer receiverId) {
		this.receiverId = receiverId;
	}

	public Integer getInitiatorId() {
		return initiatorId;
	}

	public void setInitiatorId(Integer initiatorId) {
		this.initiatorId = initiatorId;
	}

	public Integer getPersonalMessageId() {
		return personalMessageId;
	}

	public void setPersonalMessageId(Integer personalMessageId) {
		this.personalMessageId = personalMessageId;
	}

	public Date getSentDt() {
		return sentDt;
	}

	public String getSentDtAsString(){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateTimeFormat(getUserTimeZone());
		
		if(sentDt == null){
			return "";
		}
		
		return sdf.format(sentDt);
	}
	
	public void setSentDt(Date sentDt) {
		this.sentDt = sentDt;
	}

	public Date getStartDt() {
		return startDt;
	}

	public String getStartDtAsString(){
		
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateTimeFormat(getUserTimeZone());
		
		if(startDt == null){
			return "";
		}
		
		return sdf.format(startDt);
	}
	
	public void setStartDt(Date startDt) {
		this.startDt = startDt;
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
	
	public String getInitiatorName() {
		return initiatorName;
	}

	public void setInitiatorName(String initiatorName) {
		this.initiatorName = initiatorName;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public Boolean getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}
    public Integer getSenderId() {
		return senderId;
	}

	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}


}