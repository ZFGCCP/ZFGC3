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
import com.zfgc.rules.users.AccountSettingsRuleChecker;
import com.zfgc.services.lookups.LookupService;

@Component
public class UserProfileService {
	@Autowired
	UserProfileDataProvider userProfileDataProvider;
	
	@Autowired
	LookupService lookupService;
	
	@Autowired
	NavTabService navTabService;
	
	@Autowired
	AccountSettingsRuleChecker accountSettingsRuleChecker;
	
	public List<NavTab> getProfileNavTabs(Users user, Integer usersId){
		return navTabService.getUserProfileNavTabs(user, usersId);
	}
	
	public Users getProfile(Integer userId, Users zfgcUser) throws Exception{
		UserProfileView profileView = null;
		try{
			profileView = userProfileDataProvider.getUserProfile(userId);
		}
		catch(ZfgcNotFoundException ex){
			throw new ZfgcNotFoundException(ex.getResourceName());
		}
		
		Users user = mapProfileViewToUser(profileView);
		
		Integer currentUserId = zfgcUser.getUsersId();
		//permissions
		if(currentUserId != null && !currentUserId.equals(userId) && 
			!lookupService.getLkupValue(LookupService.MEMBER_GROUP,zfgcUser.getPrimaryMemberGroupId()).equals("Manager")){

		}
		
		return user;
		
	}

	public Users saveAccountSettings(Users accountSettings,Users zfgcUser) throws Exception {
		try{
			UserProfileView savedProfile = userProfileDataProvider.getUserProfile(accountSettings.getUsersId());

			if(!accountSettings.getErrors().hasErrors()){
				userProfileDataProvider.saveAccountSettings(accountSettings);
			}
		}
		catch(ZfgcNotFoundException ex){
			throw new ZfgcNotFoundException(ex.getMessage());
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
		
		return accountSettings;
		
	}
	
	private Users mapProfileViewToUser(UserProfileView profileView){
		Users user = new Users();
		
		user.setUsersId(profileView.getUsersId());
		user.setLoginName(profileView.getProfileSummary().getLoginName());
		user.setDisplayName(profileView.getProfileSummary().getDisplayName());
		user.setBirthDate(profileView.getProfileSummary().getBirthDate());
		user.setDateRegistered(profileView.getProfileSummary().getDateRegistered());
		user.setPrimaryMemberGroupId(profileView.getProfileSummary().getPrimaryMemberGroupId());
		
		user.getContactInfo().setAim(profileView.getProfileSummary().getAim());
		user.getContactInfo().setGtalk(profileView.getProfileSummary().getGtalk());
		user.getContactInfo().setNnid(profileView.getProfileSummary().getNnid());
		user.getContactInfo().setPsn(profileView.getProfileSummary().getPsn());
		user.getContactInfo().setSkype(profileView.getProfileSummary().getSkype());
		user.getContactInfo().setSteam(profileView.getProfileSummary().getSteam());
		user.getContactInfo().setXboxLive(profileView.getProfileSummary().getXboxLive());
		user.getContactInfo().setYim(profileView.getProfileSummary().getYim());
		
		return user;
	}
}
