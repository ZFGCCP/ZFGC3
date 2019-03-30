package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.BrPermissionsMemberGroupDao;
import com.zfgc.dbobj.BrPermissionsMemberGroupDbObjExample;
import com.zfgc.dbobj.BrPermissionsMemberGroupDbObjKey;
import com.zfgc.model.users.BrPermissionsMemberGroup;

@Component
public class BrPermissionsMemberGroupDataProvider extends AbstractDataProvider {
	
	@Autowired
	BrPermissionsMemberGroupDao brPermissionsMemberGroupDao;
	
	public List<BrPermissionsMemberGroup> getPermissionsMemberGroupMappingByGroup(Integer memberGroupId){
		BrPermissionsMemberGroupDbObjExample ex = brPermissionsMemberGroupDao.getExample();
		ex.createCriteria().andMemberGroupIdEqualTo(memberGroupId);
		
		
		List<BrPermissionsMemberGroupDbObjKey> dbObj = brPermissionsMemberGroupDao.get(ex);
		List<BrPermissionsMemberGroup> result = new ArrayList<>();
		
		for(BrPermissionsMemberGroupDbObjKey key : dbObj){
			result.add(mapper.map(dbObj,BrPermissionsMemberGroup.class));
		}
		
		return result;
	}
}
