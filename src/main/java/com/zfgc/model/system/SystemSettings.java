package com.zfgc.model.system;

import java.util.Date;

import com.zfgc.model.BaseZfgcModel;

public class SystemSettings extends BaseZfgcModel {

	private Integer systemSettingId;
	private String value;
	private String code;
	private Date createdTs;
	private Date updatedTs;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public Integer getSystemSettingId() {
		return systemSettingId;
	}

	public void setSystemSettingId(Integer systemSettingId) {
		this.systemSettingId = systemSettingId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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

}
