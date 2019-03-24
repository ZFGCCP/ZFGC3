package com.zfgc.dataprovider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.LkupMemberGroupDao;
import com.zfgc.dbobj.LkupMemberGroupDbObj;
import com.zfgc.dbobj.LkupMemberGroupDbObjExample;
import com.zfgc.model.lkup.LkupMemberGroup;

@Component
public class LkupMemberGroupDataProvider extends AbstractDataProvider{
	@Autowired
	LkupMemberGroupDao lkupMemberGroupDao;
	
	public LkupMemberGroup getMemberGroup(Integer lkupMemberGroupId) throws RuntimeException {
		LkupMemberGroupDbObjExample ex = lkupMemberGroupDao.getExample();
		ex.createCriteria().andMemberGroupIdEqualTo(lkupMemberGroupId);
		
		List<LkupMemberGroupDbObj> dbObj = lkupMemberGroupDao.get(ex);
		
		return mapper.map(dbObj.get(0), LkupMemberGroup.class);
	}
}