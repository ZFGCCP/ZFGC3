package com.zfgc.services.userprofile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.UserProfileDataProvider;
import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.ProfileSummary;
import com.zfgc.model.users.profile.UserProfileView;

@Component
public class UserProfileService {
	@Autowired
	UserProfileDataProvider userProfileDataProvider;
	
	public UserProfileView getProfile(Integer userId, Users zfgcUser) throws Exception{
		UserProfileView profileView = userProfileDataProvider.getUserProfile(userId);
		
		//permissions
		if(!zfgcUser.getUsersId().equals(userId)){
			ProfileSummary summary = profileView.getProfileSummary();
			if(summary.getHideBirthDateFlag()){
				summary.setBirthDate(null);
			}
		}
		
	}
}
