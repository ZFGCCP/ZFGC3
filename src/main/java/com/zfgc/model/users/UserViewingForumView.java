package com.zfgc.model.users;

import com.zfgc.model.BaseZfgcModel;

public class UserViewingForumView extends BaseZfgcModel {

	private Integer usersId;
	private Integer displayName;
	
	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public Integer getDisplayName() {
		return displayName;
	}

	public void setDisplayName(Integer displayName) {
		this.displayName = displayName;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}