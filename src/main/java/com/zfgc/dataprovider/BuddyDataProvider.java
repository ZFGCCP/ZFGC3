package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.zfgc.model.users.profile.Buddy;

@Component
public class BuddyDataProvider extends AbstractDataProvider{
	
	public List<Buddy> getBuddiesByUserId(Integer usersId){
		List<Buddy> results = new ArrayList<>();
		
		return results;
	}
	
}