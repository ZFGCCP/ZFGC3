package com.zfgc.model.forum;

import com.zfgc.model.BaseZfgcModel;

public class BrMemberGroupForum extends BaseZfgcModel{
	private Integer forumId;
	private Integer memberGroupId;
	private Boolean readFlag;
	private Boolean writeFlag;
	public Integer getForumId() {
		return forumId;
	}
	public void setForumId(Integer forumId) {
		this.forumId = forumId;
	}
	public Integer getMemberGroupId() {
		return memberGroupId;
	}
	public void setMemberGroupId(Integer memberGroupId) {
		this.memberGroupId = memberGroupId;
	}
	public Boolean getReadFlag() {
		return readFlag;
	}
	public void setReadFlag(Boolean readFlag) {
		this.readFlag = readFlag;
	}
	public Boolean getWriteFlag() {
		return writeFlag;
	}
	public void setWriteFlag(Boolean writeFlag) {
		this.writeFlag = writeFlag;
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
}
