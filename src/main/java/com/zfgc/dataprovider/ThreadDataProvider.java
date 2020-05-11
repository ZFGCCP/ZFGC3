package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.PostContentDao;
import com.zfgc.dao.ThreadDao;
import com.zfgc.dao.ThreadPostDao;
import com.zfgc.dbobj.PostContentDbObj;
import com.zfgc.dbobj.PostContentDbObjExample;
import com.zfgc.dbobj.ThreadDbObj;
import com.zfgc.dbobj.ThreadDbObjExample;
import com.zfgc.dbobj.ThreadPostDbObj;
import com.zfgc.dbobj.ThreadPostDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.forum.PostContent;
import com.zfgc.model.forum.Thread;
import com.zfgc.model.forum.ThreadPost;
import com.zfgc.model.users.Users;

@Component
public class ThreadDataProvider extends AbstractDataProvider {
	@Autowired
	ThreadDao threadDao;

	@Autowired
	private ThreadPostDao threadPostDao;
	
	@Autowired
	private PostContentDao postContentDao;
	
	public Long getNumberOfThreads(Short forumId){
		ThreadDbObjExample ex = threadDao.getExample();
		ex.createCriteria().andParentForumIdEqualTo(forumId);
		
		return threadDao.countByExample(null, ex);
	}
	
	public List<Thread> getThreadsByParentForumId(Short parentForumId, Boolean isStickyFlag) {
		ThreadDbObjExample ex = threadDao.getExample();
		ex.createCriteria().andParentForumIdEqualTo(parentForumId)
						   .andStickyFlagEqualTo(isStickyFlag);
		
		List<ThreadDbObj> threads = threadDao.get(ex);
		List<Thread> result = new ArrayList<>();
		
		for(ThreadDbObj thread : threads) {
			Thread topic = mapper.map(thread, Thread.class);
			result.add(topic);
		}
		
		return result;
	}
	
	public Thread saveThread(Thread thread) {
		threadDao.updateOrInsert(thread);
		
		return thread;
	}
	
	public ThreadPost postToThread(ThreadPost post) {
		threadPostDao.updateOrInsert(post);
		
		return post;
	}
	
	public ThreadPost getThreadPostByThreadId(Integer threadId) {
		ThreadPostDbObjExample ex = threadPostDao.getExample();
		ex.createCriteria().andThreadIdEqualTo(threadId);
		
		List<ThreadPostDbObj> dbObj = threadPostDao.get(ex);
		
		if(dbObj.isEmpty()) {
			throw new ZfgcNotFoundException("thread " + threadId);
		}
		
		return mapper.map(dbObj.get(0), ThreadPost.class);
		
	}
	
	public List<ThreadPost> getThreadPostsByUserId(Integer usersId){
		ThreadPostDbObjExample ex = threadPostDao.getExample();
		ex.createCriteria().andAuthorIdEqualTo(usersId);
		
		List<ThreadPostDbObj> dbObj = threadPostDao.get(ex);
		List<ThreadPost> result = new ArrayList<>();
		
		for(ThreadPostDbObj db : dbObj) {
			result.add(mapper.map(db, ThreadPost.class));
		}
		
		return result;
	}
	
	public List<PostContent> getPostContent(Integer postId){
		List<PostContent> result = new ArrayList<>();
		PostContentDbObjExample ex = postContentDao.getExample();
		ex.createCriteria().andThreadPostIdEqualTo(postId);
		
		List<PostContentDbObj> dbObj = postContentDao.get(ex);
		
		for(PostContentDbObj db : dbObj) {
			result.add(mapper.map(db, PostContent.class));
		}
		
		return result;
	}
	
	public PostContent savePostContent(PostContent content) {
		postContentDao.updateOrInsert(content);
		
		return content;
	}
	
	public void resetPostContentCurrentFlags(Integer threadPostId) {
		PostContent content = new PostContent();
		content.setThreadPostId(threadPostId);
		content.setCurrentFlag(false);
		
		postContentDao.updateByExample(content, null);
	}
}
