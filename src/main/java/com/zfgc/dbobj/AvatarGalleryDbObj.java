package com.zfgc.dbobj;

public class AvatarGalleryDbObj {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column AVATAR_GALLERY.AVATAR_GALLERY_ID
	 * @mbggenerated  Sun Feb 05 21:19:42 EST 2017
	 */
	private Integer avatarGalleryId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column AVATAR_GALLERY.AVATAR_FILE_PATH
	 * @mbggenerated  Sun Feb 05 21:19:42 EST 2017
	 */
	private String avatarFilePath;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column AVATAR_GALLERY.AVATAR_GALLERY_ID
	 * @return  the value of AVATAR_GALLERY.AVATAR_GALLERY_ID
	 * @mbggenerated  Sun Feb 05 21:19:42 EST 2017
	 */
	public Integer getAvatarGalleryId() {
		return avatarGalleryId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column AVATAR_GALLERY.AVATAR_GALLERY_ID
	 * @param avatarGalleryId  the value for AVATAR_GALLERY.AVATAR_GALLERY_ID
	 * @mbggenerated  Sun Feb 05 21:19:42 EST 2017
	 */
	public void setAvatarGalleryId(Integer avatarGalleryId) {
		this.avatarGalleryId = avatarGalleryId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column AVATAR_GALLERY.AVATAR_FILE_PATH
	 * @return  the value of AVATAR_GALLERY.AVATAR_FILE_PATH
	 * @mbggenerated  Sun Feb 05 21:19:42 EST 2017
	 */
	public String getAvatarFilePath() {
		return avatarFilePath;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column AVATAR_GALLERY.AVATAR_FILE_PATH
	 * @param avatarFilePath  the value for AVATAR_GALLERY.AVATAR_FILE_PATH
	 * @mbggenerated  Sun Feb 05 21:19:42 EST 2017
	 */
	public void setAvatarFilePath(String avatarFilePath) {
		this.avatarFilePath = avatarFilePath;
	}
}