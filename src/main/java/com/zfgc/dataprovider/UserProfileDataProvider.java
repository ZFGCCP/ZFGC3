package com.zfgc.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.UserProfileDao;
import com.zfgc.dbobj.UserProfileViewDbObj;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.ProfileSummary;
import com.zfgc.model.users.profile.UserProfileView;
import com.zfgc.services.authentication.AuthenticationService;

@Component
public class UserProfileDataProvider extends AbstractDataProvider {
	@Autowired
	UserProfileDao userProfileDao;
	
	@Autowired
	AuthenticationService authenticationService;
	
	public Users getUserProfile(Integer userId) throws Exception{
		UserProfileViewDbObj userProfileViewDbObj = null;
		try{
			userProfileViewDbObj = userProfileDao.getUserProfile(userId);
		}
		catch(ZfgcNotFoundException ex){
			throw new ZfgcNotFoundException(ex.getResourceName());
		}
		
		return mapper.map(userProfileViewDbObj, Users.class);
	}

	public void saveAccountSettings(Users accountSettings) throws Exception {
		authenticationService.logEmailAddress(accountSettings.getEmailAddress());
		userProfileDao.saveAccountSettings(accountSettings);
		
	}
}
