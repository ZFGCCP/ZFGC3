package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.PollDao;
import com.zfgc.dao.PostContentDao;
import com.zfgc.dao.ThreadDao;
import com.zfgc.dao.ThreadPostDao;
import com.zfgc.dao.TopicViewDao;
import com.zfgc.dbobj.PostContentDbObj;
import com.zfgc.dbobj.PostContentDbObjExample;
import com.zfgc.dbobj.ThreadDbObj;
import com.zfgc.dbobj.ThreadDbObjExample;
import com.zfgc.dbobj.ThreadPostDbObj;
import com.zfgc.dbobj.ThreadPostDbObjExample;
import com.zfgc.dbobj.TopicViewDbObj;
import com.zfgc.dbobj.TopicViewDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.forum.Poll;
import com.zfgc.model.forum.PostContent;
import com.zfgc.model.forum.Thread;
import com.zfgc.model.forum.ThreadPost;
import com.zfgc.model.forum.Topic;
import com.zfgc.model.users.Users;

@Component
public class ThreadDataProvider extends AbstractDataProvider {
	@Autowired
	ThreadDao threadDao;

	@Autowired
	private ThreadPostDao threadPostDao;
	
	@Autowired
	private PostContentDao postContentDao;
	
	@Autowired
	private TopicViewDao topicViewDao;
	
	@Autowired
	private PollDao pollDao;
	
	public Long getNumberOfThreads(Short forumId){
		TopicViewDbObjExample ex = topicViewDao.getExample();
		ex.createCriteria().andParentForumIdEqualTo(forumId);
		
		return topicViewDao.countByExample(null, ex);
	}
	
	public List<Topic> getThreadsByParentForumId(Short parentForumId, Boolean isStickyFlag) {
		TopicViewDbObjExample ex = topicViewDao.getExample();
		ex.createCriteria().andParentForumIdEqualTo(parentForumId)
						   .andStickyFlagEqualTo(isStickyFlag);
		
		List<TopicViewDbObj> threads = topicViewDao.get(ex);
		List<Topic> result = new ArrayList<>();
		
		for(TopicViewDbObj thread : threads) {
			Topic topic = mapper.map(thread, Topic.class);
			result.add(topic);
		}
		
		return result;
	}
	
	public List<Topic> getThreadsById(List<Integer> threadId) {
		TopicViewDbObjExample ex = topicViewDao.getExample();
		ex.createCriteria().andThreadIdIn(threadId);
					
		
		List<TopicViewDbObj> threads = topicViewDao.get(ex);
		List<Topic> result = new ArrayList<>();
		
		for(TopicViewDbObj thread : threads) {
			Topic topic = mapper.map(thread, Topic.class);
			result.add(topic);
		}
		
		return result;
	}
	
	public Thread saveThread(Thread thread) {
		threadDao.updateOrInsert(thread);
		return thread;
	}
	
	public Poll savePoll(Poll poll) {
		pollDao.updateOrInsert(poll);
		return poll;
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
