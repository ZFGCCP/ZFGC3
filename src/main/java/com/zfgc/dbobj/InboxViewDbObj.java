package com.zfgc.dbobj;

import java.util.Date;

public class InboxViewDbObj {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column INBOX_VIEW.PERSONAL_MESSAGE_ID
	 * @mbggenerated  Mon Sep 04 20:44:22 EDT 2017
	 */
	private Integer personalMessageId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column INBOX_VIEW.SENDER_ID
	 * @mbggenerated  Mon Sep 04 20:44:22 EDT 2017
	 */
	private Integer senderId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column INBOX_VIEW.RECEIVER_ID
	 * @mbggenerated  Mon Sep 04 20:44:22 EDT 2017
	 */
	private Integer receiverId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column INBOX_VIEW.SENT_DT
	 * @mbggenerated  Mon Sep 04 20:44:22 EDT 2017
	 */
	private Date sentDt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column INBOX_VIEW.READ_FLAG
	 * @mbggenerated  Mon Sep 04 20:44:22 EDT 2017
	 */
	private Boolean readFlag;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column INBOX_VIEW.PERSONAL_MESSAGE_ID
	 * @return  the value of INBOX_VIEW.PERSONAL_MESSAGE_ID
	 * @mbggenerated  Mon Sep 04 20:44:22 EDT 2017
	 */
	public Integer getPersonalMessageId() {
		return personalMessageId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column INBOX_VIEW.PERSONAL_MESSAGE_ID
	 * @param personalMessageId  the value for INBOX_VIEW.PERSONAL_MESSAGE_ID
	 * @mbggenerated  Mon Sep 04 20:44:22 EDT 2017
	 */
	public void setPersonalMessageId(Integer personalMessageId) {
		this.personalMessageId = personalMessageId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column INBOX_VIEW.SENDER_ID
	 * @return  the value of INBOX_VIEW.SENDER_ID
	 * @mbggenerated  Mon Sep 04 20:44:22 EDT 2017
	 */
	public Integer getSenderId() {
		return senderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column INBOX_VIEW.SENDER_ID
	 * @param senderId  the value for INBOX_VIEW.SENDER_ID
	 * @mbggenerated  Mon Sep 04 20:44:22 EDT 2017
	 */
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column INBOX_VIEW.RECEIVER_ID
	 * @return  the value of INBOX_VIEW.RECEIVER_ID
	 * @mbggenerated  Mon Sep 04 20:44:22 EDT 2017
	 */
	public Integer getReceiverId() {
		return receiverId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column INBOX_VIEW.RECEIVER_ID
	 * @param receiverId  the value for INBOX_VIEW.RECEIVER_ID
	 * @mbggenerated  Mon Sep 04 20:44:22 EDT 2017
	 */
	public void setReceiverId(Integer receiverId) {
		this.receiverId = receiverId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column INBOX_VIEW.SENT_DT
	 * @return  the value of INBOX_VIEW.SENT_DT
	 * @mbggenerated  Mon Sep 04 20:44:22 EDT 2017
	 */
	public Date getSentDt() {
		return sentDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column INBOX_VIEW.SENT_DT
	 * @param sentDt  the value for INBOX_VIEW.SENT_DT
	 * @mbggenerated  Mon Sep 04 20:44:22 EDT 2017
	 */
	public void setSentDt(Date sentDt) {
		this.sentDt = sentDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column INBOX_VIEW.READ_FLAG
	 * @return  the value of INBOX_VIEW.READ_FLAG
	 * @mbggenerated  Mon Sep 04 20:44:22 EDT 2017
	 */
	public Boolean getReadFlag() {
		return readFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column INBOX_VIEW.READ_FLAG
	 * @param readFlag  the value for INBOX_VIEW.READ_FLAG
	 * @mbggenerated  Mon Sep 04 20:44:22 EDT 2017
	 */
	public void setReadFlag(Boolean readFlag) {
		this.readFlag = readFlag;
	}
}