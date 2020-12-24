package com.zfgc.model.forum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.constants.Forum.ForumConstants;
import com.zfgc.model.BaseZfgcModel;

public class Forum extends BaseZfgcModel {
	private Short forumId;
	private Integer categoryId;
	private Short parentForumId;
	private Integer seqNo;
	private String name;
	private String description;
	private Long threadsCount;
	private Integer totalThreadsCount;
	private Integer totalPages;
	
	private List<Forum> subForums = new ArrayList<>();
	
	private List<Topic> stickyThreads = new ArrayList<>();
	private List<Topic> threads = new ArrayList<>();
	
	public List<Topic> getStickyThreads() {
		return stickyThreads;
	}
	public void setStickyThreads(List<Topic> stickyThreads) {
		this.stickyThreads = stickyThreads;
	}
	public List<Topic> getThreads() {
		return threads;
	}
	public void setThreads(List<Topic> threads) {
		this.threads = threads;
	}
	private Boolean canRead = false;
	private Boolean canWrite = false;
	
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
	public Long getTotalThreadsCount() {
		Long total = threadsCount == null ? 0 : threadsCount;
		
		for(Forum forum : subForums){
			total += forum.getTotalThreadsCount() == null ? 0 : forum.getTotalThreadsCount();
		}
		
		return total;
	}
	public void setTotalThreadsCount(Integer totalThreadsCount) {
		this.totalThreadsCount = totalThreadsCount;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
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
	public Boolean getCanRead() {
		return canRead;
	}
	public void setCanRead(Boolean canRead) {
		this.canRead = canRead;
	}
	public Boolean getCanWrite() {
		return canWrite;
	}
	public void setCanWrite(Boolean canWrite) {
		this.canWrite = canWrite;
	}
	public Long getThreadsCount() {
		return threadsCount;
	}
	public void setThreadsCount(Long threadsCount) {
		this.threadsCount = threadsCount;
	}
}
