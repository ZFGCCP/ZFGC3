package com.zfgc.model.users;

import java.util.ArrayList;
import java.util.List;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.lkup.LkupMemberGroup;

public class SecondaryMemberGroups extends BaseZfgcModel{

	private Integer usersId;
	private List<LkupMemberGroup> memberGroups = new ArrayList<>();
	
	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public List<LkupMemberGroup> getMemberGroups() {
		return memberGroups;
	}

	public void setMemberGroups(List<LkupMemberGroup> memberGroups) {
		this.memberGroups = memberGroups;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}