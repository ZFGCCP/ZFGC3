package com.zfgc.services.forum;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.ForumDataProvider;
import com.zfgc.dataprovider.ThreadDataProvider;
import com.zfgc.model.users.Users;
import com.zfgc.services.AbstractService;
import com.zfgc.model.forum.Topic;

@Component
public class ThreadService extends AbstractService {
	@Autowired
	ThreadDataProvider threadDataProvider;
	
	@Autowired
	ForumDataProvider forumDataProvider;
	
	public Long getThreadsInForum(Short forumId){
		return threadDataProvider.getNumberOfThreads(forumId);
	}
	
	public List<Topic> getThreadsByParentForumId(Short forumId, Integer itemsPerPage, Integer pageNo, Boolean isStickyFlag, Users user){
		//permission check
		forumDataProvider.getForum(forumId.shortValue(), user);
		
		List<Topic> threads = threadDataProvider.getThreadsByParentForumId(forumId, isStickyFlag);
		
		Integer start = itemsPerPage * (pageNo - 1);
		
		if(!isStickyFlag) {
			return threads.stream()
				   .skip(start)
				   .limit(itemsPerPage).collect(Collectors.toList());
		}
		
		return threads;
	}
}
