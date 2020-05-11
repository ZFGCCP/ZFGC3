package com.zfgc.model.forum;

import java.util.ArrayList;
import java.util.List;

import com.zfgc.model.BaseZfgcModel;

public class Thread extends BaseZfgcModel {
	private Integer threadId;
	private String name;
	private Integer threadStarterId;
	private String authorName;
	private Integer views = 0;
	private Integer postIconId;
	private Integer postStatusId = 0;
	private Boolean newPostsFlag = false;
	private Boolean lockedFlag = false;
	private Boolean stickyFlag = false;
	private Boolean pollFlag = false;
	private Integer parentForumId;
	private Integer latestPostId = 0;
	private Integer postCount;
	
	private List<ThreadPost> posts = new ArrayList<>();
	
	public List<ThreadPost> getPosts() {
		return posts;
	}
	public void setPosts(List<ThreadPost> posts) {
		this.posts = posts;
	}
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
	
	public ThreadPost getHeadPost() {
		if(posts.isEmpty()) {
			return null;
		}
		
		return posts.get(0);
	}
	
	public ThreadPost getTailPost() {
		if(posts.isEmpty()) {
			return null;
		}

		return posts.get(posts.size() - 1);

	}
	public Integer getLatestPostId() {
		return latestPostId;
	}
	public void setLatestPostId(Integer latestPostId) {
		this.latestPostId = latestPostId;
	}
}
