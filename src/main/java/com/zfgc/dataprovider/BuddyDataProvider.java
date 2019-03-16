package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.BuddyDao;
import com.zfgc.dao.UserProfileDao;
import com.zfgc.dao.UsersDao;
import com.zfgc.dbobj.BrBuddyIgnoreListDbObjExample;
import com.zfgc.dbobj.UserProfileViewDbObj;
import com.zfgc.dbobj.UserProfileViewDbObjExample;
import com.zfgc.dbobj.UsersDbObj;
import com.zfgc.model.avatar.Avatar;
import com.zfgc.model.users.EmailAddress;
import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.Buddy;
import com.zfgc.model.users.profile.UserProfileView;

@Component
public class BuddyDataProvider extends AbstractDataProvider{
	
	@Autowired 
	BuddyDao buddyDao;
	
	@Autowired
	UsersDao usersDao;
	
	@Autowired
	UserProfileDao userProfileDao;
	
	public List<Buddy> getBuddiesByUserId(Integer usersId) throws Exception{
		List<Buddy> results = new ArrayList<>();
		List<Integer> buddyIds = buddyDao.getBuddyIds(usersId);
		
		if(buddyIds.size() > 0){
			UserProfileViewDbObjExample ex = userProfileDao.getExample();
			ex.createCriteria().andUsersIdIn(buddyIds);
			List<UserProfileViewDbObj> users = userProfileDao.get(ex);
			
			for(UserProfileViewDbObj dbObj : users){
				Buddy buddy = new Buddy();
				buddy.setUserBId(dbObj.getUsersId());
				buddy.setUserAId(usersId);
				buddy.setUserName(dbObj.getDisplayName());
				buddy.setUser(mapper.map(dbObj, UserProfileView.class));
				buddy.setBuddyFlag(true);
				buddy.setIgnoreFlag(false);
				buddy.getUser().setBuddyList(null);
				
				buddy.getUser().getPersonalInfo().setAvatar(mapper.map(dbObj, Avatar.class));
				buddy.getUser().getUserContactInfo().setEmail(mapper.map(dbObj, EmailAddress.class));
				
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
	
	public void deletBuddiesByUser(Integer usersId){
		BrBuddyIgnoreListDbObjExample ex = buddyDao.getExample();
		ex.createCriteria().andUserAIdEqualTo(usersId).andBuddyFlagEqualTo(true);
		
		buddyDao.deleteByExample(null, ex);
	}
	
	public void deleteBuddy(Buddy buddy){
		buddyDao.hardDelete(buddy);
	}
	
	public void insertOrUpdateBuddy(Buddy buddy){
		buddyDao.updateOrInsert(buddy);
	}
	
	public Buddy getBuddyTemplate(Integer usersA, Integer usersB) throws Exception{
		Buddy buddy = new Buddy();
		buddy.setBuddyFlag(true);
		buddy.setIgnoreFlag(false);
		buddy.setUserAId(usersA);
		buddy.setUserBId(usersB);
		
		UserProfileViewDbObjExample ex = userProfileDao.getExample();
		ex.createCriteria().andUsersIdEqualTo(usersB);
		List<UserProfileViewDbObj> user = userProfileDao.get(ex);
		
		buddy.setUser(mapper.map(user,UserProfileView.class));
		buddy.getUser().getPersonalInfo().setAvatar(mapper.map(user.get(0), Avatar.class));
		buddy.getUser().getUserContactInfo().setEmail(mapper.map(user.get(0), EmailAddress.class));
		
		buddy.setUserName(user.get(0).getDisplayName());
		
		return buddy;
	}
	
}