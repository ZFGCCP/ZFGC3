package com.zfgc.model.users;

import com.zfgc.model.BaseZfgcModel;

public class Permissions extends BaseZfgcModel{
	private Integer permissionsId;
    private String permissionsCode;
    private String permissionsDesc;
	
	public Integer getPermissionsId() {
		return permissionsId;
	}

	public void setPermissionsId(Integer permissionsId) {
		this.permissionsId = permissionsId;
	}

	public String getPermissionsCode() {
		return permissionsCode;
	}

	public void setPermissionsCode(String permissionsCode) {
		this.permissionsCode = permissionsCode;
	}

	public String getPermissionsDesc() {
		return permissionsDesc;
	}

	public void setPermissionsDesc(String permissionsDesc) {
		this.permissionsDesc = permissionsDesc;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
    public boolean equals(Object obj) {
		return ((String)obj).equals(permissionsCode);
		
	}
	
}