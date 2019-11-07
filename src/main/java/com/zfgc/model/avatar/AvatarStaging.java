package com.zfgc.model.avatar;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.model.BaseZfgcModel;

public class AvatarStaging extends BaseZfgcModel {

	private Integer avatarStagingId;
	
	@JsonIgnore
    private String filename;
    private Integer usersId;
    private String mac;
    
    @JsonIgnore
    private Date createdTs;

	
	public Integer getAvatarStagingId() {
		return avatarStagingId;
	}


	public void setAvatarStagingId(Integer avatarStagingId) {
		this.avatarStagingId = avatarStagingId;
	}


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public Integer getUsersId() {
		return usersId;
	}


	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}


	public String getMac() {
		return mac;
	}


	public void setMac(String mac) {
		this.mac = mac;
	}


	public Date getCreatedTs() {
		return createdTs;
	}


	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}


	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}