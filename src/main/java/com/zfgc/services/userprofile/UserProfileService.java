package com.zfgc.services.userprofile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.UserProfileDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.NavTab;
import com.zfgc.model.users.profile.ProfileSummary;
import com.zfgc.model.users.profile.UserProfileView;
import com.zfgc.services.lookups.LookupService;

@Component
public class UserProfileService {
	@Autowired
	UserProfileDataProvider userProfileDataProvider;
	
	@Autowired
	LookupService lookupService;
	
	@Autowired
	NavTabService navTabService;
	
	public List<NavTab> getProfileNavTabs(Users user, Integer usersId){
		return navTabService.getUserProfileNavTabs(user, usersId);
	}
	
	public UserProfileView getProfile(Integer userId, Users zfgcUser) throws Exception{
		UserProfileView profileView = null;
		try{
			profileView = userProfileDataProvider.getUserProfile(userId);
		}
		catch(ZfgcNotFoundException ex){
			throw new ZfgcNotFoundException(ex.getResourceName());
		}
		
		Integer currentUserId = zfgcUser.getUsersId();
		//permissions
		if(currentUserId != null && !currentUserId.equals(userId) && 
			!lookupService.getLkupValue(LookupService.MEMBER_GROUP,zfgcUser.getPrimaryMemberGroupId()).equals("Manager")){
			
			ProfileSummary summary = profileView.getProfileSummary();
			if(summary.getHideBirthDateFlag() || summary.getHideAgeFlag()){
				summary.setBirthDate(null);
			}
			
			if(summary.getHideEmailFlag()){
				summary.setBirthDate(null);
			}
			
			if(summary.getHideGenderFlag()){
				summary.setGender(null);
			}
			
			summary.setPrimaryIp(null);
		}
		
		return profileView;
		
	}
}
