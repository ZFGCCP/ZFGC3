package com.zfgc.services.whosOnline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.UserConnectionDataProvider;
import com.zfgc.dataprovider.WhosOnlineDataProvider;
import com.zfgc.model.online.WhosOnlineList;
import com.zfgc.model.users.UserViewingForumView;
import com.zfgc.services.AbstractService;
import com.zfgc.services.ip.IpAddressService;

@Component
public class WhosOnlineService extends AbstractService {
	
	@Autowired
	WhosOnlineDataProvider whosOnlineDataProvider;
	
	@Autowired
	UserConnectionDataProvider userConnectionDataProvider;
	
	public WhosOnlineList getWhosOnline() throws RuntimeException{
		WhosOnlineList online = whosOnlineDataProvider.getWhosOnline();
		
		return online;
	}
	
	public WhosOnlineList getWhosOnlineDetailed() throws RuntimeException {
		WhosOnlineList online = whosOnlineDataProvider.getWhosOnlineDetailed();
		
		return online;
	}
	
	public UserViewingForumView getUsersViewingForum(Integer forumId) {
		UserViewingForumView usersViewing = userConnectionDataProvider.getUsersViewingForum(forumId);
		websocketMessaging.convertAndSend("/socket/viewingForum/" + forumId, usersViewing);
		
		return usersViewing;
	}
	
}
