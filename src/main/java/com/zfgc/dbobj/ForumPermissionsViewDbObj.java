package com.zfgc.dbobj;

public class ForumPermissionsViewDbObj {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FORUM_PERMISSIONS_VIEW.FORUM_ID
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	private Short forumId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FORUM_PERMISSIONS_VIEW.PERMISSION_ID
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	private Integer permissionId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FORUM_PERMISSIONS_VIEW.READ_FLAG
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	private Boolean readFlag;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FORUM_PERMISSIONS_VIEW.WRITE_FLAG
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	private Boolean writeFlag;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FORUM_PERMISSIONS_VIEW.NAME
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FORUM_PERMISSIONS_VIEW.DESCRIPTION
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	private String description;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FORUM_PERMISSIONS_VIEW.CATEGORY_ID
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	private Integer categoryId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FORUM_PERMISSIONS_VIEW.PARENT_FORUM_ID
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	private Short parentForumId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FORUM_PERMISSIONS_VIEW.FORUM_ID
	 * @return  the value of FORUM_PERMISSIONS_VIEW.FORUM_ID
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	public Short getForumId() {
		return forumId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FORUM_PERMISSIONS_VIEW.FORUM_ID
	 * @param forumId  the value for FORUM_PERMISSIONS_VIEW.FORUM_ID
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	public void setForumId(Short forumId) {
		this.forumId = forumId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FORUM_PERMISSIONS_VIEW.PERMISSION_ID
	 * @return  the value of FORUM_PERMISSIONS_VIEW.PERMISSION_ID
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	public Integer getPermissionId() {
		return permissionId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FORUM_PERMISSIONS_VIEW.PERMISSION_ID
	 * @param permissionId  the value for FORUM_PERMISSIONS_VIEW.PERMISSION_ID
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FORUM_PERMISSIONS_VIEW.READ_FLAG
	 * @return  the value of FORUM_PERMISSIONS_VIEW.READ_FLAG
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	public Boolean getReadFlag() {
		return readFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FORUM_PERMISSIONS_VIEW.READ_FLAG
	 * @param readFlag  the value for FORUM_PERMISSIONS_VIEW.READ_FLAG
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	public void setReadFlag(Boolean readFlag) {
		this.readFlag = readFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FORUM_PERMISSIONS_VIEW.WRITE_FLAG
	 * @return  the value of FORUM_PERMISSIONS_VIEW.WRITE_FLAG
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	public Boolean getWriteFlag() {
		return writeFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FORUM_PERMISSIONS_VIEW.WRITE_FLAG
	 * @param writeFlag  the value for FORUM_PERMISSIONS_VIEW.WRITE_FLAG
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	public void setWriteFlag(Boolean writeFlag) {
		this.writeFlag = writeFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FORUM_PERMISSIONS_VIEW.NAME
	 * @return  the value of FORUM_PERMISSIONS_VIEW.NAME
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FORUM_PERMISSIONS_VIEW.NAME
	 * @param name  the value for FORUM_PERMISSIONS_VIEW.NAME
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FORUM_PERMISSIONS_VIEW.DESCRIPTION
	 * @return  the value of FORUM_PERMISSIONS_VIEW.DESCRIPTION
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FORUM_PERMISSIONS_VIEW.DESCRIPTION
	 * @param description  the value for FORUM_PERMISSIONS_VIEW.DESCRIPTION
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FORUM_PERMISSIONS_VIEW.CATEGORY_ID
	 * @return  the value of FORUM_PERMISSIONS_VIEW.CATEGORY_ID
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FORUM_PERMISSIONS_VIEW.CATEGORY_ID
	 * @param categoryId  the value for FORUM_PERMISSIONS_VIEW.CATEGORY_ID
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FORUM_PERMISSIONS_VIEW.PARENT_FORUM_ID
	 * @return  the value of FORUM_PERMISSIONS_VIEW.PARENT_FORUM_ID
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	public Short getParentForumId() {
		return parentForumId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FORUM_PERMISSIONS_VIEW.PARENT_FORUM_ID
	 * @param parentForumId  the value for FORUM_PERMISSIONS_VIEW.PARENT_FORUM_ID
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	public void setParentForumId(Short parentForumId) {
		this.parentForumId = parentForumId;
	}
}