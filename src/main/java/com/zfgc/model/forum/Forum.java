package com.zfgc.model.forum;

import java.util.ArrayList;
import java.util.List;

import com.zfgc.model.BaseZfgcModel;

public class Forum extends BaseZfgcModel {
	private Short forumId;
	private Integer categoryId;
	private Short parentForumId;
	private Integer seqNo;
	private String name;
	private String description;
	
	private List<Forum> subForums = new ArrayList<>();
	
	public Short getForumId() {
		return forumId;
	}
	public void setForumId(Short forumId) {
		this.forumId = forumId;
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
	public Integer getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
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
	public List<Forum> getSubForums() {
		return subForums;
	}
	public void setSubForums(List<Forum> subForums) {
		this.subForums = subForums;
	}
}
