package com.zfgc.model.users.profile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.util.time.ZfgcTimeUtils;

public class Buddy extends BaseZfgcModel {

	private Integer userId;
	private String userName;
	private Date lastOnlineDt;
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Boolean getOnlineFlag() {
		return onlineFlag;
	}

	public void setOnlineFlag(Boolean onlineFlag) {
		this.onlineFlag = onlineFlag;
	}

	private Boolean onlineFlag;
	
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getLastOnlineDt() {
		return lastOnlineDt;
	}

	public void setLastOnlineDt(Date lastOnlineDt) {
		this.lastOnlineDt = lastOnlineDt;
	}
	
	public String getLastOnlineDtAsString(){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateTimeFormat();
		
		if(lastOnlineDt == null){
			return "";
		}
		
		return sdf.format(lastOnlineDt);
	}
	
	public void setLastOnlineDtAsString(String lastOnlineDtAsString){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateTimeFormat();
		
		try {
			lastOnlineDt = sdf.parse(lastOnlineDtAsString);
		} catch (ParseException e) {
			lastOnlineDt = null;
		}
		
	}

}
