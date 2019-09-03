package com.zfgc.model.users;

import com.zfgc.model.BaseZfgcModel;

public class Hostname extends BaseZfgcModel{

	private Integer hostnameId;
	private String hostname;
	
	public Integer getHostnameId() {
		return hostnameId;
	}

	public void setHostnameId(Integer hostnameId) {
		this.hostnameId = hostnameId;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}