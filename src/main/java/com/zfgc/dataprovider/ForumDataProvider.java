package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.ForumDao;
import com.zfgc.dbobj.ForumDbObj;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.forum.Forum;
import com.zfgc.model.users.Users;

@Component
public class ForumDataProvider extends AbstractDataProvider {
	@Autowired
	ForumDao forumDao;
	
	public List<Forum> getForumsByParent(List<Short> parentId, Users user) throws Exception{
		List<ForumDbObj> forumsDb = null;
		try{
			forumsDb = forumDao.getForumsByParent(parentId, user);
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
		List<Forum> forums = new ArrayList<Forum>();
		for(ForumDbObj forum : forumsDb){
			forums.add(mapper.map(forum,Forum.class));
		}
		
		return forums;
	}
	
	public List<Forum> getForumsByCategory(Integer categoryId) throws Exception{
		List<ForumDbObj> forumsDb = null;
		try{
			forumsDb = forumDao.getForumsByCategory(categoryId);
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
		List<Forum> forums = new ArrayList<Forum>();
		for(ForumDbObj forum : forumsDb){
			forums.add(mapper.map(forum,Forum.class));
		}
		
		return forums;
	}
	
	public List<Forum> getForumsByCategory(List<Integer> categoryId) throws Exception{
		List<ForumDbObj> forumsDb = null;
		try{
			forumsDb = forumDao.getForumsByCategory(categoryId);
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
		List<Forum> forums = new ArrayList<Forum>();
		for(ForumDbObj forum : forumsDb){
			forums.add(mapper.map(forum,Forum.class));
		}
		
		return forums;
	}
	
	public Forum getForum(Short forumId, Users user) throws ZfgcNotFoundException, Exception{
		try{
			return mapper.map(forumDao.getForum(forumId, user), Forum.class);
		}
		catch(ZfgcNotFoundException ex){
			throw new ZfgcNotFoundException("Forum Id " + forumId);
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
}
