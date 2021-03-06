package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.constants.Forum.ForumConstants;
import com.zfgc.dao.ForumDao;
import com.zfgc.dao.ForumPermissionsViewDao;
import com.zfgc.dbobj.ForumDbObj;
import com.zfgc.dbobj.ForumPermissionsViewDbObj;
import com.zfgc.dbobj.ForumPermissionsViewDbObjExample;
import com.zfgc.dbobj.ForumPermissionsViewDbObjExample.Criteria;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.mappers.ForumPermissionsViewDbObjMapper;
import com.zfgc.model.forum.Forum;
import com.zfgc.model.users.Users;

@Component
public class ForumDataProvider extends AbstractDataProvider {
	@Autowired
	ForumDao forumDao;
	
	@Autowired
	private ForumPermissionsViewDao forumPermissionsViewDao;
	
	public List<Forum> getForumsByParent(Short parentId, Users user) {
		List<Short> id = new ArrayList<>();
		id.add(parentId);
		
		return getForumsByParent(id, user);
	}
	
	public List<Forum> getForumsByParent(List<Short> parentId, Users user) {
		List<ForumPermissionsViewDbObj> forumDbs = null;
		List<Integer> permissionIds = new ArrayList<>();
		
		permissionIds.addAll(user.getPermissions().stream().mapToInt(x -> x.getPermissionsId()).boxed().collect(Collectors.toList()));
		ForumPermissionsViewDbObjExample ex = forumPermissionsViewDao.getExample();
	
		if(parentId.isEmpty()) {
			ex.createCriteria().andPermissionIdIn(permissionIds).andParentForumIdIsNull();
		}
		else {
			ex.createCriteria().andPermissionIdIn(permissionIds).andParentForumIdIn(parentId);
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
	
	public Forum getForum(Short forumId, Users user) {
		ForumPermissionsViewDbObjExample ex = new ForumPermissionsViewDbObjExample();
		List<Integer> permissionIds = new ArrayList<>();
		permissionIds.addAll(user.getPermissions().stream().mapToInt(x -> x.getPermissionsId()).boxed().collect(Collectors.toList()));
		
		ex.createCriteria().andForumIdEqualTo(forumId).andPermissionIdIn(permissionIds);
		List<ForumPermissionsViewDbObj> result = forumPermissionsViewDao.get(ex);
		
		if(result.size() == 0) {
			throw new ZfgcNotFoundException("ForumId : " + forumId);
		}
		
		return mapper.map(result.get(0), Forum.class);
	}
	
	public List<Forum> getForumPermissions(Short parentId, Users user) {
		List<ForumPermissionsViewDbObj> forumDbs = null;
		ForumPermissionsViewDbObjExample ex = forumPermissionsViewDao.getExample();
		ex.createCriteria().andParentForumIdEqualTo(parentId);
						   
		
		forumDbs = forumPermissionsViewDao.get(ex);
		List<Forum> forums = new ArrayList<>();
		
		for(ForumPermissionsViewDbObj dbObj : forumDbs) {
			forums.add(mapper.map(dbObj, Forum.class));
		}
		
		return forums;
	}
}
