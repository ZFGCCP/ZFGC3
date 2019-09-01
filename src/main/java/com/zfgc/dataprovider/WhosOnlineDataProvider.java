package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.IpDao;
import com.zfgc.dao.WhosOnlineDao;
import com.zfgc.dao.WhosOnlineDetailViewDao;
import com.zfgc.dbobj.IpAddressDbObjExample;
import com.zfgc.dbobj.OnlineUserDbObj;
import com.zfgc.dbobj.OnlineUserDetailDbObj;
import com.zfgc.model.online.OnlineUser;
import com.zfgc.model.online.WhosOnlineList;
import com.zfgc.model.users.IpAddress;

@Component
public class WhosOnlineDataProvider extends AbstractDataProvider{
	
	@Autowired
	WhosOnlineDao whosOnlineDao;
	
	@Autowired
	WhosOnlineDetailViewDao whosOnlineDetailViewDao;
	
	@Autowired
	IpDataProvider ipDataProvider;
	
	public WhosOnlineList getWhosOnline() throws RuntimeException{
		WhosOnlineList result = new WhosOnlineList();
		
		List<OnlineUserDbObj> dbObj = whosOnlineDao.get(whosOnlineDao.getExample()); 
		for(OnlineUserDbObj db : dbObj){
			result.getOnlineUsers().add(mapper.map(db, OnlineUser.class));
		}
		
		return result;
	}
	
	public WhosOnlineList getWhosOnlineDetailed() throws RuntimeException {
		WhosOnlineList result = new WhosOnlineList();
		
		List<OnlineUserDetailDbObj> dbObj = whosOnlineDetailViewDao.get(whosOnlineDetailViewDao.getExample());
		for(OnlineUserDetailDbObj db : dbObj){
			if(!result.getOnlineUsersDetailed().containsKey(db.getUsersId())) {
				result.getOnlineUsersDetailed().put(db.getUsersId(), new ArrayList<OnlineUser>());
			}
			IpAddress ip = ipDataProvider.getIpAddress(db.getIpAddress());
			OnlineUser user = mapper.map(db, OnlineUser.class);
			user.setIp(ip);
			result.getOnlineUsersDetailed().get(db.getUsersId()).add(user);
			
		}
		
		return result;
	}
}
