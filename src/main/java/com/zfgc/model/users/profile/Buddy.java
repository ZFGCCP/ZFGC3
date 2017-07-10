package com.zfgc.model.users.profile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.util.time.ZfgcTimeUtils;

public class Buddy extends BaseZfgcModel {

	private Integer userBId;
	private Integer userAId;
	private String userName;
	private Date lastLogin;
	private Boolean buddyFlag;
	private Boolean ignoreFlag;
	private Boolean add = false;

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
	
	public String getLastOnlineDtAsString(){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateTimeFormat();
		
		if(lastLogin == null){
			return "";
		}
		
		return sdf.format(lastLogin);
	}
	
	public void setLastOnlineDtAsString(String lastOnlineDtAsString){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateTimeFormat();
		
		try {
			lastLogin = sdf.parse(lastOnlineDtAsString);
		} catch (ParseException e) {
			lastLogin = null;
		}
		
	}

	public Boolean getAdd() {
		return add;
	}

	public void setAdd(Boolean add) {
		this.add = add;
	}

	public Integer getUserAId() {
		return userAId;
	}

	public void setUserAId(Integer userAId) {
		this.userAId = userAId;
	}

	public Integer getUserBId() {
		return userBId;
	}

	public void setUserBId(Integer userBId) {
		this.userBId = userBId;
	}

	public Boolean getIgnoreFlag() {
		return ignoreFlag;
	}

	public void setIgnoreFlag(Boolean ignoreFlag) {
		this.ignoreFlag = ignoreFlag;
	}

	public Boolean getBuddyFlag() {
		return buddyFlag;
	}

	public void setBuddyFlag(Boolean buddyFlag) {
		this.buddyFlag = buddyFlag;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

}
