package com.zfgc.dbobj;

public class BrPmConversationUserInviteDbObj extends BrPmConversationUserInviteDbObjKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column BR_PM_CONVERSATION_USER_INVITE.INVITE_CODE
	 * @mbggenerated  Fri Aug 17 00:26:30 EDT 2018
	 */
	private String inviteCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column BR_PM_CONVERSATION_USER_INVITE.DECRYPTOR
	 * @mbggenerated  Fri Aug 17 00:26:30 EDT 2018
	 */
	private String decryptor;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column BR_PM_CONVERSATION_USER_INVITE.INVITER_ID
	 * @mbggenerated  Fri Aug 17 00:26:30 EDT 2018
	 */
	private Integer inviterId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column BR_PM_CONVERSATION_USER_INVITE.INVITE_CODE
	 * @return  the value of BR_PM_CONVERSATION_USER_INVITE.INVITE_CODE
	 * @mbggenerated  Fri Aug 17 00:26:30 EDT 2018
	 */
	public String getInviteCode() {
		return inviteCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column BR_PM_CONVERSATION_USER_INVITE.INVITE_CODE
	 * @param inviteCode  the value for BR_PM_CONVERSATION_USER_INVITE.INVITE_CODE
	 * @mbggenerated  Fri Aug 17 00:26:30 EDT 2018
	 */
	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column BR_PM_CONVERSATION_USER_INVITE.DECRYPTOR
	 * @return  the value of BR_PM_CONVERSATION_USER_INVITE.DECRYPTOR
	 * @mbggenerated  Fri Aug 17 00:26:30 EDT 2018
	 */
	public String getDecryptor() {
		return decryptor;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column BR_PM_CONVERSATION_USER_INVITE.DECRYPTOR
	 * @param decryptor  the value for BR_PM_CONVERSATION_USER_INVITE.DECRYPTOR
	 * @mbggenerated  Fri Aug 17 00:26:30 EDT 2018
	 */
	public void setDecryptor(String decryptor) {
		this.decryptor = decryptor;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column BR_PM_CONVERSATION_USER_INVITE.INVITER_ID
	 * @return  the value of BR_PM_CONVERSATION_USER_INVITE.INVITER_ID
	 * @mbggenerated  Fri Aug 17 00:26:30 EDT 2018
	 */
	public Integer getInviterId() {
		return inviterId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column BR_PM_CONVERSATION_USER_INVITE.INVITER_ID
	 * @param inviterId  the value for BR_PM_CONVERSATION_USER_INVITE.INVITER_ID
	 * @mbggenerated  Fri Aug 17 00:26:30 EDT 2018
	 */
	public void setInviterId(Integer inviterId) {
		this.inviterId = inviterId;
	}
}