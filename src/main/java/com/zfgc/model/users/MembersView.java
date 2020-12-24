package com.zfgc.model.users;

import java.util.List;

import com.zfgc.model.BaseZfgcModel;

public class MembersView extends BaseZfgcModel{

	private List<MemberListingView> members;
	private Long totalCount;
	private Integer pageNo;
	private String sortBy;
	private String sortOrder;
	
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
	
	public Integer getTotalPages() {
		return (int)Math.ceil(totalCount.doubleValue() / 10.0);
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	
}