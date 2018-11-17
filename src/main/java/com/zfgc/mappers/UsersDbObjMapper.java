package com.zfgc.mappers;

import com.zfgc.dbobj.UsersDbObj;
import com.zfgc.dbobj.UsersDbObjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersDbObjMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbggenerated  Wed Nov 14 23:10:41 EST 2018
	 */
	int countByExample(UsersDbObjExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbggenerated  Wed Nov 14 23:10:41 EST 2018
	 */
	int deleteByExample(UsersDbObjExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbggenerated  Wed Nov 14 23:10:41 EST 2018
	 */
	int deleteByPrimaryKey(Integer usersId);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbggenerated  Wed Nov 14 23:10:41 EST 2018
	 */
	int insert(UsersDbObj record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbggenerated  Wed Nov 14 23:10:41 EST 2018
	 */
	int insertSelective(UsersDbObj record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbggenerated  Wed Nov 14 23:10:41 EST 2018
	 */
	List<UsersDbObj> selectByExample(UsersDbObjExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbggenerated  Wed Nov 14 23:10:41 EST 2018
	 */
	UsersDbObj selectByPrimaryKey(Integer usersId);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbggenerated  Wed Nov 14 23:10:41 EST 2018
	 */
	int updateByExampleSelective(@Param("record") UsersDbObj record,
			@Param("example") UsersDbObjExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbggenerated  Wed Nov 14 23:10:41 EST 2018
	 */
	int updateByExample(@Param("record") UsersDbObj record,
			@Param("example") UsersDbObjExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbggenerated  Wed Nov 14 23:10:41 EST 2018
	 */
	int updateByPrimaryKeySelective(UsersDbObj record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbggenerated  Wed Nov 14 23:10:41 EST 2018
	 */
	int updateByPrimaryKey(UsersDbObj record);
	//custom
	void createSha2HashForUser(UsersDbObj record);
	List<String> getRoleNames(Integer usersId);
	String getDisplayName(Integer usersId);
	List<UsersDbObj> getUsersByConversation(Integer conversationId);
}