package com.zfgc.services.buddies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.dataprovider.BuddyDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.Buddy;
import com.zfgc.services.AbstractService;
import com.zfgc.services.RuleRunService;
import com.zfgc.validation.uservalidation.BuddyListValidator;


@Component
public class BuddyService extends AbstractService {
	@Autowired
	BuddyDataProvider buddyDataProvider;
	
	@Autowired
	BuddyListValidator buddyListValidator;
	
	@Autowired
	RuleRunService<Buddy> ruleRunner;
	
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
	
	@Transactional
	public void saveBuddies(Integer userId, List<Buddy> buddies, Users zfgcUser) throws RuntimeException, Exception{
		List<Buddy> savedBuddies = getBuddies(userId);
		
		for(Buddy buddy : buddies){
			ruleRunner.runRules(buddyListValidator, null, null, buddy, zfgcUser);
			buddyDataProvider.insertOrUpdateBuddy(buddy);
		}
	}
	
	public Buddy getBuddyTemplate(Integer usersA, Integer usersB, Users zfgcUser) throws RuntimeException, Exception{
		Buddy buddy = buddyDataProvider.getBuddyTemplate(usersA, usersB);
		ruleRunner.runRules(buddyListValidator, null, null, buddy, zfgcUser);
		
		return buddy;
	}
}
