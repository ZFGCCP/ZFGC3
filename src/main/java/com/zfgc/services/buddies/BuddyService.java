package com.zfgc.services.buddies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.BuddyDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.users.profile.Buddy;
import com.zfgc.services.AbstractService;


@Component
public class BuddyService extends AbstractService {
	@Autowired
	BuddyDataProvider buddyDataProvider;
	
	public List<Buddy> getBuddies(Integer userId){
		try {
			List<Buddy> result = buddyDataProvider.getBuddiesByUserId(userId);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Buddy> getIgnores(Integer userId){
		try {
			List<Buddy> result = buddyDataProvider.getIgnoresByUserId(userId);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void deleteBuddies(Integer usersId){
		buddyDataProvider.deletBuddiesByUser(usersId);
	}
	
	public void saveBuddies(Integer userId, List<Buddy> buddies){
		for(Buddy buddy : buddies){
			buddyDataProvider.insertOrUpdateBuddy(buddy);
		}
	}
	
	public Buddy getBuddyTemplate(Integer usersA, Integer usersB){
		return buddyDataProvider.getBuddyTemplate(usersA, usersB);
	}
}
