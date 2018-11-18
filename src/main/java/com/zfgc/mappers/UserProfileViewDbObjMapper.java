package com.zfgc.mappers;

import com.zfgc.dbobj.UserProfileViewDbObj;
import com.zfgc.dbobj.UserProfileViewDbObjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserProfileViewDbObjMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table USER_PROFILE_VIEW
	 * @mbg.generated  Sat Nov 17 21:52:42 EST 2018
	 */
	long countByExample(UserProfileViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table USER_PROFILE_VIEW
	 * @mbg.generated  Sat Nov 17 21:52:42 EST 2018
	 */
	int deleteByExample(UserProfileViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table USER_PROFILE_VIEW
	 * @mbg.generated  Sat Nov 17 21:52:42 EST 2018
	 */
	int insert(UserProfileViewDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table USER_PROFILE_VIEW
	 * @mbg.generated  Sat Nov 17 21:52:42 EST 2018
	 */
	int insertSelective(UserProfileViewDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table USER_PROFILE_VIEW
	 * @mbg.generated  Sat Nov 17 21:52:42 EST 2018
	 */
	List<UserProfileViewDbObj> selectByExample(UserProfileViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table USER_PROFILE_VIEW
	 * @mbg.generated  Sat Nov 17 21:52:42 EST 2018
	 */
	int updateByExampleSelective(@Param("record") UserProfileViewDbObj record,
			@Param("example") UserProfileViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table USER_PROFILE_VIEW
	 * @mbg.generated  Sat Nov 17 21:52:42 EST 2018
	 */
	int updateByExample(@Param("record") UserProfileViewDbObj record,
			@Param("example") UserProfileViewDbObjExample example);
}