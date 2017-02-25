package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.ThreadSubscriptionDao;
import com.zfgc.dbobj.ThreadSubscriptionViewDbObj;
import com.zfgc.model.forum.PaginationBounds;
import com.zfgc.model.subscriptions.ThreadSubscription;

@Component
public class ThreadSubscriptionDataProvider extends AbstractDataProvider{
	
	@Autowired
	ThreadSubscriptionDao threadSubscriptionDao;
	
	public List<ThreadSubscription> getThreadSubscriptionsByUser(Integer userId, Integer pageNo, Integer itemsPerPage){
		PaginationBounds bounds = super.calculatePaginationBounds(pageNo, itemsPerPage);
		
		List<ThreadSubscriptionViewDbObj> dbObj = threadSubscriptionDao.getThreadSubscriptionsByUser(userId, bounds.getLowerBound(), bounds.getUpperBound());
		List<ThreadSubscription> results = new ArrayList<>();
		
		for(ThreadSubscriptionViewDbObj thread : dbObj){
			results.add(mapper.map(thread,ThreadSubscription.class));
		}
		
		return results;
	}
	
	public Integer totalSubscriptionThreads(Integer userId){
		return threadSubscriptionDao.totalSubscriptionThreads(userId);
	}
	
	public void deleteThreadSubscriptions(List<ThreadSubscription> delete){
		threadSubscriptionDao.deleteThreadSubscriptions(delete);
	}
	
}