package com.zfgc.services.forum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.constants.user.UserConstants;
import com.zfgc.dataprovider.ForumDataProvider;
import com.zfgc.dataprovider.ThreadDataProvider;
import com.zfgc.dataprovider.UserViewingForumViewDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.forum.Category;
import com.zfgc.model.forum.Forum;
import com.zfgc.model.forum.ForumIndex;
import com.zfgc.model.users.UserViewingForumView;
import com.zfgc.model.users.Users;
import com.zfgc.services.AbstractService;
import com.zfgc.services.users.UsersService;

@Component
public class ForumService extends AbstractService {
	@Autowired
	ForumDataProvider forumDataProvider;

	@Autowired
	CategoryService categoryService;
	
	@Autowired 
	ThreadService threadService;
	
	@Autowired
	UserViewingForumViewDataProvider userViewingForumViewDataProvider;
	
	@Autowired
	UsersService usersService;
	
	public ForumIndex getForumIndex(Users user){
		ForumIndex index = new ForumIndex();

		try{
			//get all categories
			List<Category> cats = categoryService.getCategories();
			
			//get all forums for at the top level
			List<Forum> forums = forumDataProvider.getForumsByParent(new ArrayList<Short>(), user);
			
			List<Short> forumIds = forums.stream().map(f -> f.getForumId()).collect(Collectors.toList());
			
			//map the results
			List<Forum> subForums = forumDataProvider.getForumsByParent(forumIds, user);
			Map<Integer,Category> results = new HashMap<>();
			
			for(Category cat : cats){
				results.put(cat.getCategoryId(), cat);
			}
			
			for(Forum forum : forums){
				results.get(forum.getCategoryId()).getForums().add(forum);
				forum.setThreadsCount(threadService.getThreadsInForum(forum.getForumId()));
				
				for(Forum subForum : subForums) {
					if(subForum.getParentForumId().equals(forum.getForumId())) {
						forum.getSubForums().add(subForum);
						subForum.setThreadsCount(threadService.getThreadsInForum(subForum.getForumId()));
					}
				}
			}
			
			index.setCategories(new ArrayList<>(results.values()));
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		return index;
	}
	
	public List<Short> getForumIds(List<Forum> forums){
		List<Short> ids = new ArrayList<>();
		
		for(Forum forum : forums){
			ids.add(forum.getForumId());
		}
		
		return ids;
	}
	
	public Forum getForum(Short forumId, Integer itemsPerPage, Integer pageNo, Users user){
		//nah, fuck you
		if(itemsPerPage == 0){
			throw new IllegalArgumentException();
		}
		
		Forum forum = forumDataProvider.getForum(forumId, user);
		
		forum.setStickyThreads(threadService.getThreadsByParentForumId(forumId, itemsPerPage, pageNo, true, user));
		forum.setThreads(threadService.getThreadsByParentForumId(forumId, itemsPerPage, pageNo, false, user));
		
		forum.setThreadsCount(threadService.getThreadsInForum(forumId));
		
		forum.setSubForums(forumDataProvider.getForumsByParent(forumId, user));
		
		for(Forum sub : forum.getSubForums()) {
			sub.setThreadsCount(threadService.getThreadsInForum(sub.getForumId()));
		}
		
		Long totalsWithoutSticky = forum.getThreadsCount() - forum.getStickyThreads().size();
		Integer totalPages = Math.floorDiv(totalsWithoutSticky.intValue(), itemsPerPage.intValue());
		forum.setTotalPages(totalPages);
		
		usersService.updateUserActions(user.getSessionMatchup(), UserConstants.userActions.VIEWING_BOARD, user, forumId + "");
		
		UserViewingForumView result = getUsersViewingForum(forumId, user);
		
		super.websocketMessaging.convertAndSend("/socket/viewingForum/" + forumId, result);
		
		return forum;
	}
	
	public UserViewingForumView getUsersViewingForum(Short boardId, Users zfgcUser) {
		List<UserViewingForumView> usersViewing = userViewingForumViewDataProvider.getUsersViewingForum(boardId.intValue());
		UserViewingForumView result = new UserViewingForumView();
		for(UserViewingForumView viewing : usersViewing) {
			Users viewingUser = new Users();
			viewingUser.setUsersId(viewing.getUsersId());
			viewingUser.setDisplayName(viewing.getDisplayName());
			result.getUsers().add(viewingUser);
		}
		
		return result;
	}
	
	public Forum getForumMetadata(Short forumId, Users zfgcUser) {
		Forum forum = forumDataProvider.getForum(forumId, zfgcUser);
		forum.setThreadsCount(threadService.getThreadsInForum(forumId));
		
		return forum;
	}
	
	public List<Forum> getForumsFromCategory(Short categoryId, Users user){
		List<Forum> forums = forumDataProvider.getForumPermissions(categoryId, user);
		
		Iterator<Forum> forumItr = forums.iterator();
		
		while(forumItr.hasNext()) {
			Forum forum = forumItr.next();
		}
		
		return forums;
	}
}
