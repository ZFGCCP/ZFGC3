package com.zfgc.services.userprofile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.UserProfileDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.users.EmailAddress;
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
		Users user = null;
		try{
			user = userProfileDataProvider.getUserProfile(userId);
		}
		catch(ZfgcNotFoundException ex){
			throw new ZfgcNotFoundException(ex.getResourceName());
		}

		Integer currentUserId = zfgcUser.getUsersId();
		user.setTimeOffsetLkup(lookupService.getLkupValue(lookupService.TIMEZONE, user.getTimeOffset()));
		
		//permissions
		
		//if you're not the owner if this profile, and you're not an admin
		if(currentUserId == null || (!currentUserId.equals(userId) && 
			!lookupService.getLkupValue(LookupService.MEMBER_GROUP,zfgcUser.getPrimaryMemberGroupId()).equals("Manager"))){
			
			user.setPrimaryIpAddress(null);
			
			//hide contact fields with the hidden flag
			if(user.getContactInfo().getHideAimFlag()){
				user.getContactInfo().setAim(null);
			}
			
			if(user.getContactInfo().getHideYimFlag()){
				user.getContactInfo().setYim(null);
			}
			
			if(user.getContactInfo().getHideSkypeFlag()){
				user.getContactInfo().setSkype(null);
			}
			
			if(user.getContactInfo().getHideSteamFlag()){
				user.getContactInfo().setSteam(null);
			}
			
			if(user.getContactInfo().getHideXboxLiveFlag()){
				user.getContactInfo().setXboxLive(null);
			}
			
			if(user.getContactInfo().getHideNnidFlag()){
				user.getContactInfo().setNnid(null);
			}
			
			if(user.getContactInfo().getHidePsnFlag()){
				user.getContactInfo().setPsn(null);
			}
			
			if(user.getContactInfo().getHideGtalkFlag()){
				user.getContactInfo().setGtalk(null);
			}
			
			if(user.getSecurityInfo().getHideBirthDateFlag()){
				user.setBirthDate(null);
			}
			
			if(user.getHideEmailFlag()){
				user.getEmailAddress().setEmailAddress(null);
			}
		}
		
		return user;
		
	}

	public Users saveAccountSettings(Users accountSettings,Users zfgcUser) throws Exception {
		try{
			Users savedProfile = userProfileDataProvider.getUserProfile(accountSettings.getUsersId());

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
		EmailAddress email = new EmailAddress();
		email.setEmailAddress(profileView.getProfileSummary().getEmailAddress());
		user.setEmailAddress(email);
		
		user.setTimeOffset(profileView.getProfileSummary().getTimeOffset());
		
		user.getContactInfo().setAim(profileView.getProfileSummary().getAim());
		user.getContactInfo().setGtalk(profileView.getProfileSummary().getGtalk());
		user.getContactInfo().setNnid(profileView.getProfileSummary().getNnid());
		user.getContactInfo().setPsn(profileView.getProfileSummary().getPsn());
		user.getContactInfo().setSkype(profileView.getProfileSummary().getSkype());
		user.getContactInfo().setSteam(profileView.getProfileSummary().getSteam());
		user.getContactInfo().setXboxLive(profileView.getProfileSummary().getXboxLive());
		user.getContactInfo().setYim(profileView.getProfileSummary().getYim());
		
		user.getContactInfo().setHideAimFlag(profileView.getProfileSummary().getHideAimFlag());
		user.getContactInfo().setHideGtalkFlag(profileView.getProfileSummary().getHideGtalkFlag());
		user.getContactInfo().setHideNnidFlag(profileView.getProfileSummary().getHideNnidFlag());
		user.getContactInfo().setHidePsnFlag(profileView.getProfileSummary().getHidePsnFlag());
		user.getContactInfo().setHideSkypeFlag(profileView.getProfileSummary().getHideSkypeFlag());
		user.getContactInfo().setHideSteamFlag(profileView.getProfileSummary().getHideSteamFlag());
		user.getContactInfo().setHideXboxLiveFlag(profileView.getProfileSummary().getHideXboxLiveFlag());
		user.getContactInfo().setHideYimFlag(profileView.getProfileSummary().getHideYimFlag());
		
		user.getSecurityInfo().setHideBirthDateFlag(profileView.getProfileSummary().getHideBirthDateFlag());
		
		return user;
	}
}