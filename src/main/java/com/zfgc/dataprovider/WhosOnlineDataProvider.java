package com.zfgc.dataprovider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.WhosOnlineDao;
import com.zfgc.dbobj.OnlineUserDbObj;
import com.zfgc.model.online.OnlineUser;
import com.zfgc.model.online.WhosOnlineList;

@Component
public class WhosOnlineDataProvider extends AbstractDataProvider{
	
	@Autowired
	WhosOnlineDao whosOnlineDao;
	
	public WhosOnlineList getWhosOnline() throws Exception{
		WhosOnlineList result = new WhosOnlineList();
		
		List<OnlineUserDbObj> dbObj = whosOnlineDao.get(whosOnlineDao.getExample()); 
		for(OnlineUserDbObj db : dbObj){
			result.getOnlineUsers().add(mapper.map(db, OnlineUser.class));
		}
		
		return result;
	}
}
