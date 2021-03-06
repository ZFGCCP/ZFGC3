package com.zfgc.mappers;

import com.zfgc.dbobj.BbCodeAttributeDbObj;
import com.zfgc.dbobj.BbCodeAttributeDbObjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbCodeAttributeDbObjMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BB_CODE_ATTRIBUTE
	 * @mbggenerated  Thu Jun 22 22:39:16 EDT 2017
	 */
	int countByExample(BbCodeAttributeDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BB_CODE_ATTRIBUTE
	 * @mbggenerated  Thu Jun 22 22:39:16 EDT 2017
	 */
	int deleteByExample(BbCodeAttributeDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BB_CODE_ATTRIBUTE
	 * @mbggenerated  Thu Jun 22 22:39:16 EDT 2017
	 */
	int deleteByPrimaryKey(Integer bbCodeAttributeId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BB_CODE_ATTRIBUTE
	 * @mbggenerated  Thu Jun 22 22:39:16 EDT 2017
	 */
	int insert(BbCodeAttributeDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BB_CODE_ATTRIBUTE
	 * @mbggenerated  Thu Jun 22 22:39:16 EDT 2017
	 */
	int insertSelective(BbCodeAttributeDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BB_CODE_ATTRIBUTE
	 * @mbggenerated  Thu Jun 22 22:39:16 EDT 2017
	 */
	List<BbCodeAttributeDbObj> selectByExample(
			BbCodeAttributeDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BB_CODE_ATTRIBUTE
	 * @mbggenerated  Thu Jun 22 22:39:16 EDT 2017
	 */
	BbCodeAttributeDbObj selectByPrimaryKey(Integer bbCodeAttributeId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BB_CODE_ATTRIBUTE
	 * @mbggenerated  Thu Jun 22 22:39:16 EDT 2017
	 */
	int updateByExampleSelective(@Param("record") BbCodeAttributeDbObj record,
			@Param("example") BbCodeAttributeDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BB_CODE_ATTRIBUTE
	 * @mbggenerated  Thu Jun 22 22:39:16 EDT 2017
	 */
	int updateByExample(@Param("record") BbCodeAttributeDbObj record,
			@Param("example") BbCodeAttributeDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BB_CODE_ATTRIBUTE
	 * @mbggenerated  Thu Jun 22 22:39:16 EDT 2017
	 */
	int updateByPrimaryKeySelective(BbCodeAttributeDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BB_CODE_ATTRIBUTE
	 * @mbggenerated  Thu Jun 22 22:39:16 EDT 2017
	 */
	int updateByPrimaryKey(BbCodeAttributeDbObj record);
}