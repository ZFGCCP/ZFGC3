package com.zfgc.services.forum;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.dataprovider.ForumDataProvider;
import com.zfgc.dataprovider.ThreadDataProvider;
import com.zfgc.model.users.Users;
import com.zfgc.requiredfields.forum.ThreadRequiredFields;
import com.zfgc.services.AbstractService;
import com.zfgc.services.RuleRunService;
import com.zfgc.services.bbcode.BbcodeService;
import com.zfgc.validation.forum.ThreadValidator;
import com.zfgc.model.forum.BrMemberGroupForum;
import com.zfgc.model.forum.PostContent;
import com.zfgc.model.forum.Thread;
import com.zfgc.model.forum.ThreadPost;

@Component
public class ThreadService extends AbstractService {
	@Autowired
	ThreadDataProvider threadDataProvider;
	
	@Autowired
	ForumDataProvider forumDataProvider;
	
	@Autowired
	private BbcodeService bbcodeService;
	
	@Autowired
	private ThreadValidator threadValidator;
	
	@Autowired
	private ThreadRequiredFields threadRequiredFields;
	
	@Autowired
	private RuleRunService<Thread> ruleRunner;

	
	public Long getThreadsInForum(Short forumId){
		return threadDataProvider.getNumberOfThreads(forumId);
	}
	
	public List<Thread> getThreadsByParentForumId(Short forumId, Integer itemsPerPage, Integer pageNo, Boolean isStickyFlag, Users user){
		//permission check
		forumDataProvider.getForum(forumId.shortValue(), user);
		
		List<Thread> threads = threadDataProvider.getThreadsByParentForumId(forumId, isStickyFlag);
		
		Integer start = itemsPerPage * (pageNo - 1);
		
		if(!isStickyFlag) {
			return threads.stream()
				   .skip(start)
				   .limit(itemsPerPage).collect(Collectors.toList());
		}
		
		return threads;
	}
	
	public Thread getThreadTemplate(Integer forumId, Users user) {
		Thread topic = new Thread();
		topic.setThreadStarterId(user.getUsersId());
		topic.setAuthorName(user.getDisplayName());
		topic.setParentForumId(forumId);
		
		ThreadPost post = new ThreadPost();
		post.setAuthorId(user.getUsersId());
		post.getContent().add(new PostContent());
		post.getHeadContent().setAuthorId(user.getUsersId());
		post.getHeadContent().setCurrentFlag(true);
		
		topic.getPosts().add(post);
		
		return topic;
	}
	
	@Transactional
	public Thread saveNewThread(Thread thread, Users user) {
		ruleRunner.runRules(threadValidator, threadRequiredFields, null, thread, user);
		
		threadDataProvider.saveThread(thread);
		
		//save the last post
		thread.getTailPost().setThreadId(thread.getThreadId());
		threadDataProvider.postToThread(thread.getTailPost());
		
		thread.getTailPost().getHeadContent().setThreadPostId(thread.getTailPost().getThreadPostId());
		threadDataProvider.savePostContent(thread.getTailPost().getHeadContent());
		
		return thread;
		
	}
	
	public Thread previewThread(Thread thread, Users zfgcUser) {
		ruleRunner.runRules(threadValidator, threadRequiredFields, null, thread, zfgcUser);
		
		return prepareThreadForView(thread);
	}
	
	public Thread prepareThreadForView(Thread thread) {
		for(ThreadPost post : thread.getPosts()) {
			String content = post.getHeadContent().getPostData();
			
			try {
				content = bbcodeService.parseText(content);
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				throw new RuntimeException(e);
			}
			
			post.getHeadContent().setBody(content);
		}
		
		return thread;
	}
	
	public void stickyUnstickyThreads(List<Integer> threadIds, Users zfgcUser) {
		//get all the threads
		List<Thread> threads = threadDataProvider.getThreadsById(threadIds);
		
		//ensure the user actually has permissions to modify these threads
		
		//swap their sticky flags and save
		for(Thread thread : threads) {
			thread.setStickyFlag(!thread.getStickyFlag());
			threadDataProvider.saveThread(thread);
		}
		
	}
	
	public void lockUnlockThreads(List<Integer> threadIds, Users zfgcUser) {
		//get all the threads
		List<Thread> threads = threadDataProvider.getThreadsById(threadIds);
		
		//ensure the user actually has permissions to modify these threads
		
		//swap their lock flags and save
		for(Thread thread : threads) {
			thread.setLockedFlag(!thread.getLockedFlag());
			threadDataProvider.saveThread(thread);
		}
	}
	
}
