package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.ThreadDao;
import com.zfgc.dbobj.ThreadDbObj;
import com.zfgc.model.forum.Topic;
import com.zfgc.model.users.Users;

@Component
public class ThreadDataProvider extends AbstractDataProvider {
	@Autowired
	ThreadDao threadDao;
	
	public Integer getNumberOfThreads(Short forumId){
		return threadDao.getNumberOfThreadsInForum(forumId);
	}
	
	public List<Topic> getThreadsByParentForumId(Short parentForumId, Integer itemsPerPage, Integer pageNo, Boolean isStickyFlag, Users user) throws Exception{
		List<ThreadDbObj> threads = null;
		try{
			threads = threadDao.getThreadsByParentForumId(parentForumId, itemsPerPage, pageNo, isStickyFlag, user);
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
		
		List<Topic> result = new ArrayList<>();
		
		for(ThreadDbObj threadDbObj : threads){
			result.add(mapper.map(threadDbObj, Topic.class));
		}
		
		return result;
	}
}
