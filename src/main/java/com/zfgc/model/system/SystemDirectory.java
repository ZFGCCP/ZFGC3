package com.zfgc.model.system;

import com.zfgc.model.BaseZfgcModel;

public class SystemDirectory extends BaseZfgcModel{

	 private Integer systemDirectoryId;
	 private String systemDirectoryCode;
	 private String systemDirectoryDesc;
	 private String systemPath;
	
	public Integer getSystemDirectoryId() {
		return systemDirectoryId;
	}

	public void setSystemDirectoryId(Integer systemDirectoryId) {
		this.systemDirectoryId = systemDirectoryId;
	}

	public String getSystemDirectoryCode() {
		return systemDirectoryCode;
	}

	public void setSystemDirectoryCode(String systemDirectoryCode) {
		this.systemDirectoryCode = systemDirectoryCode;
	}

	public String getSystemDirectoryDesc() {
		return systemDirectoryDesc;
	}

	public void setSystemDirectoryDesc(String systemDirectoryDesc) {
		this.systemDirectoryDesc = systemDirectoryDesc;
	}

	public String getSystemPath() {
		return systemPath;
	}

	public void setSystemPath(String systemPath) {
		this.systemPath = systemPath;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}