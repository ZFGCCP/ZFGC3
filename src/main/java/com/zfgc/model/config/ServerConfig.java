package com.zfgc.model.config;

import com.zfgc.model.BaseZfgcModel;

public class ServerConfig extends BaseZfgcModel {
	private String idpEntityId;

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getIdpEntityId() {
		return idpEntityId;
	}

	public void setIdpEntityId(String idpEntityId) {
		this.idpEntityId = idpEntityId;
	}
}
