package com.zfgc.mappers;

import com.zfgc.dbobj.PersonalMessageDbObj;
import com.zfgc.dbobj.PersonalMessageDbObjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.zfgc.dbobj.PersonalMessageDbObjWithBLOBs;

public interface PersonalMessageDbObjMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	int countByExample(PersonalMessageDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	int deleteByExample(PersonalMessageDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	int deleteByPrimaryKey(Integer personalMessageId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	int insert(PersonalMessageDbObjWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	int insertSelective(PersonalMessageDbObjWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	List<PersonalMessageDbObjWithBLOBs> selectByExampleWithBLOBs(
			PersonalMessageDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	List<PersonalMessageDbObj> selectByExample(
			PersonalMessageDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	PersonalMessageDbObjWithBLOBs selectByPrimaryKey(Integer personalMessageId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	int updateByExampleSelective(
			@Param("record") PersonalMessageDbObjWithBLOBs record,
			@Param("example") PersonalMessageDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	int updateByExampleWithBLOBs(
			@Param("record") PersonalMessageDbObjWithBLOBs record,
			@Param("example") PersonalMessageDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	int updateByExample(@Param("record") PersonalMessageDbObj record,
			@Param("example") PersonalMessageDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	int updateByPrimaryKeySelective(PersonalMessageDbObjWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	int updateByPrimaryKeyWithBLOBs(PersonalMessageDbObjWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	int updateByPrimaryKey(PersonalMessageDbObj record);
}