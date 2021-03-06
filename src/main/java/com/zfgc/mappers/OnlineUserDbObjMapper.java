package com.zfgc.mappers;

import com.zfgc.dbobj.OnlineUserDbObj;
import com.zfgc.dbobj.OnlineUserDbObjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OnlineUserDbObjMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table WHOS_ONLINE_VIEW
	 * @mbggenerated  Sun Mar 24 11:27:08 EDT 2019
	 */
	int countByExample(OnlineUserDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table WHOS_ONLINE_VIEW
	 * @mbggenerated  Sun Mar 24 11:27:08 EDT 2019
	 */
	int deleteByExample(OnlineUserDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table WHOS_ONLINE_VIEW
	 * @mbggenerated  Sun Mar 24 11:27:08 EDT 2019
	 */
	int insert(OnlineUserDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table WHOS_ONLINE_VIEW
	 * @mbggenerated  Sun Mar 24 11:27:08 EDT 2019
	 */
	int insertSelective(OnlineUserDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table WHOS_ONLINE_VIEW
	 * @mbggenerated  Sun Mar 24 11:27:08 EDT 2019
	 */
	List<OnlineUserDbObj> selectByExample(OnlineUserDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table WHOS_ONLINE_VIEW
	 * @mbggenerated  Sun Mar 24 11:27:08 EDT 2019
	 */
	int updateByExampleSelective(@Param("record") OnlineUserDbObj record,
			@Param("example") OnlineUserDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table WHOS_ONLINE_VIEW
	 * @mbggenerated  Sun Mar 24 11:27:08 EDT 2019
	 */
	int updateByExample(@Param("record") OnlineUserDbObj record,
			@Param("example") OnlineUserDbObjExample example);
}