package com.zfgc.mappers;

import com.zfgc.dbobj.NotificationSettingsDbObj;
import com.zfgc.dbobj.NotificationSettingsDbObjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotificationSettingsDbObjMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	int countByExample(NotificationSettingsDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	int deleteByExample(NotificationSettingsDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	int deleteByPrimaryKey(Integer notificationSettingsId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	int insert(NotificationSettingsDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	int insertSelective(NotificationSettingsDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	List<NotificationSettingsDbObj> selectByExample(
			NotificationSettingsDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	NotificationSettingsDbObj selectByPrimaryKey(Integer notificationSettingsId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	int updateByExampleSelective(
			@Param("record") NotificationSettingsDbObj record,
			@Param("example") NotificationSettingsDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	int updateByExample(@Param("record") NotificationSettingsDbObj record,
			@Param("example") NotificationSettingsDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	int updateByPrimaryKeySelective(NotificationSettingsDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	int updateByPrimaryKey(NotificationSettingsDbObj record);
}