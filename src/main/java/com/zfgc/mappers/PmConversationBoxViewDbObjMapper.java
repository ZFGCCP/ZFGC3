package com.zfgc.mappers;

import com.zfgc.dbobj.PmConversationBoxViewDbObj;
import com.zfgc.dbobj.PmConversationBoxViewDbObjExample;
import com.zfgc.dbobj.PmConversationBoxViewDbObjWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmConversationBoxViewDbObjMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PM_CONVERSATION_BOX_VIEW
	 * @mbggenerated  Sat Mar 03 11:27:18 EST 2018
	 */
	int countByExample(PmConversationBoxViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PM_CONVERSATION_BOX_VIEW
	 * @mbggenerated  Sat Mar 03 11:27:18 EST 2018
	 */
	int deleteByExample(PmConversationBoxViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PM_CONVERSATION_BOX_VIEW
	 * @mbggenerated  Sat Mar 03 11:27:18 EST 2018
	 */
	int insert(PmConversationBoxViewDbObjWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PM_CONVERSATION_BOX_VIEW
	 * @mbggenerated  Sat Mar 03 11:27:18 EST 2018
	 */
	int insertSelective(PmConversationBoxViewDbObjWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PM_CONVERSATION_BOX_VIEW
	 * @mbggenerated  Sat Mar 03 11:27:18 EST 2018
	 */
	List<PmConversationBoxViewDbObjWithBLOBs> selectByExampleWithBLOBs(
			PmConversationBoxViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PM_CONVERSATION_BOX_VIEW
	 * @mbggenerated  Sat Mar 03 11:27:18 EST 2018
	 */
	List<PmConversationBoxViewDbObj> selectByExample(
			PmConversationBoxViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PM_CONVERSATION_BOX_VIEW
	 * @mbggenerated  Sat Mar 03 11:27:18 EST 2018
	 */
	int updateByExampleSelective(
			@Param("record") PmConversationBoxViewDbObjWithBLOBs record,
			@Param("example") PmConversationBoxViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PM_CONVERSATION_BOX_VIEW
	 * @mbggenerated  Sat Mar 03 11:27:18 EST 2018
	 */
	int updateByExampleWithBLOBs(
			@Param("record") PmConversationBoxViewDbObjWithBLOBs record,
			@Param("example") PmConversationBoxViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PM_CONVERSATION_BOX_VIEW
	 * @mbggenerated  Sat Mar 03 11:27:18 EST 2018
	 */
	int updateByExample(@Param("record") PmConversationBoxViewDbObj record,
			@Param("example") PmConversationBoxViewDbObjExample example);
}