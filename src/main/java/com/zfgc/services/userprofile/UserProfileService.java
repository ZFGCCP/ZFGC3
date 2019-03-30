package com.zfgc.services.userprofile;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.constants.user.UserConstants;
import com.zfgc.dataprovider.LkupMemberGroupDataProvider;
import com.zfgc.dataprovider.UserProfileDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.exception.security.ZfgcUnauthorizedException;
import com.zfgc.model.lkup.LkupMemberGroup;
import com.zfgc.model.users.EmailAddress;
import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.NavTab;
import com.zfgc.model.users.profile.ProfileSummary;
import com.zfgc.model.users.profile.UserProfileView;
import com.zfgc.requiredfields.users.AccountSettingsRequiredFieldsChecker;
import com.zfgc.requiredfields.users.ProfileRequiredFieldsChecker;
import com.zfgc.rules.Rule;
import com.zfgc.rules.users.AccountSettingsRuleChecker;
import com.zfgc.rules.users.ProfileRuleChecker;
import com.zfgc.services.AbstractService;
import com.zfgc.services.RuleRunService;
import com.zfgc.services.avatar.AvatarService;
import com.zfgc.services.bbcode.BbcodeService;
import com.zfgc.services.buddies.BuddyService;
import com.zfgc.services.lookups.LookupService;
import com.zfgc.services.sanitization.SanitizationService;
import com.zfgc.services.users.MemberGroupService;
import com.zfgc.util.security.ZfgcSecurityUtils;
import com.zfgc.validation.uservalidation.AccountSettingsValidator;
import com.zfgc.validation.uservalidation.ProfileValidator;

@Component
public class UserProfileService extends AbstractService{
	@Autowired
	UserProfileDataProvider userProfileDataProvider;
	
	@Autowired
	LkupMemberGroupDataProvider lkupMemberGroupDataProvider;
	
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
	
	@Autowired
	MemberGroupService memberGroupService;
	
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
		
		//get buddy and ignore list
		//user.getPersonalMessagingSettings().setBuddyList(buddyService.getBuddies(userId));
		//user.getPersonalMessagingSettings().setIgnoreList(buddyService.getIgnores(userId));
		
		Integer currentUserId = zfgcUser.getUsersId();
		//user.setTimeOffsetLkup(lookupService.getLkupValue(lookupService.TIMEZONE, user.getTimeOffset()));
		
		//permissions
		profileView.setSecondaryMemberGroups(memberGroupService.getSecondaryMemberGroups(userId));
		
		//if you're not the owner if this profile, and you're not an admin
		if(currentUserId == null || (!currentUserId.equals(userId) && 
			!zfgcUser.isAccountSettingsEditorOrAdmin())){
			
			//vm.profile.primaryIpAddress.ipAddress
			
			profileView.setPrimaryIpAddress(null);
			
			//hide contact fields with the hidden flag
			if(profileView.getUserSecurityInfo().getHideSkypeFlag()){
				profileView.getUserContactInfo().setSkype(null);
			}
			
			if(profileView.getUserSecurityInfo().getHideSteamFlag()){
				profileView.getUserContactInfo().setSteam(null);
			}
			
			if(profileView.getUserSecurityInfo().getHideXboxLiveFlag()){
				profileView.getUserContactInfo().setXboxLive(null);
			}
			
			if(profileView.getUserSecurityInfo().getHideNnidFlag()){
				profileView.getUserContactInfo().setNnid(null);
			}
			
			if(profileView.getUserSecurityInfo().getHidePsnFlag()){
				profileView.getUserContactInfo().setPsn(null);
			}
			
			if(profileView.getUserSecurityInfo().getHideGtalkFlag()){
				profileView.getUserContactInfo().setGtalk(null);
			}
			
			if(profileView.getUserSecurityInfo().getHideBirthDateFlag()){
				profileView.getPersonalInfo().setBirthDate(null);
			}
			
			if(profileView.getUserSecurityInfo().getHideEmailFlag()){
				profileView.getUserContactInfo().setEmail(null);
			}
		}
		else {
			//get buddy and ignore list
			profileView.setBuddyList(buddyService.getBuddies(userId));
		}
		
		if(profileView.getProfileSummary().getSignature() != null){
			profileView.getProfileSummary().setSignaturePreview(bbCodeService.parseText(profileView.getPersonalInfo().getSignature()));
			profileView.getPersonalInfo().setSignature(sanitizationService.reverseSanitizeMessage(profileView.getPersonalInfo().getSignature()));
		}
		
