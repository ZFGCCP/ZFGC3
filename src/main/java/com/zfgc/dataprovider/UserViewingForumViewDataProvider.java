package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.UserViewingForumViewDao;
import com.zfgc.dbobj.UserViewingForumViewDbObj;
import com.zfgc.dbobj.UserViewingForumViewDbObjExample;
import com.zfgc.model.users.UserViewingForumView;

@Component
public class UserViewingForumViewDataProvider extends AbstractDataProvider {
	
	@Autowired
	private UserViewingForumViewDao userViewingForumViewDao;
	
	public List<UserViewingForumView> getUsersViewingForum(Integer forumId){
		UserViewingForumViewDbObjExample ex = userViewingForumViewDao.getExample();
		ex.createCriteria().andForumIdEqualTo(forumId);
		
		List<UserViewingForumViewDbObj> db = userViewingForumViewDao.get(ex);
		List<UserViewingForumView> result = new ArrayList<>();
		
		for(UserViewingForumViewDbObj dbObj : db) {
			UserViewingForumView view = mapper.map(dbObj, UserViewingForumView.class);
			result.add(view);
		}
		
		return result;
	}
	
}