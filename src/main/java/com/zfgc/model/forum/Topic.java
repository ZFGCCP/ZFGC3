package com.zfgc.model.forum;

import com.zfgc.model.BaseZfgcModel;

public class Topic extends BaseZfgcModel {
	private Integer threadId;
	private String name;
	private Integer threadStarterId;
	private String authorName;
	private Integer views;
	private Integer postIconId;
	private Integer postStatusId;
	private Boolean newPostsFlag;
	private Boolean lockedFlag;
	private Boolean stickyFlag;
	private Boolean pollFlag;
	private Integer parentForumId;
	private Integer postCount;
	public Integer getThreadId() {
		return threadId;
	}
	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getThreadStarterId() {
		return threadStarterId;
	}
	public void setThreadStarterId(Integer threadStarterId) {
		this.threadStarterId = threadStarterId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	public Integer getPostIconId() {
		return postIconId;
	}
	public void setPostIconId(Integer postIconId) {
		this.postIconId = postIconId;
	}
	public Integer getPostStatusId() {
		return postStatusId;
	}
	public void setPostStatusId(Integer postStatusId) {
		this.postStatusId = postStatusId;
	}
	public Boolean getNewPostsFlag() {
		return newPostsFlag;
	}
	public void setNewPostsFlag(Boolean newPostsFlag) {
		this.newPostsFlag = newPostsFlag;
	}
	public Boolean getLockedFlag() {
		return lockedFlag;
	}
	public void setLockedFlag(Boolean lockedFlag) {
		this.lockedFlag = lockedFlag;
	}
	public Boolean getStickyFlag() {
		return stickyFlag;
	}
	public void setStickyFlag(Boolean stickyFlag) {
		this.stickyFlag = stickyFlag;
	}
	public Boolean getPollFlag() {
		return pollFlag;
	}
	public void setPollFlag(Boolean pollFlag) {
		this.pollFlag = pollFlag;
	}
	public Integer getParentForumId() {
		return parentForumId;
	}
	public void setParentForumId(Integer parentForumId) {
		this.parentForumId = parentForumId;
	}
	public Integer getPostCount() {
		return postCount;
	}
	public void setPostCount(Integer postCount) {
		this.postCount = postCount;
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