		return profileView;
		
	}

	@Transactional
	public Users saveAccountSettings(Users accountSettings,Users zfgcUser) throws Exception {
		if(!ZfgcSecurityUtils.checkUserAuthorizationProfileEditor(accountSettings.getUsersId(), zfgcUser)){
			throw new ZfgcUnauthorizedException();
		}
		
		UserProfileView savedUser = this.getProfile(accountSettings.getUsersId(), zfgcUser);
		
		ruleRunner.runRules(accountSettingsValidator, accountSettingsRequiredFieldsChecker, accountSettingsRuleChecker, accountSettings, zfgcUser);
		
		//make sure username, birthdate and date registered were not changed (unless user is part of the moderation staff)
		if(!zfgcUser.isModerationStaff()){
			if(!accountSettings.getLoginName().equals(savedUser.getLoginName())){
				Rule changedUsername = new Rule();
				changedUsername.setRuleName("CHANGED_USERNAME");
				changedUsername.setErrorMessage("You do not have permission to change a user's username");
				accountSettings.getErrors().getRuleErrors().add(changedUsername);
			}
			
			if(!accountSettings.getPersonalInfo().getBirthDate().equals(savedUser.getPersonalInfo().getBirthDate())){
				Rule changedBirthDt = new Rule();
				changedBirthDt.setRuleName("CHANGED_BIRTHDT");
				changedBirthDt.setErrorMessage("You do not have permission to change a user's birth date");
				accountSettings.getErrors().getRuleErrors().add(changedBirthDt);
			}
			
			if(!accountSettings.getDateRegistered().equals(savedUser.getDateRegistered())){
				Rule changedRegDt = new Rule();
				changedRegDt.setRuleName("CHANGED_REGDT");
				changedRegDt.setErrorMessage("You do not have permission to change a user's registration date");
				accountSettings.getErrors().getRuleErrors().add(changedRegDt);
			}
			
			if(accountSettings.getErrors().hasErrors()){
				throw new ZfgcValidationException(accountSettings.getClass().getName());
			}
		}
		
		//make sure member groups were not changed (unless user is an admin)
		if(!zfgcUser.isAdministrationStaff()){
			if(!accountSettings.getPrimaryMemberGroupId().equals(savedUser.getPrimaryMemberGroup())){
				Rule changedRegDt = new Rule();
				changedRegDt.setRuleName("CHANGED_PRIM_MEMBER_GROUP");
				changedRegDt.setErrorMessage("You do not have permission to change a user's primary member group");
				accountSettings.getErrors().getRuleErrors().add(changedRegDt);
			}
			
			boolean groupChanged = false;
			
			if(accountSettings.getSecondaryMemberGroups().getMemberGroups().size() == savedUser.getSecondaryMemberGroups().getMemberGroups().size()){
				//check each group - if the order is different, something was changed
				for(LkupMemberGroup group : accountSettings.getSecondaryMemberGroups().getMemberGroups()){
					for(LkupMemberGroup savedGroup : savedUser.getSecondaryMemberGroups().getMemberGroups()){
						if(!group.getMemberGroupId().equals(savedGroup.getMemberGroupId())){
							groupChanged = true;
							break;
						}
					}
					
					if(groupChanged){
						break;
					}
				}
			}
			else{
				groupChanged = true;
			}
			
			if(groupChanged){
				Rule changedRegDt = new Rule();
				changedRegDt.setRuleName("CHANGED_SEC_MEMBER_GROUP");
				changedRegDt.setErrorMessage("You do not have permission to change a user's secondary member groups");
				accountSettings.getErrors().getRuleErrors().add(changedRegDt);
			}
			
			if(accountSettings.getErrors().hasErrors()){
				throw new ZfgcValidationException(accountSettings.getClass().getName());
			}
		}
		
		userProfileDataProvider.saveAccountSettings(accountSettings);
		
		if(!StringUtils.isEmpty(accountSettings.getUserSecurityInfo().getNewPassword())){
			userProfileDataProvider.updateUserPassword(zfgcUser, accountSettings.getUserSecurityInfo().getNewPassword());
		}
		return accountSettings;
	}
	
	@Transactional
	public Users saveNotificationSettings(Users notificationSettings, Users zfgcUser) throws Exception{
		if(!ZfgcSecurityUtils.checkUserAuthorizationProfileEditor(notificationSettings.getUsersId(), zfgcUser)){
			throw new ZfgcUnauthorizedException();
		}
		
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
	
	@Transactional
	public Users savePmSettings(Users pmSettings, Users zfgcUser) throws Exception{
		if(!ZfgcSecurityUtils.checkUserAuthorizationProfileEditor(pmSettings.getUsersId(), zfgcUser)){
			throw new ZfgcUnauthorizedException();
		}
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
	public Users saveBuddyIgnoreList(Users buddyIgnore, Users zfgcUser) throws Exception{
		if(!ZfgcSecurityUtils.checkUserAuthorizationProfileEditor(buddyIgnore.getUsersId(), zfgcUser)){
			throw new ZfgcUnauthorizedException();
		}
		
		//save buddy and ignore list
		buddyService.deleteBuddies(buddyIgnore.getUsersId());
		buddyService.saveBuddies(buddyIgnore.getUsersId(), buddyIgnore.getBuddyList(), zfgcUser);
		
		return buddyIgnore;
	}
	
	@Transactional
	public Users saveForumProfile(Users forumProfile, Users zfgcUser) throws Exception{
		if(!ZfgcSecurityUtils.checkUserAuthorizationProfileEditor(forumProfile.getUsersId(), zfgcUser)){
			throw new ZfgcUnauthorizedException();
		}
		
		ruleRunner.runRules(profileValidator, profileRequiredFieldsChecker, profileRuleChecker, forumProfile, zfgcUser);
		forumProfile.getPersonalInfo().setSignature(sanitizationService.sanitizeMessage(forumProfile.getPersonalInfo().getSignature()));
		
		//avatar logic
		avatarService.createAvatarRecordFromExternal(forumProfile.getPersonalInfo().getAvatar());
		
		userProfileDataProvider.saveForumProfile(forumProfile);
		
		return forumProfile;
	}
}
