package com.zfgc.dbobj;

import java.util.Date;

public class PmConversationDbObj {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PM_CONVERSATION.PM_CONVERSATION_ID
	 * @mbggenerated  Sun Oct 01 00:57:14 EDT 2017
	 */
	private Integer pmConversationId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PM_CONVERSATION.START_DT
	 * @mbggenerated  Sun Oct 01 00:57:14 EDT 2017
	 */
	private Date startDt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PM_CONVERSATION.INITIATOR_ID
	 * @mbggenerated  Sun Oct 01 00:57:14 EDT 2017
	 */
	private Integer initiatorId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PM_CONVERSATION.PM_CONVERSATION_ID
	 * @return  the value of PM_CONVERSATION.PM_CONVERSATION_ID
	 * @mbggenerated  Sun Oct 01 00:57:14 EDT 2017
	 */
	public Integer getPmConversationId() {
		return pmConversationId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PM_CONVERSATION.PM_CONVERSATION_ID
	 * @param pmConversationId  the value for PM_CONVERSATION.PM_CONVERSATION_ID
	 * @mbggenerated  Sun Oct 01 00:57:14 EDT 2017
	 */
	public void setPmConversationId(Integer pmConversationId) {
		this.pmConversationId = pmConversationId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PM_CONVERSATION.START_DT
	 * @return  the value of PM_CONVERSATION.START_DT
	 * @mbggenerated  Sun Oct 01 00:57:14 EDT 2017
	 */
	public Date getStartDt() {
		return startDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PM_CONVERSATION.START_DT
	 * @param startDt  the value for PM_CONVERSATION.START_DT
	 * @mbggenerated  Sun Oct 01 00:57:14 EDT 2017
	 */
	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PM_CONVERSATION.INITIATOR_ID
	 * @return  the value of PM_CONVERSATION.INITIATOR_ID
	 * @mbggenerated  Sun Oct 01 00:57:14 EDT 2017
	 */
	public Integer getInitiatorId() {
		return initiatorId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PM_CONVERSATION.INITIATOR_ID
	 * @param initiatorId  the value for PM_CONVERSATION.INITIATOR_ID
	 * @mbggenerated  Sun Oct 01 00:57:14 EDT 2017
	 */
	public void setInitiatorId(Integer initiatorId) {
		this.initiatorId = initiatorId;
	}
}