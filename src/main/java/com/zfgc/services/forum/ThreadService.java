package com.zfgc.services.forum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.ThreadDataProvider;
import com.zfgc.model.users.Users;
import com.zfgc.services.AbstractService;
import com.zfgc.model.forum.Topic;

@Component
public class ThreadService extends AbstractService {
	@Autowired
	ThreadDataProvider threadDataProvider;
	
	public Integer getThreadsInForum(Short forumId){
		return threadDataProvider.getNumberOfThreads(forumId);
	}
	
	public List<Topic> getThreadsByParentForumId(Short forumId, Integer itemsPerPage, Integer pageNo, Boolean isStickyFlag, Users user) throws Exception{
		try{
			return threadDataProvider.getThreadsByParentForumId(forumId, itemsPerPage, pageNo, isStickyFlag, user);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}
