package com.zfgc.model.pm;

import com.zfgc.model.BaseZfgcModel;

public class TwoFactorKey extends BaseZfgcModel{

	private String key;
	private Integer usersId;
	
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

}
