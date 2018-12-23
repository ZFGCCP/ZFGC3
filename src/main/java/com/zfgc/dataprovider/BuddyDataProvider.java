package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.BuddyDao;
import com.zfgc.dao.UsersDao;
import com.zfgc.dbobj.UsersDbObj;
import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.Buddy;

@Component
public class BuddyDataProvider extends AbstractDataProvider{
	
	@Autowired 
	BuddyDao buddyDao;
	
	@Autowired
	UsersDao usersDao;
	
	public List<Buddy> getBuddiesByUserId(Integer usersId) throws Exception{
		List<Buddy> results = new ArrayList<>();
		List<Integer> buddyIds = buddyDao.getBuddyIds(usersId);
		
		if(buddyIds.size() > 0){
			List<UsersDbObj> users = usersDao.getUsersById(buddyIds);
			
			for(UsersDbObj dbObj : users){
				Buddy buddy = mapper.map(dbObj, Buddy.class);
				buddy.setUserBId(dbObj.getUsersId());
				buddy.setUserAId(usersId);
				buddy.setOnlineFlag(true);
				buddy.setUserName(dbObj.getDisplayName());
				buddy.setUser(mapper.map(dbObj, Users.class));
				results.add(buddy);
			}
		}
		
		return results;
	}
	
	public List<Buddy> getIgnoresByUserId(Integer usersId) throws Exception{
		List<Buddy> results = new ArrayList<>();
		List<Integer> buddyIds = buddyDao.getIgnoreIds(usersId);
		
		if(buddyIds.size() > 0){
			List<UsersDbObj> users = usersDao.getUsersById(buddyIds);
			
			for(UsersDbObj dbObj : users){
				Buddy buddy = mapper.map(dbObj, Buddy.class);
				buddy.setUserBId(dbObj.getUsersId());
				buddy.setUserAId(usersId);
				buddy.setOnlineFlag(true);
				buddy.setUserName(dbObj.getDisplayName());
				
				results.add(buddy);
			}
		}
		
		return results;
	}
	
	public void deleteBuddy(Buddy buddy){
		buddyDao.hardDelete(buddy);
	}
	
	public void insertOrUpdateBuddy(Buddy buddy){
		buddyDao.updateOrInsert(buddy);
	}
	
}