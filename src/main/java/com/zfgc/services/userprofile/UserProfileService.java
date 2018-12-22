package com.zfgc.services.userprofile;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.constants.user.UserConstants;
import com.zfgc.dataprovider.UserProfileDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.model.users.EmailAddress;
import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.NavTab;
import com.zfgc.model.users.profile.ProfileSummary;
import com.zfgc.model.users.profile.UserProfileView;
import com.zfgc.requiredfields.users.AccountSettingsRequiredFieldsChecker;
import com.zfgc.requiredfields.users.ProfileRequiredFieldsChecker;
import com.zfgc.rules.users.AccountSettingsRuleChecker;
import com.zfgc.rules.users.ProfileRuleChecker;
import com.zfgc.services.AbstractService;
import com.zfgc.services.RuleRunService;
import com.zfgc.services.avatar.AvatarService;
import com.zfgc.services.bbcode.BbcodeService;
import com.zfgc.services.buddies.BuddyService;
import com.zfgc.services.lookups.LookupService;
import com.zfgc.services.sanitization.SanitizationService;
import com.zfgc.validation.uservalidation.AccountSettingsValidator;
import com.zfgc.validation.uservalidation.ProfileValidator;

@Component
public class UserProfileService extends AbstractService{
	@Autowired
	UserProfileDataProvider userProfileDataProvider;
	
	@Autowired
	NavTabService navTabService;
	
	@Autowired
	AccountSettingsRuleChecker accountSettingsRuleChecker;
	
	@Autowired
	AccountSettingsRequiredFieldsChecker accountSettingsRequiredFieldsChecker;
	
	@Autowired
	AccountSettingsValidator accountSettingsValidator;
	
	@Autowired
	BuddyService buddyService;
	
	@Autowired
	AvatarService avatarService;
	
	@Autowired
	SanitizationService sanitizationService;
	
	@Autowired
	BbcodeService bbCodeService;
	
	@Autowired
	ProfileValidator profileValidator;
	
	@Autowired
	ProfileRequiredFieldsChecker profileRequiredFieldsChecker;
	
	@Autowired
	ProfileRuleChecker profileRuleChecker;
	
	@Autowired
	RuleRunService<Users> ruleRunner;
	
	public List<NavTab> getProfileNavTabs(Users user, Integer usersId){
		return navTabService.getUserProfileNavTabs(user, usersId);
	}
	
	public UserProfileView getProfile(Integer userId, Users zfgcUser) throws Exception{
		UserProfileView profileView = null;
		Users user = null;
		try{
			profileView = userProfileDataProvider.getUserProfile(userId);
		}
		catch(ZfgcNotFoundException ex){
			throw new ZfgcNotFoundException(ex.getResourceName());
		}

		//get buddy and ignore list
		//user.getPersonalMessagingSettings().setBuddyList(buddyService.getBuddies(userId));
		//user.getPersonalMessagingSettings().setIgnoreList(buddyService.getIgnores(userId));
		
		Integer currentUserId = zfgcUser.getUsersId();
		//user.setTimeOffsetLkup(lookupService.getLkupValue(lookupService.TIMEZONE, user.getTimeOffset()));
		
		//permissions
		
		//if you're not the owner if this profile, and you're not an admin
		if(currentUserId == null || (!currentUserId.equals(userId) && 
			!lookupService.getLkupValue(LookupService.MEMBER_GROUP,zfgcUser.getPrimaryMemberGroupId()).equals("Manager"))){
			
			user.setPrimaryIpAddress(null);
			
			//hide contact fields with the hidden flag
			if(user.getUserSecurityInfo().getHideSkypeFlag()){
				user.getUserContactInfo().setSkype(null);
			}
			
			if(user.getUserSecurityInfo().getHideSteamFlag()){
				user.getUserContactInfo().setSteam(null);
			}
			
			if(user.getUserSecurityInfo().getHideXboxLiveFlag()){
				user.getUserContactInfo().setXboxLive(null);
			}
			
			if(user.getUserSecurityInfo().getHideNnidFlag()){
				user.getUserContactInfo().setNnid(null);
			}
			
			if(user.getUserSecurityInfo().getHidePsnFlag()){
				user.getUserContactInfo().setPsn(null);
			}
			
			if(user.getUserSecurityInfo().getHideGtalkFlag()){
				user.getUserContactInfo().setGtalk(null);
			}
			
			if(user.getUserSecurityInfo().getHideBirthDateFlag()){
				user.setBirthDate(null);
			}
			
			if(user.getHideEmailFlag()){
				user.getEmailAddress().setEmailAddress(null);
			}
		}
		
		if(profileView.getProfileSummary().getSignature() != null){
			profileView.getProfileSummary().setSignaturePreview(bbCodeService.parseText(profileView.getPersonalInfo().getSignature()));
			profileView.getPersonalInfo().setSignature(sanitizationService.reverseSanitizeMessage(profileView.getPersonalInfo().getSignature()));
		}
		
		return profileView;
		
	}

