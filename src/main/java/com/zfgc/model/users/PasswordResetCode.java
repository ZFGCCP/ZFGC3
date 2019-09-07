package com.zfgc.model.users;

import java.util.Date;

import com.zfgc.model.BaseZfgcModel;

public class PasswordResetCode extends BaseZfgcModel {

	private Integer passwordResetCodeId;
	private Integer usersId;
	private String code;
	private Date expirationTs;
	
	public Integer getPasswordResetCodeId() {
		return passwordResetCodeId;
	}

	public void setPasswordResetCodeId(Integer passwordResetCodeId) {
		this.passwordResetCodeId = passwordResetCodeId;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getExpirationTs() {
		return expirationTs;
	}

	public void setExpirationTs(Date expirationTs) {
		this.expirationTs = expirationTs;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}