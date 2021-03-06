package com.zfgc.dbobj;

import java.util.Date;

public class PostContentDbObj {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POST_CONTENT.POST_CONTENT_ID
     *
     * @mbg.generated Sun Apr 26 13:56:01 EDT 2020
     */
    private Integer postContentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POST_CONTENT.THREAD_POST_ID
     *
     * @mbg.generated Sun Apr 26 13:56:01 EDT 2020
     */
    private Integer threadPostId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POST_CONTENT.CREATED_TS
     *
     * @mbg.generated Sun Apr 26 13:56:01 EDT 2020
     */
    private Date createdTs;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POST_CONTENT.AUTHOR_ID
     *
     * @mbg.generated Sun Apr 26 13:56:01 EDT 2020
     */
    private Integer authorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POST_CONTENT.CURRENT_FLAG
     *
     * @mbg.generated Sun Apr 26 13:56:01 EDT 2020
     */
    private Boolean currentFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POST_CONTENT.POST_DATA
     *
     * @mbg.generated Sun Apr 26 13:56:01 EDT 2020
     */
    private String postData;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POST_CONTENT.POST_CONTENT_ID
     *
     * @return the value of POST_CONTENT.POST_CONTENT_ID
     *
     * @mbg.generated Sun Apr 26 13:56:01 EDT 2020
     */
    public Integer getPostContentId() {
        return postContentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POST_CONTENT.POST_CONTENT_ID
     *
     * @param postContentId the value for POST_CONTENT.POST_CONTENT_ID
     *
     * @mbg.generated Sun Apr 26 13:56:01 EDT 2020
     */
    public void setPostContentId(Integer postContentId) {
        this.postContentId = postContentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POST_CONTENT.THREAD_POST_ID
     *
     * @return the value of POST_CONTENT.THREAD_POST_ID
     *
     * @mbg.generated Sun Apr 26 13:56:01 EDT 2020
     */
    public Integer getThreadPostId() {
        return threadPostId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POST_CONTENT.THREAD_POST_ID
     *
     * @param threadPostId the value for POST_CONTENT.THREAD_POST_ID
     *
     * @mbg.generated Sun Apr 26 13:56:01 EDT 2020
     */
    public void setThreadPostId(Integer threadPostId) {
        this.threadPostId = threadPostId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POST_CONTENT.CREATED_TS
     *
     * @return the value of POST_CONTENT.CREATED_TS
     *
     * @mbg.generated Sun Apr 26 13:56:01 EDT 2020
     */
    public Date getCreatedTs() {
        return createdTs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POST_CONTENT.CREATED_TS
     *
     * @param createdTs the value for POST_CONTENT.CREATED_TS
     *
     * @mbg.generated Sun Apr 26 13:56:01 EDT 2020
     */
    public void setCreatedTs(Date createdTs) {
        this.createdTs = createdTs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POST_CONTENT.AUTHOR_ID
     *
     * @return the value of POST_CONTENT.AUTHOR_ID
     *
     * @mbg.generated Sun Apr 26 13:56:01 EDT 2020
     */
    public Integer getAuthorId() {
        return authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POST_CONTENT.AUTHOR_ID
     *
     * @param authorId the value for POST_CONTENT.AUTHOR_ID
     *
     * @mbg.generated Sun Apr 26 13:56:01 EDT 2020
     */
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POST_CONTENT.CURRENT_FLAG
     *
     * @return the value of POST_CONTENT.CURRENT_FLAG
     *
     * @mbg.generated Sun Apr 26 13:56:01 EDT 2020
     */
    public Boolean getCurrentFlag() {
        return currentFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POST_CONTENT.CURRENT_FLAG
     *
     * @param currentFlag the value for POST_CONTENT.CURRENT_FLAG
     *
     * @mbg.generated Sun Apr 26 13:56:01 EDT 2020
     */
    public void setCurrentFlag(Boolean currentFlag) {
        this.currentFlag = currentFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POST_CONTENT.POST_DATA
     *
     * @return the value of POST_CONTENT.POST_DATA
     *
     * @mbg.generated Sun Apr 26 13:56:01 EDT 2020
     */
    public String getPostData() {
        return postData;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POST_CONTENT.POST_DATA
     *
     * @param postData the value for POST_CONTENT.POST_DATA
     *
     * @mbg.generated Sun Apr 26 13:56:01 EDT 2020
     */
    public void setPostData(String postData) {
        this.postData = postData;
    }
}