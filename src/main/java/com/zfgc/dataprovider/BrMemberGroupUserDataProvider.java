package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.BrMemberGroupUserDao;
import com.zfgc.dbobj.BrMemberGroupUserDbObj;
import com.zfgc.dbobj.BrMemberGroupUserDbObjExample;
import com.zfgc.model.bridge.BrMemberGroupUser;

@Component
public class BrMemberGroupUserDataProvider extends AbstractDataProvider {
	
	@Autowired
	private BrMemberGroupUserDao brMemberGroupUserDao;
	
	public void deleteMemberGroupFromUser(BrMemberGroupUser memberGroupUser){
		BrMemberGroupUserDbObjExample ex = brMemberGroupUserDao.getExample();
		ex.createCriteria().andMemberGroupIdEqualTo(memberGroupUser.getMemberGroupId())
						   .andUsersIdEqualTo(memberGroupUser.getUsersId());
		
		brMemberGroupUserDao.deleteByExample(memberGroupUser, ex);
	}
	
	public void deleteMemberGroupFromUser(List<BrMemberGroupUser> memberGroupUser, Integer usersId){
		if(memberGroupUser.size() == 0){
			return;
		}
		List<Integer> groups = new ArrayList<>();
		for(BrMemberGroupUser group : memberGroupUser){
			groups.add(group.getMemberGroupId());
		}
		
		
		BrMemberGroupUserDbObjExample ex = brMemberGroupUserDao.getExample();
		ex.createCriteria().andMemberGroupIdIn(groups)
						   .andUsersIdEqualTo(usersId);
		
		brMemberGroupUserDao.deleteByExample(null, ex);
	}
	
	public void createMemberGroupUser(BrMemberGroupUser memberGroupUser){
		brMemberGroupUserDao.updateOrInsert(memberGroupUser);
	}
	
	public List<BrMemberGroupUser> getMemberGroupUsers(Integer usersId){
		BrMemberGroupUserDbObjExample ex = brMemberGroupUserDao.getExample();
		ex.createCriteria().andUsersIdEqualTo(usersId);
		
		List<BrMemberGroupUserDbObj> dbObj = brMemberGroupUserDao.get(ex);
		List<BrMemberGroupUser> result = new ArrayList<>();
		
		for(BrMemberGroupUserDbObj db : dbObj){
			result.add(mapper.map(db,BrMemberGroupUser.class));
		}
		
		return result;
	}
}