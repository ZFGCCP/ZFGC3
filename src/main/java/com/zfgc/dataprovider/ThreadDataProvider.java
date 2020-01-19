package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.ThreadDao;
import com.zfgc.dbobj.ThreadDbObj;
import com.zfgc.dbobj.ThreadDbObjExample;
import com.zfgc.model.forum.Topic;
import com.zfgc.model.users.Users;

@Component
public class ThreadDataProvider extends AbstractDataProvider {
	@Autowired
	ThreadDao threadDao;
	
	public Long getNumberOfThreads(Short forumId){
		ThreadDbObjExample ex = threadDao.getExample();
		ex.createCriteria().andParentForumIdEqualTo(forumId);
		
		return threadDao.countByExample(null, ex);
	}
	
	public List<Topic> getThreadsByParentForumId(Short parentForumId, Boolean isStickyFlag) {
		ThreadDbObjExample ex = threadDao.getExample();
		ex.createCriteria().andParentForumIdEqualTo(parentForumId)
						   .andStickyFlagEqualTo(isStickyFlag);
		
		List<ThreadDbObj> threads = threadDao.get(ex);
		List<Topic> result = new ArrayList<>();
		
		for(ThreadDbObj thread : threads) {
			Topic topic = mapper.map(thread, Topic.class);
			result.add(topic);
		}
		
		return result;
	}
}
