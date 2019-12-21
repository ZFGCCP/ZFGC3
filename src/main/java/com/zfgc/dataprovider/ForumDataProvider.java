package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.constants.Forum.ForumConstants;
import com.zfgc.dao.ForumDao;
import com.zfgc.dao.ForumPermissionsViewDao;
import com.zfgc.dbobj.ForumDbObj;
import com.zfgc.dbobj.ForumPermissionsViewDbObj;
import com.zfgc.dbobj.ForumPermissionsViewDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.forum.Forum;
import com.zfgc.model.users.Users;

@Component
public class ForumDataProvider extends AbstractDataProvider {
	@Autowired
	ForumDao forumDao;
	
	@Autowired
	private ForumPermissionsViewDao forumPermissionsViewDao;
	
	public List<Forum> getForumsByParent(List<Short> parentId, Users user) throws Exception{
		List<ForumPermissionsViewDbObj> forumDbs = null;
		List<Integer> permissionIds = new ArrayList<>();
		
		permissionIds.addAll(user.getMemberGroupIds());
		ForumPermissionsViewDbObjExample ex = forumPermissionsViewDao.getExample();
		ex.createCriteria().andMemberGroupIdIn(permissionIds);
		
		if(parentId.isEmpty()) {
			ex.createCriteria().andParentForumIdIsNull();
		}
		else {
			ex.createCriteria().andParentForumIdIn(parentId);
		}
		
		forumDbs = forumPermissionsViewDao.get(ex);
		Map<Short, Forum> forums = new HashMap<>();
		Map<Short, List<ForumConstants.ForumPermissions>> perms = new HashMap<>();
		
		for(ForumPermissionsViewDbObj dbObj : forumDbs) {
			if(!perms.containsKey(dbObj.getForumId())) {
				perms.put(dbObj.getForumId(), new ArrayList<>());
			}
			
			forums.put(dbObj.getForumId(), mapper.map(dbObj, Forum.class));
			
			perms.get(dbObj.getForumId()).add(dbObj.getReadFlag() ? ForumConstants.ForumPermissions.READ : ForumConstants.ForumPermissions.WRITE);
		}
		
		List<Forum> result = new ArrayList<>();
		Iterator<Short> itr = forums.keySet().iterator();
		while(itr.hasNext()) {
			Short forumId = itr.next();
			Forum forum = forums.get(forumId);
			
			for(ForumConstants.ForumPermissions fp : perms.get(forumId)) {
				if(fp.equals(ForumConstants.ForumPermissions.READ)) {
					forum.setCanRead(true);
				}
				else {
					forum.setCanWrite(true);
				}
			}
			
			result.add(forum);
		}
		
		return result;
	}
	
	public List<Forum> getForumsByCategory(Integer categoryId) throws Exception{
		List<ForumPermissionsViewDbObj> forumsDb = null;
		ForumPermissionsViewDbObjExample ex = forumPermissionsViewDao.getExample();
		ex.createCriteria().andCategoryIdEqualTo(categoryId);
		
		forumsDb = forumPermissionsViewDao.get(ex);
		
		List<Forum> forums = new ArrayList<Forum>();
		for(ForumPermissionsViewDbObj forum : forumsDb){
			forums.add(mapper.map(forum,Forum.class));
		}
		
		return forums;
	}
	
	public List<Forum> getForumsByCategory(List<Integer> categoryId) throws Exception{
		List<ForumPermissionsViewDbObj> forumsDb = null;
		ForumPermissionsViewDbObjExample ex = forumPermissionsViewDao.getExample();
		ex.createCriteria().andCategoryIdIn(categoryId);
		
		forumsDb = forumPermissionsViewDao.get(ex);
		
		List<Forum> forums = new ArrayList<Forum>();
		for(ForumPermissionsViewDbObj forum : forumsDb){
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
