package com.zfgc.services.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.config.ZfgcGeneralConfig;
import com.zfgc.model.users.Users;
import com.zfgc.services.AbstractService;

@Component
public class LegacyRedirectService extends AbstractService {

	@Autowired
	private ZfgcGeneralConfig zfgcGeneralConfig;
	
	public String getRedirectLocation(String action, Integer userId, Users zfgcUser) throws RuntimeException{
		String result = zfgcGeneralConfig.getUiUrl();
		
		if(action != null){
			
			if(action.equals("profile")){
				result += "/userprofile?userId=";
				
				if(userId == null){
					result += zfgcUser.getUsersId();
				}
				else{
					result += userId;
				}
				
			}
			return result;
		}
		
		return result + "/bbs/index";
	}
	
}
