package com.zfgc.services.subscription;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.ThreadSubscriptionDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.subscriptions.ThreadSubscription;
import com.zfgc.model.subscriptions.ThreadSubscriptionWrapper;
import com.zfgc.model.users.Users;
import com.zfgc.services.AbstractService;

@Component
public class SubscriptionService extends AbstractService{
	
	@Autowired
	ThreadSubscriptionDataProvider threadSubscriptionDataProvider;
	
	public ThreadSubscriptionWrapper getThreadSubscriptions(Integer user, Integer pageNo, Integer itemsPerPage, Users loggedInUser) throws ZfgcNotFoundException{
		/*if(!user.equals(loggedInUser.getUsersId())){
			throw new ZfgcNotFoundException("Thread subscriptions");
		}*/
		
		ThreadSubscriptionWrapper wrapper = new ThreadSubscriptionWrapper();
		
		wrapper.setThreadSubscriptions(threadSubscriptionDataProvider.getThreadSubscriptionsByUser(user, pageNo, itemsPerPage));
		
		Integer numberOfItems = totalSubscriptionThreads(user, loggedInUser);
		Double numberOfPagesDec = (double)numberOfItems / itemsPerPage;
		Integer numberOfPages = (int)Math.ceil(numberOfPagesDec);
		wrapper.setNumberOfPages(numberOfPages);
		wrapper.setTotalItems(numberOfItems);
		
		return wrapper;
	}
	
	public Integer totalSubscriptionThreads(Integer user, Users loggedInUser){
		return threadSubscriptionDataProvider.totalSubscriptionThreads(user);
	}
	
	public void deleteThreadSubscriptions(List<ThreadSubscription> existingSubs, Integer userId, Users user) throws ZfgcNotFoundException{
		if(!userId.equals(user.getUsersId())){
			throw new ZfgcNotFoundException("Thread subscriptions");
		}
		
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
