package com.zfgc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.ThreadSubscriptionViewDbObj;
import com.zfgc.dbobj.ThreadSubscriptionViewDbObjExample;
import com.zfgc.mappers.ThreadSubscriptionViewDbObjMapper;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.subscriptions.ThreadSubscription;

@Component
public class ThreadSubscriptionDao extends AbstractDao{

	@Autowired
	ThreadSubscriptionViewDbObjMapper threadSubscriptionViewDbObjMapper;
	
	public List<ThreadSubscriptionViewDbObj> getThreadSubscriptionsByUser(Integer userId){
		List<ThreadSubscriptionViewDbObj> dbObj = null;
		
		ThreadSubscriptionViewDbObjExample ex = new ThreadSubscriptionViewDbObjExample();
		ex.createCriteria().andThreadStarterIdEqualTo(userId);
		
		dbObj = threadSubscriptionViewDbObjMapper.selectByExample(ex);
		
		return dbObj;
	}
	
	public void deleteThreadSubscriptions(List<ThreadSubscription> subsToRemove){
		ThreadSubscriptionViewDbObjExample ex = new ThreadSubscriptionViewDbObjExample();
		
		List<Integer> userIds = new ArrayList<>();
		List<Integer> threadIds = new ArrayList<>();
		
		for(ThreadSubscription thread : subsToRemove){
			userIds.add(thread.getThreadStarterId());
			threadIds.add(thread.getThreadId());
		}
		
		ex.createCriteria().andThreadIdIn(threadIds);
		ex.createCriteria().andThreadStarterIdIn(userIds);
		
		threadSubscriptionViewDbObjMapper.deleteByExample(ex);
	}
	
	@Override
	public Boolean validateIntegrity(BaseZfgcModel model) {
		// TODO Auto-generated method stub
		return null;
	}

}
