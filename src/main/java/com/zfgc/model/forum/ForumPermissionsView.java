package com.zfgc.model.forum;

import com.zfgc.model.BaseZfgcModel;

public class ForumPermissionsView extends BaseZfgcModel{

	private Short forumId;
    private Integer memberGroupId;
    private Boolean readFlag;
    private Boolean writeFlag;
    private String name;
    private String description;
    private Integer categoryId;
    private Short parentForumId;
    
	public Short getForumId() {
		return forumId;
	}

	public void setForumId(Short forumId) {
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



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Integer getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}



	public Short getParentForumId() {
		return parentForumId;
	}



	public void setParentForumId(Short parentForumId) {
		this.parentForumId = parentForumId;
	}



	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}