package com.zfgc.model.users;

import com.zfgc.model.BaseZfgcModel;

public class BrPermissionsMemberGroup extends BaseZfgcModel {

	private Integer memberGroupId;
    private Integer permissionsId;
	
	public Integer getMemberGroupId() {
		return memberGroupId;
	}

	public void setMemberGroupId(Integer memberGroupId) {
		this.memberGroupId = memberGroupId;
	}

	public Integer getPermissionsId() {
		return permissionsId;
	}

	public void setPermissionsId(Integer permissionsId) {
		this.permissionsId = permissionsId;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
