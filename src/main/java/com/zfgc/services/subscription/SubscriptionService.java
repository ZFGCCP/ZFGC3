package com.zfgc.services.subscription;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.ThreadSubscriptionDataProvider;
import com.zfgc.model.subscriptions.ThreadSubscription;
import com.zfgc.model.users.Users;
import com.zfgc.services.AbstractService;

@Component
public class SubscriptionService extends AbstractService{
	
	@Autowired
	ThreadSubscriptionDataProvider threadSubscriptionDataProvider;
	
	public List<ThreadSubscription> getThreadSubscriptions(Integer user, Users loggedInUser){
		return threadSubscriptionDataProvider.getThreadSubscriptionsByUser(user);
	}
	
	public void deleteThreadSubscriptions(List<ThreadSubscription> existingSubs, Integer userId, Users user){
		List<ThreadSubscription> subsFromDb = getThreadSubscriptions(userId, user);
		List<ThreadSubscription> subsToDelete = new ArrayList<>();
		
		for(ThreadSubscription sub : subsFromDb){
			if(!existingSubs.contains(sub)){
				subsToDelete.add(sub);
			}
		}
		
		threadSubscriptionDataProvider.deleteThreadSubscriptions(subsToDelete);
	}
}
