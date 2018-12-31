package com.zfgc.model.avatar;

import com.zfgc.model.BaseZfgcModel;

public class Avatar extends BaseZfgcModel {
	
	private Integer avatarId;
	private String avatarFileName;
	private String avatarUrl;
	private Integer avatarGalleryId;
	private Integer avatarTypeId;
	
	public Integer getAvatarId() {
		return avatarId;
	}

	public String getAvatarFileName() {
		return avatarFileName;
	}

	public void setAvatarFileName(String avatarFileName) {
		this.avatarFileName = avatarFileName;
	}

	public void setAvatarId(Integer avatarId) {
		this.avatarId = avatarId;
	}


	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getAvatarGalleryId() {
		return avatarGalleryId;
	}

	public void setAvatarGalleryId(Integer avatarGalleryId) {
		this.avatarGalleryId = avatarGalleryId;
	}

	public Integer getAvatarTypeId() {
		return avatarTypeId;
	}

	public void setAvatarTypeId(Integer avatarTypeId) {
		this.avatarTypeId = avatarTypeId;
	}

	@Override
	public BaseZfgcModel copy(BaseZfgcModel other) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	
}
