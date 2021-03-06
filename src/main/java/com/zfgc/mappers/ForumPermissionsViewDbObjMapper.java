package com.zfgc.mappers;

import com.zfgc.dbobj.ForumPermissionsViewDbObj;
import com.zfgc.dbobj.ForumPermissionsViewDbObjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ForumPermissionsViewDbObjMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	long countByExample(ForumPermissionsViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	int deleteByExample(ForumPermissionsViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	int insert(ForumPermissionsViewDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	int insertSelective(ForumPermissionsViewDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	List<ForumPermissionsViewDbObj> selectByExample(ForumPermissionsViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	int updateByExampleSelective(@Param("record") ForumPermissionsViewDbObj record,
			@Param("example") ForumPermissionsViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Sat May 30 10:56:15 EDT 2020
	 */
	int updateByExample(@Param("record") ForumPermissionsViewDbObj record,
			@Param("example") ForumPermissionsViewDbObjExample example);
}