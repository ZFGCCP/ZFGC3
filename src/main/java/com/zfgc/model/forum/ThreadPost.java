package com.zfgc.model.forum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.util.time.ZfgcTimeUtils;

public class ThreadPost extends BaseZfgcModel {

	private Integer threadPostId;
    private Integer threadId;
    private Integer authorId;
    
    private List<PostContent> content = new ArrayList<>();
    
    @JsonIgnore
    private Date createdTs;
    
    @JsonIgnore
    private Date updatedTs;
	
	public Integer getThreadPostId() {
		return threadPostId;
	}

	public void setThreadPostId(Integer threadPostId) {
		this.threadPostId = threadPostId;
	}

	public Integer getThreadId() {
		return threadId;
	}

	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public Date getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}
	
	public String getCreatedTsAsString() {
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateTimeFormat(super.getUserTimeZone());
		
		if(createdTs == null) {
			return "";
		}
		
		return sdf.format(createdTs);
	}

	public void setCreatedTsAsString(String createdTsAsString) {
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateTimeFormat(super.getUserTimeZone());
		
		try {
			createdTs = sdf.parse(createdTsAsString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public Date getUpdatedTs() {
		return updatedTs;
	}

	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}
	
	public String getUpdatedTsAsString() {
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateTimeFormat(super.getUserTimeZone());
		
		if(updatedTs == null) {
			return "";
		}
		
		return sdf.format(updatedTs);
	}

	public void setUpdatedTsAsString(String updatedTsAsString) {
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateTimeFormat(super.getUserTimeZone());
		
		try {
			updatedTs = sdf.parse(updatedTsAsString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PostContent> getContent() {
		return content;
	}

	public void setContent(List<PostContent> content) {
		this.content = content;
	}

}