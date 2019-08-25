package com.zfgc.model.pm;

import java.util.List;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.Users;

public class PmUsersToAdd extends BaseZfgcModel{

	private List<Integer> users;
	private TwoFactorKey aesKey;
	
	public List<Integer> getUsers() {
		return users;
	}

	public void setUsers(List<Integer> users) {
		this.users = users;
	}

	public TwoFactorKey getAesKey() {
		return aesKey;
	}

	public void setAesKey(TwoFactorKey aesKey) {
		this.aesKey = aesKey;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}