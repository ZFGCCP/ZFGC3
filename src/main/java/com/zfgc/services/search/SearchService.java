package com.zfgc.services.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.UsersDataProvider;
import com.zfgc.model.search.UserSearch;
import com.zfgc.model.users.Users;
import com.zfgc.services.AbstractService;

@Component
public class SearchService extends AbstractService{
	@Autowired
	UsersDataProvider usersDataProvider;
	
	public List<UserSearch> simpleUserSearch(String queryString, Integer start, Integer length){
		List<Users> result = usersDataProvider.simpleUserSearch(queryString, start, length);
		List<UserSearch> searchResult = new ArrayList<>();
		
		for(Users user : result){
			searchResult.add(createSearchResult(user));
		}
		
		return searchResult;
	}
	
	private UserSearch createSearchResult(Users user){
		if(user == null){
			return null;
		}
		
		UserSearch searchResult = new UserSearch();
		searchResult.setUsersId(user.getUsersId());
		searchResult.setDisplayName(user.getDisplayName());
		searchResult.setEmail(user.getEmailAddress());
		searchResult.setAvatar(user.getAvatar());
		
		return searchResult;
	}
}
