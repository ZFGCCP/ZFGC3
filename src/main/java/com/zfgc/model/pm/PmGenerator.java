package com.zfgc.model.pm;

import com.zfgc.model.BaseZfgcModel;

public class PmGenerator extends BaseZfgcModel{

	private Integer usersId;
	private String passPhrase;
	
	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getPassPhrase() {
		return passPhrase;
	}

	public void setPassPhrase(String passPhrase) {
		this.passPhrase = passPhrase;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}