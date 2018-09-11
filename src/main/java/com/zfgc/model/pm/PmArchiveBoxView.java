package com.zfgc.model.pm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.constants.pm.PmConstants;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.util.time.ZfgcTimeUtils;

public class PmArchiveBoxView extends BaseZfgcModel{

	private Integer pmConversationId;
    private Integer personalMessageId;
    private Integer senderId;
    private String senderName;
    private Integer receiverId;
    private Integer initiatorId;
    private String initiatorName;
    private Date sentDt;
    private Boolean sendCopyFlag;
    private Boolean readFlag;
    private String message;
    private String subject;
    private Date startDt;
    private PmConstants.BoxType boxType = PmConstants.BoxType.ARCHIVE;

	public PmConstants.BoxType getBoxType() {
		return boxType;
	}

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

	public String getInitiatorName() {
		return initiatorName;
	}

	public void setInitiatorName(String initiatorName) {
		this.initiatorName = initiatorName;
	}

	public Integer getInitiatorId() {
		return initiatorId;
	}

	public void setInitiatorId(Integer initiatorId) {
		this.initiatorId = initiatorId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	@JsonIgnore
	public Date getStartDt() {
		return startDt;
	}

	@JsonIgnore
	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}
	
	public String getStartDtAsString(){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateTimeFormat(getUserTimeZone());
		
		return sdf.format(startDt);
	}
	
	public void setStartDtAsString(String startDtAsString){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateTimeFormat();
		
		if(startDtAsString == null || startDtAsString.equals("")){
			sentDt = null;
		}
		else{
			try {
				sentDt = sdf.parse(startDtAsString);
			} catch (ParseException e) {
				sentDt = null;
				e.printStackTrace();
			}
		}
	}
	
}