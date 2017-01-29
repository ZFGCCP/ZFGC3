package com.zfgc.services.forum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.ForumDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.forum.Category;
import com.zfgc.model.forum.Forum;
import com.zfgc.model.forum.ForumIndex;
import com.zfgc.model.users.Users;
import com.zfgc.services.AbstractService;

@Component
public class ForumService extends AbstractService {
	@Autowired
	ForumDataProvider forumDataProvider;

	@Autowired
	CategoryService categoryService;
	
	@Autowired 
	ThreadService threadService;
	
	public ForumIndex getForumIndex(Users user){
		ForumIndex index = new ForumIndex();

		try{
			//get all categories
			List<Category> cats = categoryService.getCategories();
			
			//get all forums for at the top level
			List<Forum> forums = forumDataProvider.getForumsByParent(Arrays.asList(new Short[]{null}), user);
			
			//map the results
			Map<Integer,Category> results = new HashMap<>();
			
			for(Category cat : cats){
				results.put(cat.getCategoryId(), cat);
			}
			
			for(Forum forum : forums){
				results.get(forum.getCategoryId()).getForums().add(forum);
			}
			
			List<Short> forumIds = getForumIds(forums);
			List<Forum> subForums = forumDataProvider.getForumsByParent(forumIds, user);
			Map<Short,Forum> forumResults = new HashMap<>();
			
			for(Forum forum : forums){
				forumResults.put(forum.getForumId(), forum);
			}
			
			for(Forum subForum : subForums){
				forumResults.get(subForum.getParentForumId()).getSubForums().add(subForum);
			}
			
			List<Category> mappedCategories = new ArrayList<Category>(results.values());
			index.setCategories(categoryService.removeEmptyCategories(mappedCategories));
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
	
	public Forum getForum(Short forumId, Integer itemsPerPage, Integer pageNo, Users user) throws ZfgcNotFoundException{
		try{
			//nah, fuck you
			if(itemsPerPage == 0){
				return null;
			}
			
			Forum forum = forumDataProvider.getForum(forumId, user);
			
			forum.setStickyThreads(threadService.getThreadsByParentForumId(forumId, itemsPerPage, pageNo, true, user));
			forum.setThreads(threadService.getThreadsByParentForumId(forumId, itemsPerPage, pageNo, false, user));
			
			forum.setThreadsCount(threadService.getThreadsInForum(forumId));
			
			Integer totalsWithoutSticky = forum.getThreadsCount() - forum.getStickyThreads().size();
			Integer totalPages = Math.floorDiv(totalsWithoutSticky.intValue(), itemsPerPage.intValue());
			forum.setTotalPages(totalPages);
			
			return forum;
		}
		catch(ZfgcNotFoundException ex){
			throw new ZfgcNotFoundException("Forum Id " + forumId);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}
