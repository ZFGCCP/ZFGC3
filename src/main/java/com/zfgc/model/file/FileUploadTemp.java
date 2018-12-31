package com.zfgc.model.file;

import com.zfgc.model.BaseZfgcModel;

public class FileUploadTemp extends BaseZfgcModel{

	private String fileName;
	private Integer usersId;
	
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