	public Users saveAccountSettings(Users accountSettings,Users zfgcUser) throws Exception {
		ruleRunner.runRules(accountSettingsValidator, accountSettingsRequiredFieldsChecker, accountSettingsRuleChecker, accountSettings, zfgcUser);
		
		userProfileDataProvider.saveAccountSettings(accountSettings);
		
		if(!StringUtils.isEmpty(accountSettings.getUserSecurityInfo().getNewPassword())){
			userProfileDataProvider.updateUserPassword(zfgcUser, accountSettings.getUserSecurityInfo().getNewPassword());
		}
		return accountSettings;
	}
	
	public Users saveNotificationSettings(Users notificationSettings, Users zfgcUser) throws Exception{
		try{
			userProfileDataProvider.saveNotificationSettings(notificationSettings);
		}
		catch(ZfgcNotFoundException ex){
			throw new ZfgcNotFoundException(ex.getMessage());
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
		
		return notificationSettings;
	}
	
	public Users saveBuddyIgnoreList(Users buddyIgnore, Users zfgcUser) throws Exception{
		buddyService.saveBuddies(buddyIgnore.getUsersId(), buddyIgnore.getPersonalMessagingSettings().getBuddyList());
		buddyService.saveBuddies(buddyIgnore.getUsersId(), buddyIgnore.getPersonalMessagingSettings().getIgnoreList());
		
		return buddyIgnore;
	}
	
	public Users savePmSettings(Users pmSettings, Users zfgcUser) throws Exception{
		try{
			userProfileDataProvider.savePmSettings(pmSettings);
		}
		catch(ZfgcNotFoundException ex){
			throw new ZfgcNotFoundException(ex.getMessage());
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
		
		return pmSettings;
	}
	
	@Transactional
	public Users saveForumProfile(Users forumProfile, Users zfgcUser) throws Exception{
		ruleRunner.runRules(profileValidator, profileRequiredFieldsChecker, profileRuleChecker, forumProfile, zfgcUser);
		forumProfile.getPersonalInfo().setSignature(sanitizationService.sanitizeMessage(forumProfile.getPersonalInfo().getSignature()));
		
		//avatar logic
		avatarService.createAvatarRecordFromExternal(forumProfile.getPersonalInfo().getAvatar());
		
		userProfileDataProvider.saveForumProfile(forumProfile);
		
		return forumProfile;
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
		
		user.getUserContactInfo().setGtalk(profileView.getProfileSummary().getGtalk());
		user.getUserContactInfo().setNnid(profileView.getProfileSummary().getNnid());
		user.getUserContactInfo().setPsn(profileView.getProfileSummary().getPsn());
		user.getUserContactInfo().setSkype(profileView.getProfileSummary().getSkype());
		user.getUserContactInfo().setSteam(profileView.getProfileSummary().getSteam());
		user.getUserContactInfo().setXboxLive(profileView.getProfileSummary().getXboxLive());
		
		user.getUserSecurityInfo().setHideGtalkFlag(profileView.getProfileSummary().getHideGtalkFlag());
		user.getUserSecurityInfo().setHideNnidFlag(profileView.getProfileSummary().getHideNnidFlag());
		user.getUserSecurityInfo().setHidePsnFlag(profileView.getProfileSummary().getHidePsnFlag());
		user.getUserSecurityInfo().setHideSkypeFlag(profileView.getProfileSummary().getHideSkypeFlag());
		user.getUserSecurityInfo().setHideSteamFlag(profileView.getProfileSummary().getHideSteamFlag());
		user.getUserSecurityInfo().setHideXboxLiveFlag(profileView.getProfileSummary().getHideXboxLiveFlag());
		
		user.getUserSecurityInfo().setHideBirthDateFlag(profileView.getProfileSummary().getHideBirthDateFlag());
		
		return user;
	}
}
