package com.zfgc.dbobj;

public class AvatarGalleryDbObj {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column AVATAR_GALLERY.AVATAR_GALLERY_ID
	 * @mbggenerated  Wed Nov 14 23:10:41 EST 2018
	 */
	private Integer avatarGalleryId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column AVATAR_GALLERY.FILE_PATH
	 * @mbggenerated  Wed Nov 14 23:10:41 EST 2018
	 */
	private String filePath;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column AVATAR_GALLERY.AVATAR_GALLERY_ID
	 * @return  the value of AVATAR_GALLERY.AVATAR_GALLERY_ID
	 * @mbggenerated  Wed Nov 14 23:10:41 EST 2018
	 */
	public Integer getAvatarGalleryId() {
		return avatarGalleryId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column AVATAR_GALLERY.AVATAR_GALLERY_ID
	 * @param avatarGalleryId  the value for AVATAR_GALLERY.AVATAR_GALLERY_ID
	 * @mbggenerated  Wed Nov 14 23:10:41 EST 2018
	 */
	public void setAvatarGalleryId(Integer avatarGalleryId) {
		this.avatarGalleryId = avatarGalleryId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column AVATAR_GALLERY.FILE_PATH
	 * @return  the value of AVATAR_GALLERY.FILE_PATH
	 * @mbggenerated  Wed Nov 14 23:10:41 EST 2018
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column AVATAR_GALLERY.FILE_PATH
	 * @param filePath  the value for AVATAR_GALLERY.FILE_PATH
	 * @mbggenerated  Wed Nov 14 23:10:41 EST 2018
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}