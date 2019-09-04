package com.zfgc.model.logging;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zfgc.util.time.ZfgcTimeUtils;

public class ActivityLog {
	private Integer activityLogId;
	private Integer logTypeId;
	private String description;
	private Date logDate;
	private String ipAddress;
	private Integer usersId;
	public Integer getActivityLogId() {
		return activityLogId;
	}
	public void setActivityLogId(Integer activityLogId) {
		this.activityLogId = activityLogId;
	}
	public Integer getLogTypeId() {
		return logTypeId;
	}
	public void setLogTypeId(Integer logTypeId) {
		this.logTypeId = logTypeId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getLogDate() {
		return logDate;
	}
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Integer getUsersId() {
		return usersId;
	}
	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}
	public void setLogDateAsString(String logDateAsString){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat();
		
		try{
			logDate = sdf.parse(logDateAsString);
		}
		catch(ParseException ex){
			logDate = null;
		}
	}
	public String getLogDateAsString(){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat();
		
		if(logDate == null){
			return "";
		}
		
		return sdf.format(logDate);
	}
	
}
