package com.zfgc.mappers;

import com.zfgc.dbobj.PmConversationDbObj;
import com.zfgc.dbobj.PmConversationDbObjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmConversationDbObjMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PM_CONVERSATION
	 * @mbg.generated  Sat Jun 01 23:30:34 EDT 2019
	 */
	long countByExample(PmConversationDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PM_CONVERSATION
	 * @mbg.generated  Sat Jun 01 23:30:34 EDT 2019
	 */
	int deleteByExample(PmConversationDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PM_CONVERSATION
	 * @mbg.generated  Sat Jun 01 23:30:34 EDT 2019
	 */
	int deleteByPrimaryKey(Integer pmConversationId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PM_CONVERSATION
	 * @mbg.generated  Sat Jun 01 23:30:34 EDT 2019
	 */
	int insert(PmConversationDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PM_CONVERSATION
	 * @mbg.generated  Sat Jun 01 23:30:34 EDT 2019
	 */
	int insertSelective(PmConversationDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PM_CONVERSATION
	 * @mbg.generated  Sat Jun 01 23:30:34 EDT 2019
	 */
	List<PmConversationDbObj> selectByExample(PmConversationDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PM_CONVERSATION
	 * @mbg.generated  Sat Jun 01 23:30:34 EDT 2019
	 */
	PmConversationDbObj selectByPrimaryKey(Integer pmConversationId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PM_CONVERSATION
	 * @mbg.generated  Sat Jun 01 23:30:34 EDT 2019
	 */
	int updateByExampleSelective(@Param("record") PmConversationDbObj record,
			@Param("example") PmConversationDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PM_CONVERSATION
	 * @mbg.generated  Sat Jun 01 23:30:34 EDT 2019
	 */
	int updateByExample(@Param("record") PmConversationDbObj record,
			@Param("example") PmConversationDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PM_CONVERSATION
	 * @mbg.generated  Sat Jun 01 23:30:34 EDT 2019
	 */
	int updateByPrimaryKeySelective(PmConversationDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PM_CONVERSATION
	 * @mbg.generated  Sat Jun 01 23:30:34 EDT 2019
	 */
	int updateByPrimaryKey(PmConversationDbObj record);
}