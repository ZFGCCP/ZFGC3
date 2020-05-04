package com.zfgc.services.forum;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.ForumDataProvider;
import com.zfgc.dataprovider.ThreadDataProvider;
import com.zfgc.model.users.Users;
import com.zfgc.services.AbstractService;
import com.zfgc.services.RuleRunService;
import com.zfgc.services.bbcode.BbcodeService;
import com.zfgc.validation.forum.ThreadValidator;
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
		post.getContent().get(0).setAuthor(user.getUsersId());
		
		topic.getPosts().add(post);
		
		return topic;
	}
	
	public Thread saveNewThread(Thread thread, Users user) {
		threadDataProvider.saveThread(thread);
		
		thread.getHeadPost().setThreadId(thread.getThreadId());
		threadDataProvider.postToThread(thread.getHeadPost());
		
		return thread;
		
	}
	
	public Thread previewThread(Thread thread, Users zfgcUser) {
		ruleRunner.runRules(threadValidator, null, null, thread, zfgcUser);
		
		return prepareThreadForView(thread);
	}
	
	public Thread prepareThreadForView(Thread thread) {
		for(ThreadPost post : thread.getPosts()) {
			String content = post.getContent().get(0).getBody();
			
			try {
				content = bbcodeService.parseText(content);
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				throw new RuntimeException(e);
			}
			
			post.getContent().get(0).setBody(content);
		}
		
		return thread;
	}
	
}
