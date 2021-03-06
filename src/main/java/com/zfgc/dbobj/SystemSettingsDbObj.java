package com.zfgc.dbobj;

import java.util.Date;

public class SystemSettingsDbObj {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SYSTEM_SETTINGS.SYSTEM_SETTING_ID
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	private Integer systemSettingId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SYSTEM_SETTINGS.VALUE
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	private String value;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SYSTEM_SETTINGS.CODE
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	private String code;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SYSTEM_SETTINGS.CREATED_TS
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	private Date createdTs;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SYSTEM_SETTINGS.UPDATED_TS
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	private Date updatedTs;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SYSTEM_SETTINGS.SYSTEM_SETTING_ID
	 * @return  the value of SYSTEM_SETTINGS.SYSTEM_SETTING_ID
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	public Integer getSystemSettingId() {
		return systemSettingId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SYSTEM_SETTINGS.SYSTEM_SETTING_ID
	 * @param systemSettingId  the value for SYSTEM_SETTINGS.SYSTEM_SETTING_ID
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	public void setSystemSettingId(Integer systemSettingId) {
		this.systemSettingId = systemSettingId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SYSTEM_SETTINGS.VALUE
	 * @return  the value of SYSTEM_SETTINGS.VALUE
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	public String getValue() {
		return value;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SYSTEM_SETTINGS.VALUE
	 * @param value  the value for SYSTEM_SETTINGS.VALUE
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SYSTEM_SETTINGS.CODE
	 * @return  the value of SYSTEM_SETTINGS.CODE
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	public String getCode() {
		return code;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SYSTEM_SETTINGS.CODE
	 * @param code  the value for SYSTEM_SETTINGS.CODE
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SYSTEM_SETTINGS.CREATED_TS
	 * @return  the value of SYSTEM_SETTINGS.CREATED_TS
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	public Date getCreatedTs() {
		return createdTs;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SYSTEM_SETTINGS.CREATED_TS
	 * @param createdTs  the value for SYSTEM_SETTINGS.CREATED_TS
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SYSTEM_SETTINGS.UPDATED_TS
	 * @return  the value of SYSTEM_SETTINGS.UPDATED_TS
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	public Date getUpdatedTs() {
		return updatedTs;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SYSTEM_SETTINGS.UPDATED_TS
	 * @param updatedTs  the value for SYSTEM_SETTINGS.UPDATED_TS
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}
}