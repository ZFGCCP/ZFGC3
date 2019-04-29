package com.zfgc.services.whosOnline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.WhosOnlineDataProvider;
import com.zfgc.model.online.WhosOnlineList;
import com.zfgc.services.AbstractService;

@Component
public class WhosOnlineService extends AbstractService {
	
	@Autowired
	WhosOnlineDataProvider whosOnlineDataProvider;
	
	public WhosOnlineList getWhosOnline() throws Exception{
		WhosOnlineList online = whosOnlineDataProvider.getWhosOnline();
		
		return online;
	}
	
}
