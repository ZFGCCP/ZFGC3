package com.zfgc.mappers;

import com.zfgc.dbobj.OnlineUserDetailDbObj;
import com.zfgc.dbobj.OnlineUserDetailDbObjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OnlineUserDetailDbObjMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table WHOS_ONLINE_DETAIL_VIEW
	 * @mbg.generated  Sun Jun 23 00:33:28 EDT 2019
	 */
	long countByExample(OnlineUserDetailDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table WHOS_ONLINE_DETAIL_VIEW
	 * @mbg.generated  Sun Jun 23 00:33:28 EDT 2019
	 */
	int deleteByExample(OnlineUserDetailDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table WHOS_ONLINE_DETAIL_VIEW
	 * @mbg.generated  Sun Jun 23 00:33:28 EDT 2019
	 */
	int insert(OnlineUserDetailDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table WHOS_ONLINE_DETAIL_VIEW
	 * @mbg.generated  Sun Jun 23 00:33:28 EDT 2019
	 */
	int insertSelective(OnlineUserDetailDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table WHOS_ONLINE_DETAIL_VIEW
	 * @mbg.generated  Sun Jun 23 00:33:28 EDT 2019
	 */
	List<OnlineUserDetailDbObj> selectByExample(OnlineUserDetailDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table WHOS_ONLINE_DETAIL_VIEW
	 * @mbg.generated  Sun Jun 23 00:33:28 EDT 2019
	 */
	int updateByExampleSelective(@Param("record") OnlineUserDetailDbObj record,
			@Param("example") OnlineUserDetailDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table WHOS_ONLINE_DETAIL_VIEW
	 * @mbg.generated  Sun Jun 23 00:33:28 EDT 2019
	 */
	int updateByExample(@Param("record") OnlineUserDetailDbObj record,
			@Param("example") OnlineUserDetailDbObjExample example);
}