package com.zfgc.dbobj;

import java.util.Date;

public class UserCurrentActionDbObj {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column USER_CURRENT_ACTION.USER_CURRENT_ACTION_ID
	 * @mbg.generated  Mon Jan 20 16:14:40 EST 2020
	 */
	private Integer userCurrentActionId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column USER_CURRENT_ACTION.USERS_ID
	 * @mbg.generated  Mon Jan 20 16:14:40 EST 2020
	 */
	private Integer usersId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column USER_CURRENT_ACTION.LOCATION_ID
	 * @mbg.generated  Mon Jan 20 16:14:40 EST 2020
	 */
	private Integer locationId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column USER_CURRENT_ACTION.CREATED_TS
	 * @mbg.generated  Mon Jan 20 16:14:40 EST 2020
	 */
	private Date createdTs;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column USER_CURRENT_ACTION.UPDATED_TS
	 * @mbg.generated  Mon Jan 20 16:14:40 EST 2020
	 */
	private Date updatedTs;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column USER_CURRENT_ACTION.USER_CURRENT_ACTION_ID
	 * @return  the value of USER_CURRENT_ACTION.USER_CURRENT_ACTION_ID
	 * @mbg.generated  Mon Jan 20 16:14:40 EST 2020
	 */
	public Integer getUserCurrentActionId() {
		return userCurrentActionId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column USER_CURRENT_ACTION.USER_CURRENT_ACTION_ID
	 * @param userCurrentActionId  the value for USER_CURRENT_ACTION.USER_CURRENT_ACTION_ID
	 * @mbg.generated  Mon Jan 20 16:14:40 EST 2020
	 */
	public void setUserCurrentActionId(Integer userCurrentActionId) {
		this.userCurrentActionId = userCurrentActionId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column USER_CURRENT_ACTION.USERS_ID
	 * @return  the value of USER_CURRENT_ACTION.USERS_ID
	 * @mbg.generated  Mon Jan 20 16:14:40 EST 2020
	 */
	public Integer getUsersId() {
		return usersId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column USER_CURRENT_ACTION.USERS_ID
	 * @param usersId  the value for USER_CURRENT_ACTION.USERS_ID
	 * @mbg.generated  Mon Jan 20 16:14:40 EST 2020
	 */
	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column USER_CURRENT_ACTION.LOCATION_ID
	 * @return  the value of USER_CURRENT_ACTION.LOCATION_ID
	 * @mbg.generated  Mon Jan 20 16:14:40 EST 2020
	 */
	public Integer getLocationId() {
		return locationId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column USER_CURRENT_ACTION.LOCATION_ID
	 * @param locationId  the value for USER_CURRENT_ACTION.LOCATION_ID
	 * @mbg.generated  Mon Jan 20 16:14:40 EST 2020
	 */
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column USER_CURRENT_ACTION.CREATED_TS
	 * @return  the value of USER_CURRENT_ACTION.CREATED_TS
	 * @mbg.generated  Mon Jan 20 16:14:40 EST 2020
	 */
	public Date getCreatedTs() {
		return createdTs;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column USER_CURRENT_ACTION.CREATED_TS
	 * @param createdTs  the value for USER_CURRENT_ACTION.CREATED_TS
	 * @mbg.generated  Mon Jan 20 16:14:40 EST 2020
	 */
	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column USER_CURRENT_ACTION.UPDATED_TS
	 * @return  the value of USER_CURRENT_ACTION.UPDATED_TS
	 * @mbg.generated  Mon Jan 20 16:14:40 EST 2020
	 */
	public Date getUpdatedTs() {
		return updatedTs;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column USER_CURRENT_ACTION.UPDATED_TS
	 * @param updatedTs  the value for USER_CURRENT_ACTION.UPDATED_TS
	 * @mbg.generated  Mon Jan 20 16:14:40 EST 2020
	 */
	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}
}