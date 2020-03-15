package com.zfgc.model.users;

import java.util.Date;

import com.zfgc.model.BaseZfgcModel;

public class UserCurrentAction extends BaseZfgcModel {
	private Integer userCurrentActionId = -1;
	private Integer usersId;
	private Integer locationId;
	private Date createdTs;
	private Date updatedTs;
	private Integer param;
	public Integer getUserCurrentActionId() {
		return userCurrentActionId;
	}
	public void setUserCurrentActionId(Integer userCurrentActionId) {
		this.userCurrentActionId = userCurrentActionId;
	}
	public Integer getUsersId() {
		return usersId;
	}
	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	public Date getCreatedTs() {
		return createdTs;
	}
	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}
	public Date getUpdatedTs() {
		return updatedTs;
	}
	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public Integer getParam() {
		return param;
	}
	public void setParam(Integer param) {
		this.param = param;
	}
}