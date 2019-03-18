package com.zfgc.model.bridge;

import java.util.List;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.lkup.LkupMemberGroup;

public class BrMemberGroupUser extends BaseZfgcModel {

   private Integer usersId;
   private Integer memberGroupId;
	
	public Integer getUsersId() {
		return usersId;
	}
	
	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}
	
	public Integer getMemberGroupId() {
		return memberGroupId;
	}
	
	public void setMemberGroupId(Integer memberGroupId) {
		this.memberGroupId = memberGroupId;
	}
	
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
