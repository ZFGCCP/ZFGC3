package com.zfgc.model.avatar;

import com.zfgc.model.BaseZfgcModel;

public class AvatarGallery extends BaseZfgcModel{

	private Integer avatarGalleryId;
	private String filePath;
	
	public Integer getAvatarGalleryId() {
		return avatarGalleryId;
	}

	public void setAvatarGalleryId(Integer avatarGalleryId) {
		this.avatarGalleryId = avatarGalleryId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}