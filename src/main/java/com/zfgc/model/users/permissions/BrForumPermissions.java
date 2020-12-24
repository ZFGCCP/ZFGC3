package com.zfgc.model.users.permissions;

import com.zfgc.model.BaseZfgcModel;

public class BrForumPermissions extends BaseZfgcModel{
	private Integer brThreadPermissionsId;
    private Short forumId;
    private Integer permissionsId;
    private Boolean readOnlyFlag;
	public Integer getBrThreadPermissionsId() {
		return brThreadPermissionsId;
	}
	public void setBrThreadPermissionsId(Integer brThreadPermissionsId) {
		this.brThreadPermissionsId = brThreadPermissionsId;
	}
	public Short getForumId() {
		return forumId;
	}
	public void setForumId(Short forumId) {
		this.forumId = forumId;
	}
	public Integer getPermissionsId() {
		return permissionsId;
	}
	public void setPermissionsId(Integer permissionsId) {
		this.permissionsId = permissionsId;
	}
	public Boolean getReadOnlyFlag() {
		return readOnlyFlag;
	}
	public void setReadOnlyFlag(Boolean readOnlyFlag) {
		this.readOnlyFlag = readOnlyFlag;
	}
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
