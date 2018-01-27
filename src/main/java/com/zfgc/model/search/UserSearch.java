package com.zfgc.model.search;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.avatar.Avatar;
import com.zfgc.model.users.EmailAddress;

public class UserSearch extends BaseZfgcModel {

	private Integer usersId;
	private EmailAddress email = new EmailAddress();
	private String displayName;
	private Avatar avatar;
	
	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public EmailAddress getEmail() {
		return email;
	}

	public void setEmail(EmailAddress email) {
		this.email = email;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseZfgcModel copy(BaseZfgcModel other) {
		// TODO Auto-generated method stub
		return null;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

}
