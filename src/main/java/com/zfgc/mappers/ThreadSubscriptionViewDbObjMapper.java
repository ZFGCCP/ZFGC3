package com.zfgc.mappers;

import com.zfgc.dbobj.ThreadSubscriptionViewDbObj;
import com.zfgc.dbobj.ThreadSubscriptionViewDbObjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThreadSubscriptionViewDbObjMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
	 */
	int countByExample(ThreadSubscriptionViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
	 */
	int deleteByExample(ThreadSubscriptionViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
	 */
	int insert(ThreadSubscriptionViewDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
	 */
	int insertSelective(ThreadSubscriptionViewDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
	 */
	List<ThreadSubscriptionViewDbObj> selectByExample(
			ThreadSubscriptionViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
	 */
	int updateByExampleSelective(
			@Param("record") ThreadSubscriptionViewDbObj record,
			@Param("example") ThreadSubscriptionViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
	 */
	int updateByExample(@Param("record") ThreadSubscriptionViewDbObj record,
			@Param("example") ThreadSubscriptionViewDbObjExample example);

	//custom
    List<ThreadSubscriptionViewDbObj> getThreadSubs(@Param("userId")Integer userId, @Param("lowerBound")Integer lowerBound, @Param("upperBound")Integer upperBound);
}