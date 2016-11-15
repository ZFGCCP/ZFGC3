package com.zfgc.dbobj;

import java.util.Date;

public class ActivityLogDbObj {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACTIVITY_LOG.ACTIVITY_LOG_ID
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    private Long activityLogId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACTIVITY_LOG.LOG_TYPE_ID
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    private Integer logTypeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACTIVITY_LOG.DESCRIPTION
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACTIVITY_LOG.LOG_DATE
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    private Date logDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACTIVITY_LOG.USERS_ID
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    private Integer usersId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ACTIVITY_LOG.IP_ADDRESS
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    private String ipAddress;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACTIVITY_LOG.ACTIVITY_LOG_ID
     *
     * @return the value of ACTIVITY_LOG.ACTIVITY_LOG_ID
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    public Long getActivityLogId() {
        return activityLogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACTIVITY_LOG.ACTIVITY_LOG_ID
     *
     * @param activityLogId the value for ACTIVITY_LOG.ACTIVITY_LOG_ID
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    public void setActivityLogId(Long activityLogId) {
        this.activityLogId = activityLogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACTIVITY_LOG.LOG_TYPE_ID
     *
     * @return the value of ACTIVITY_LOG.LOG_TYPE_ID
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    public Integer getLogTypeId() {
        return logTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACTIVITY_LOG.LOG_TYPE_ID
     *
     * @param logTypeId the value for ACTIVITY_LOG.LOG_TYPE_ID
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    public void setLogTypeId(Integer logTypeId) {
        this.logTypeId = logTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACTIVITY_LOG.DESCRIPTION
     *
     * @return the value of ACTIVITY_LOG.DESCRIPTION
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACTIVITY_LOG.DESCRIPTION
     *
     * @param description the value for ACTIVITY_LOG.DESCRIPTION
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACTIVITY_LOG.LOG_DATE
     *
     * @return the value of ACTIVITY_LOG.LOG_DATE
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    public Date getLogDate() {
        return logDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACTIVITY_LOG.LOG_DATE
     *
     * @param logDate the value for ACTIVITY_LOG.LOG_DATE
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACTIVITY_LOG.USERS_ID
     *
     * @return the value of ACTIVITY_LOG.USERS_ID
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    public Integer getUsersId() {
        return usersId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACTIVITY_LOG.USERS_ID
     *
     * @param usersId the value for ACTIVITY_LOG.USERS_ID
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACTIVITY_LOG.IP_ADDRESS
     *
     * @return the value of ACTIVITY_LOG.IP_ADDRESS
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACTIVITY_LOG.IP_ADDRESS
     *
     * @param ipAddress the value for ACTIVITY_LOG.IP_ADDRESS
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}