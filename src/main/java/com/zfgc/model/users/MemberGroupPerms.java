package com.zfgc.model.users;

import java.util.List;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.lkup.LkupMemberGroup;

public class MemberGroupPerms extends BaseZfgcModel {
	
	private LkupMemberGroup memberGroup;
	private List<Permissions> perms;
	
	public LkupMemberGroup getMemberGroup() {
		return memberGroup;
	}

	public void setMemberGroup(LkupMemberGroup memberGroup) {
		this.memberGroup = memberGroup;
	}

	public List<Permissions> getPerms() {
		return perms;
	}

	public void setPerms(List<Permissions> perms) {
		this.perms = perms;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}