package com.zfgc.services.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.PermissionsDataProvider;
import com.zfgc.model.users.Permissions;
import com.zfgc.services.AbstractService;

@Component
public class PermissionsService extends AbstractService{
	
	@Autowired
	PermissionsDataProvider permissionsDataProvider;
	
	public Permissions getPermissionById(Integer permissionsId){
		Permissions result = permissionsDataProvider.getPermissionById(permissionsId);
		
		return result;
	}
	
	public List<Permissions> getPermissionsByMemberGroup(Integer ... memberGroupId){
		return permissionsDataProvider.getPermissionsByGroup(memberGroupId);
	}
	
}