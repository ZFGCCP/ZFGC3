package com.zfgc.mappers;

import com.zfgc.dbobj.brMemberGroupForumDbObj;
import com.zfgc.dbobj.brMemberGroupForumDbObjExample;
import com.zfgc.dbobj.brMemberGroupForumDbObjKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface brMemberGroupForumDbObjMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BR_MEMBER_GROUP_FORUM
	 * @mbg.generated  Sat May 30 10:52:56 EDT 2020
	 */
	long countByExample(brMemberGroupForumDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BR_MEMBER_GROUP_FORUM
	 * @mbg.generated  Sat May 30 10:52:56 EDT 2020
	 */
	int deleteByExample(brMemberGroupForumDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BR_MEMBER_GROUP_FORUM
	 * @mbg.generated  Sat May 30 10:52:56 EDT 2020
	 */
	int deleteByPrimaryKey(brMemberGroupForumDbObjKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BR_MEMBER_GROUP_FORUM
	 * @mbg.generated  Sat May 30 10:52:56 EDT 2020
	 */
	int insert(brMemberGroupForumDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BR_MEMBER_GROUP_FORUM
	 * @mbg.generated  Sat May 30 10:52:56 EDT 2020
	 */
	int insertSelective(brMemberGroupForumDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BR_MEMBER_GROUP_FORUM
	 * @mbg.generated  Sat May 30 10:52:56 EDT 2020
	 */
	List<brMemberGroupForumDbObj> selectByExample(brMemberGroupForumDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BR_MEMBER_GROUP_FORUM
	 * @mbg.generated  Sat May 30 10:52:56 EDT 2020
	 */
	brMemberGroupForumDbObj selectByPrimaryKey(brMemberGroupForumDbObjKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BR_MEMBER_GROUP_FORUM
	 * @mbg.generated  Sat May 30 10:52:56 EDT 2020
	 */
	int updateByExampleSelective(@Param("record") brMemberGroupForumDbObj record,
			@Param("example") brMemberGroupForumDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BR_MEMBER_GROUP_FORUM
	 * @mbg.generated  Sat May 30 10:52:56 EDT 2020
	 */
	int updateByExample(@Param("record") brMemberGroupForumDbObj record,
			@Param("example") brMemberGroupForumDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BR_MEMBER_GROUP_FORUM
	 * @mbg.generated  Sat May 30 10:52:56 EDT 2020
	 */
	int updateByPrimaryKeySelective(brMemberGroupForumDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BR_MEMBER_GROUP_FORUM
	 * @mbg.generated  Sat May 30 10:52:56 EDT 2020
	 */
	int updateByPrimaryKey(brMemberGroupForumDbObj record);
}