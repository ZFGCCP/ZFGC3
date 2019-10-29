package com.zfgc.dataprovider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.UserPermissionViewDao;
import com.zfgc.dbobj.UserPermissionViewDbObj;
import com.zfgc.dbobj.UserPermissionViewDbObjExample;
import com.zfgc.model.users.Permissions;
import com.zfgc.model.users.UserPermissionView;

@Component
public class UserPermissionViewDataProvider extends AbstractDataProvider {
	
	@Autowired
	UserPermissionViewDao userPermissionViewDao;
	
	public UserPermissionView getUserPermissions(Integer usersId) {
		UserPermissionView perms = new UserPermissionView();
		UserPermissionViewDbObjExample ex = userPermissionViewDao.getExample();
		ex.createCriteria().andUsersIdEqualTo(usersId);
		
		List<UserPermissionViewDbObj> dbObj = userPermissionViewDao.get(ex);
		
		for(UserPermissionViewDbObj db : dbObj) {
			perms.getPermissions().add(mapper.map(db, Permissions.class));
		}
		
		perms.setUsersId(usersId);
		return perms;
	}
	
}