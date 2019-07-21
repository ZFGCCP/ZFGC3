package com.zfgc.dbobj;

import java.util.Date;

public class PersonalMessageDbObj {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PERSONAL_MESSAGE.PERSONAL_MESSAGE_ID
	 * @mbg.generated  Sun Jul 21 13:17:53 EDT 2019
	 */
	private Integer personalMessageId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PERSONAL_MESSAGE.PM_CONVERSATION_ID
	 * @mbg.generated  Sun Jul 21 13:17:53 EDT 2019
	 */
	private Integer pmConversationId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PERSONAL_MESSAGE.SENDER_ID
	 * @mbg.generated  Sun Jul 21 13:17:53 EDT 2019
	 */
	private Integer senderId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PERSONAL_MESSAGE.RECEIVER_ID
	 * @mbg.generated  Sun Jul 21 13:17:53 EDT 2019
	 */
	private Integer receiverId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PERSONAL_MESSAGE.SENT_DT
	 * @mbg.generated  Sun Jul 21 13:17:53 EDT 2019
	 */
	private Date sentDt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PERSONAL_MESSAGE.READ_FLAG
	 * @mbg.generated  Sun Jul 21 13:17:53 EDT 2019
	 */
	private Boolean readFlag;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PERSONAL_MESSAGE.SEND_COPY_FLAG
	 * @mbg.generated  Sun Jul 21 13:17:53 EDT 2019
	 */
	private Boolean sendCopyFlag;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PERSONAL_MESSAGE.PERSONAL_MESSAGE_ID
	 * @return  the value of PERSONAL_MESSAGE.PERSONAL_MESSAGE_ID
	 * @mbg.generated  Sun Jul 21 13:17:53 EDT 2019
	 */
	public Integer getPersonalMessageId() {
		return personalMessageId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PERSONAL_MESSAGE.PERSONAL_MESSAGE_ID
	 * @param personalMessageId  the value for PERSONAL_MESSAGE.PERSONAL_MESSAGE_ID
	 * @mbg.generated  Sun Jul 21 13:17:53 EDT 2019
	 */
	public void setPersonalMessageId(Integer personalMessageId) {
		this.personalMessageId = personalMessageId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PERSONAL_MESSAGE.PM_CONVERSATION_ID
	 * @return  the value of PERSONAL_MESSAGE.PM_CONVERSATION_ID
	 * @mbg.generated  Sun Jul 21 13:17:53 EDT 2019
	 */
	public Integer getPmConversationId() {
		return pmConversationId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PERSONAL_MESSAGE.PM_CONVERSATION_ID
	 * @param pmConversationId  the value for PERSONAL_MESSAGE.PM_CONVERSATION_ID
	 * @mbg.generated  Sun Jul 21 13:17:53 EDT 2019
	 */
	public void setPmConversationId(Integer pmConversationId) {
		this.pmConversationId = pmConversationId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PERSONAL_MESSAGE.SENDER_ID
	 * @return  the value of PERSONAL_MESSAGE.SENDER_ID
	 * @mbg.generated  Sun Jul 21 13:17:53 EDT 2019
	 */
	public Integer getSenderId() {
		return senderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PERSONAL_MESSAGE.SENDER_ID
	 * @param senderId  the value for PERSONAL_MESSAGE.SENDER_ID
	 * @mbg.generated  Sun Jul 21 13:17:53 EDT 2019
	 */
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PERSONAL_MESSAGE.RECEIVER_ID
	 * @return  the value of PERSONAL_MESSAGE.RECEIVER_ID
	 * @mbg.generated  Sun Jul 21 13:17:53 EDT 2019
	 */
	public Integer getReceiverId() {
		return receiverId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PERSONAL_MESSAGE.RECEIVER_ID
	 * @param receiverId  the value for PERSONAL_MESSAGE.RECEIVER_ID
	 * @mbg.generated  Sun Jul 21 13:17:53 EDT 2019
	 */
	public void setReceiverId(Integer receiverId) {
		this.receiverId = receiverId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PERSONAL_MESSAGE.SENT_DT
	 * @return  the value of PERSONAL_MESSAGE.SENT_DT
	 * @mbg.generated  Sun Jul 21 13:17:53 EDT 2019
	 */
	public Date getSentDt() {
		return sentDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PERSONAL_MESSAGE.SENT_DT
	 * @param sentDt  the value for PERSONAL_MESSAGE.SENT_DT
	 * @mbg.generated  Sun Jul 21 13:17:53 EDT 2019
	 */
	public void setSentDt(Date sentDt) {
		this.sentDt = sentDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PERSONAL_MESSAGE.READ_FLAG
	 * @return  the value of PERSONAL_MESSAGE.READ_FLAG
	 * @mbg.generated  Sun Jul 21 13:17:53 EDT 2019
	 */
	public Boolean getReadFlag() {
		return readFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PERSONAL_MESSAGE.READ_FLAG
	 * @param readFlag  the value for PERSONAL_MESSAGE.READ_FLAG
	 * @mbg.generated  Sun Jul 21 13:17:53 EDT 2019
	 */
	public void setReadFlag(Boolean readFlag) {
		this.readFlag = readFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PERSONAL_MESSAGE.SEND_COPY_FLAG
	 * @return  the value of PERSONAL_MESSAGE.SEND_COPY_FLAG
	 * @mbg.generated  Sun Jul 21 13:17:53 EDT 2019
	 */
	public Boolean getSendCopyFlag() {
		return sendCopyFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PERSONAL_MESSAGE.SEND_COPY_FLAG
	 * @param sendCopyFlag  the value for PERSONAL_MESSAGE.SEND_COPY_FLAG
	 * @mbg.generated  Sun Jul 21 13:17:53 EDT 2019
	 */
	public void setSendCopyFlag(Boolean sendCopyFlag) {
		this.sendCopyFlag = sendCopyFlag;
	}
}