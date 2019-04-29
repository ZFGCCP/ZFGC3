package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.zfgc.dao.MemberGroupPermsDao;
import com.zfgc.dao.PermissionsDao;
import com.zfgc.dbobj.MemberGroupPermsDbObj;
import com.zfgc.dbobj.MemberGroupPermsDbObjExample;
import com.zfgc.dbobj.PermissionsDbObj;
import com.zfgc.dbobj.PermissionsDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.users.Permissions;

@Component
public class PermissionsDataProvider extends AbstractDataProvider {
	@Autowired
	PermissionsDao permissionsDao;
	
	@Autowired
	MemberGroupPermsDao memberGroupPermsDao;
	
	public Permissions getPermissionById(Integer permissionsId){
		PermissionsDbObjExample ex = permissionsDao.getExample();
		ex.createCriteria().andPermissionsIdEqualTo(permissionsId);
		
		List<PermissionsDbObj> permissions = permissionsDao.get(ex);
		
		if(permissions.size() > 0){
			return mapper.map(permissions.get(0), Permissions.class);
		}
		
		throw new ZfgcNotFoundException();
	}
	
	public List<Permissions> getPermissionsByGroup(Integer ... memberGroupId){
		List<Permissions> result = new ArrayList<>();
		MemberGroupPermsDbObjExample ex = memberGroupPermsDao.getExample();
		ex.createCriteria().andMemberGroupIdIn(Arrays.asList(memberGroupId));
		
		List<MemberGroupPermsDbObj> dbObj = memberGroupPermsDao.get(ex);
		
		for(MemberGroupPermsDbObj db : dbObj){
			Permissions perm = mapper.map(db, Permissions.class);
			result.add(perm);
		}
		
		return result;
	}
}