package com.zfgc.model.users.profile;

import com.zfgc.model.BaseZfgcModel;

public class Avatar extends BaseZfgcModel{

	private Integer avatarId;
	private Integer avatarTypeId;
	private Integer avatarGalleryId;
	private String avatarFilename;
	private String avatarUrl;
	
	public Integer getAvatarId() {
		return avatarId;
	}

	public void setAvatarId(Integer avatarId) {
		this.avatarId = avatarId;
	}

	public Integer getAvatarTypeId() {
		return avatarTypeId;
	}

	public void setAvatarTypeId(Integer avatarTypeId) {
		this.avatarTypeId = avatarTypeId;
	}

	public Integer getAvatarGalleryId() {
		return avatarGalleryId;
	}

	public void setAvatarGalleryId(Integer avatarGalleryId) {
		this.avatarGalleryId = avatarGalleryId;
	}

	public String getAvatarFilename() {
		return avatarFilename;
	}

	public void setAvatarFilename(String avatarFilename) {
		this.avatarFilename = avatarFilename;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}