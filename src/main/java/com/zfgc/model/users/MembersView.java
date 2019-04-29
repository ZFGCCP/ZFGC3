package com.zfgc.model.users;

import java.util.List;

import com.zfgc.model.BaseZfgcModel;

public class MembersView extends BaseZfgcModel{

	private List<MemberListingView> members;
	private Long totalCount;
	
	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public List<MemberListingView> getMembers() {
		return members;
	}

	public void setMembers(List<MemberListingView> members) {
		this.members = members;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}