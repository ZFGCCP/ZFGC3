package com.zfgc.model.pm;

import com.zfgc.model.BaseZfgcModel;

public class BrPmConversationUserInvite extends BaseZfgcModel{

	private String inviteCode;
	private String decryptor;
	private Integer usersId;
	private Integer pmConversationId;
	
	public String getInviteCode() {
		return inviteCode;
	}


	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}


	public String getDecryptor() {
		return decryptor;
	}


	public void setDecryptor(String decryptor) {
		this.decryptor = decryptor;
	}


	public Integer getUsersId() {
		return usersId;
	}


	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}


	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public Integer getPmConversationId() {
		return pmConversationId;
	}


	public void setPmConversationId(Integer pmConversationId) {
		this.pmConversationId = pmConversationId;
	}
	
}