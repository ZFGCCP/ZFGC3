package com.zfgc.dbobj;

import java.util.Date;

public class ThreadPostDbObj {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column THREAD_POST.THREAD_POST_ID
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	private Integer threadPostId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column THREAD_POST.THREAD_ID
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	private Integer threadId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column THREAD_POST.AUTHOR_ID
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	private Integer authorId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column THREAD_POST.CREATED_TS
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	private Date createdTs;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column THREAD_POST.THREAD_POST_ID
	 * @return  the value of THREAD_POST.THREAD_POST_ID
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	public Integer getThreadPostId() {
		return threadPostId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column THREAD_POST.THREAD_POST_ID
	 * @param threadPostId  the value for THREAD_POST.THREAD_POST_ID
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	public void setThreadPostId(Integer threadPostId) {
		this.threadPostId = threadPostId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column THREAD_POST.THREAD_ID
	 * @return  the value of THREAD_POST.THREAD_ID
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	public Integer getThreadId() {
		return threadId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column THREAD_POST.THREAD_ID
	 * @param threadId  the value for THREAD_POST.THREAD_ID
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column THREAD_POST.AUTHOR_ID
	 * @return  the value of THREAD_POST.AUTHOR_ID
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	public Integer getAuthorId() {
		return authorId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column THREAD_POST.AUTHOR_ID
	 * @param authorId  the value for THREAD_POST.AUTHOR_ID
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column THREAD_POST.CREATED_TS
	 * @return  the value of THREAD_POST.CREATED_TS
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	public Date getCreatedTs() {
		return createdTs;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column THREAD_POST.CREATED_TS
	 * @param createdTs  the value for THREAD_POST.CREATED_TS
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}
}