package com.zfgc.model.forum;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.util.time.ZfgcTimeUtils;

public class PostContent extends BaseZfgcModel {

	private String body;
	private String subject;
	private String icon;
	private Integer postContentId;
	private Integer authorId;
	private Integer threadPostId;
	private String postData;
	private Boolean currentFlag;
	
	@JsonIgnore
	private Date createdTs;
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getPostContentId() {
		return postContentId;
	}

	public void setPostContentId(Integer postContentId) {
		this.postContentId = postContentId;
	}

	public Date getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}
	
	public String getCreatedTsAsString() {
		if(createdTs == null) {
			return "";
		}
		
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat(super.getUserTimeZone());
		return sdf.format(createdTs);
	}
	
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getThreadPostId() {
		return threadPostId;
	}

	public void setThreadPostId(Integer threadPostId) {
		this.threadPostId = threadPostId;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getPostData() {
		return postData;
	}

	public void setPostData(String postData) {
		this.postData = postData;
	}

	public Boolean getCurrentFlag() {
		return currentFlag;
	}

	public void setCurrentFlag(Boolean currentFlag) {
		this.currentFlag = currentFlag;
	}

}
