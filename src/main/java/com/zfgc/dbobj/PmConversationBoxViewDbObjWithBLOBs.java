package com.zfgc.dbobj;

public class PmConversationBoxViewDbObjWithBLOBs extends PmConversationBoxViewDbObj {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PM_CONVERSATION_BOX_VIEW.SUBJECT
	 * @mbggenerated  Sun Aug 19 21:53:20 EDT 2018
	 */
	private String subject;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PM_CONVERSATION_BOX_VIEW.MESSAGE
	 * @mbggenerated  Sun Aug 19 21:53:20 EDT 2018
	 */
	private String message;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PM_CONVERSATION_BOX_VIEW.SUBJECT
	 * @return  the value of PM_CONVERSATION_BOX_VIEW.SUBJECT
	 * @mbggenerated  Sun Aug 19 21:53:20 EDT 2018
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PM_CONVERSATION_BOX_VIEW.SUBJECT
	 * @param subject  the value for PM_CONVERSATION_BOX_VIEW.SUBJECT
	 * @mbggenerated  Sun Aug 19 21:53:20 EDT 2018
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PM_CONVERSATION_BOX_VIEW.MESSAGE
	 * @return  the value of PM_CONVERSATION_BOX_VIEW.MESSAGE
	 * @mbggenerated  Sun Aug 19 21:53:20 EDT 2018
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PM_CONVERSATION_BOX_VIEW.MESSAGE
	 * @param message  the value for PM_CONVERSATION_BOX_VIEW.MESSAGE
	 * @mbggenerated  Sun Aug 19 21:53:20 EDT 2018
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}