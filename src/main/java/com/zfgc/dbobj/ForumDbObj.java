package com.zfgc.dbobj;

public class ForumDbObj {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column FORUM.FORUM_ID
     *
     * @mbggenerated Mon Dec 19 20:39:08 EST 2016
     */
    private Short forumId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column FORUM.CATEGORY_ID
     *
     * @mbggenerated Mon Dec 19 20:39:08 EST 2016
     */
    private Integer categoryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column FORUM.PARENT_FORUM_ID
     *
     * @mbggenerated Mon Dec 19 20:39:08 EST 2016
     */
    private Short parentForumId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column FORUM.SEQ_NO
     *
     * @mbggenerated Mon Dec 19 20:39:08 EST 2016
     */
    private Integer seqNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column FORUM.NAME
     *
     * @mbggenerated Mon Dec 19 20:39:08 EST 2016
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column FORUM.DESCRIPTION
     *
     * @mbggenerated Mon Dec 19 20:39:08 EST 2016
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FORUM.FORUM_ID
     *
     * @return the value of FORUM.FORUM_ID
     *
     * @mbggenerated Mon Dec 19 20:39:08 EST 2016
     */
    public Short getForumId() {
        return forumId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FORUM.FORUM_ID
     *
     * @param forumId the value for FORUM.FORUM_ID
     *
     * @mbggenerated Mon Dec 19 20:39:08 EST 2016
     */
    public void setForumId(Short forumId) {
        this.forumId = forumId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FORUM.CATEGORY_ID
     *
     * @return the value of FORUM.CATEGORY_ID
     *
     * @mbggenerated Mon Dec 19 20:39:08 EST 2016
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FORUM.CATEGORY_ID
     *
     * @param categoryId the value for FORUM.CATEGORY_ID
     *
     * @mbggenerated Mon Dec 19 20:39:08 EST 2016
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FORUM.PARENT_FORUM_ID
     *
     * @return the value of FORUM.PARENT_FORUM_ID
     *
     * @mbggenerated Mon Dec 19 20:39:08 EST 2016
     */
    public Short getParentForumId() {
        return parentForumId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FORUM.PARENT_FORUM_ID
     *
     * @param parentForumId the value for FORUM.PARENT_FORUM_ID
     *
     * @mbggenerated Mon Dec 19 20:39:08 EST 2016
     */
    public void setParentForumId(Short parentForumId) {
        this.parentForumId = parentForumId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FORUM.SEQ_NO
     *
     * @return the value of FORUM.SEQ_NO
     *
     * @mbggenerated Mon Dec 19 20:39:08 EST 2016
     */
    public Integer getSeqNo() {
        return seqNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FORUM.SEQ_NO
     *
     * @param seqNo the value for FORUM.SEQ_NO
     *
     * @mbggenerated Mon Dec 19 20:39:08 EST 2016
     */
    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FORUM.NAME
     *
     * @return the value of FORUM.NAME
     *
     * @mbggenerated Mon Dec 19 20:39:08 EST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FORUM.NAME
     *
     * @param name the value for FORUM.NAME
     *
     * @mbggenerated Mon Dec 19 20:39:08 EST 2016
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FORUM.DESCRIPTION
     *
     * @return the value of FORUM.DESCRIPTION
     *
     * @mbggenerated Mon Dec 19 20:39:08 EST 2016
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FORUM.DESCRIPTION
     *
     * @param description the value for FORUM.DESCRIPTION
     *
     * @mbggenerated Mon Dec 19 20:39:08 EST 2016
     */
    public void setDescription(String description) {
        this.description = description;
    }
}