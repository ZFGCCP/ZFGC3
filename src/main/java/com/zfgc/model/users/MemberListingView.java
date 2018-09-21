package com.zfgc.model.users;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.util.time.ZfgcTimeUtils;

public class MemberListingView extends BaseZfgcModel {

	private Integer usersId;
    private String displayName;
    private String emailAddress;
    
    @JsonIgnore
    private Date lastLogin;
    
    @JsonIgnore
    private Date dateRegistered;
    private String groupName;
    
    public List<String> getMemberGroups() {
		return memberGroups;
	}

	public void setMemberGroups(List<String> memberGroups) {
		this.memberGroups = memberGroups;
	}

	private List<String> memberGroups = new ArrayList<>();
    
    @JsonIgnore
    private Short lkupTimezonesId;
    @JsonIgnore
    private String timeZone;
	
	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getDateRegistered() {
		return dateRegistered;
	}

	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Short getLkupTimezonesId() {
		return lkupTimezonesId;
	}

	public void setLkupTimezonesId(Short lkupTimezonesId) {
		this.lkupTimezonesId = lkupTimezonesId;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getDateRegisteredAsString(){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat();
		
		if(dateRegistered == null){
			return "";
		}
		
		return sdf.format(dateRegistered);
	}
	
	public String getLastLoginAsString(){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateTimeFormat(getUserTimeZone());
		
		if(lastLogin == null){
			return "";
		}
		
		return sdf.format(lastLogin);
	}

}
