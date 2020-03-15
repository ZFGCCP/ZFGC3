package com.zfgc.model.users;

import com.zfgc.model.BaseZfgcModel;

public class UserAction extends BaseZfgcModel {
	
	private Integer usersId;
	private Integer currentActionId;
	private Integer param;
	
	public Integer getUsersId() {
		return usersId;
	}
	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}
	public Integer getCurrentActionId() {
		return currentActionId;
	}
	public void setCurrentActionId(Integer currentActionId) {
		this.currentActionId = currentActionId;
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
