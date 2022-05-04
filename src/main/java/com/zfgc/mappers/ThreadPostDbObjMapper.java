package com.zfgc.mappers;

import com.zfgc.dbobj.ThreadPostDbObj;
import com.zfgc.dbobj.ThreadPostDbObjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThreadPostDbObjMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	long countByExample(ThreadPostDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	int deleteByExample(ThreadPostDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	int deleteByPrimaryKey(Integer threadPostId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	int insert(ThreadPostDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	int insertSelective(ThreadPostDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	List<ThreadPostDbObj> selectByExample(ThreadPostDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	ThreadPostDbObj selectByPrimaryKey(Integer threadPostId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	int updateByExampleSelective(@Param("record") ThreadPostDbObj record,
			@Param("example") ThreadPostDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	int updateByExample(@Param("record") ThreadPostDbObj record, @Param("example") ThreadPostDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	int updateByPrimaryKeySelective(ThreadPostDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	int updateByPrimaryKey(ThreadPostDbObj record);
}