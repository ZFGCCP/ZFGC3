package com.zfgc.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.EmailAddressDao;
import com.zfgc.dao.NotificationSettingsDao;
import com.zfgc.dao.PersonalMessagingSettingsDao;
import com.zfgc.dao.UserContactSettingsDao;
import com.zfgc.dao.UserPersonalInfoDao;
import com.zfgc.dao.UserProfileDao;
import com.zfgc.dao.UserSecuritySettingsDao;
import com.zfgc.dbobj.UserProfileViewDbObj;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.avatar.Avatar;
import com.zfgc.model.users.EmailAddress;
import com.zfgc.model.users.UserContactInfo;
import com.zfgc.model.users.UserSecurityInfo;
import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.NotificationSettings;
import com.zfgc.model.users.profile.PersonalInfo;
import com.zfgc.model.users.profile.PersonalMessagingSettings;
import com.zfgc.model.users.profile.ProfileSummary;
import com.zfgc.model.users.profile.UserProfileView;
import com.zfgc.services.authentication.AuthenticationService;
import com.zfgc.services.notifications.NotificationsService;

@Component
public class UserProfileDataProvider extends AbstractDataProvider {
	@Autowired
	UserProfileDao userProfileDao;
	
	@Autowired
	AuthenticationService authenticationService;
	
	@Autowired
	UserContactSettingsDao userContactSettingsDao;
	
	@Autowired
	UserSecuritySettingsDao userSecuritySettingsDao;
	
	@Autowired
	UserPersonalInfoDao userPersonalInfoDao;
	
	@Autowired
	NotificationSettingsDao notificationSettingsDao;
	
	@Autowired
	PersonalMessagingSettingsDao pmSettingsDao;
	
	@Autowired
	EmailAddressDao emailAddressDao;
	
	public UserProfileView getUserProfile(Integer userId) throws Exception{
		UserProfileViewDbObj userProfileViewDbObj = null;
		try{
			userProfileViewDbObj = userProfileDao.getUserProfile(userId);
		}
		catch(ZfgcNotFoundException ex){
			throw new ZfgcNotFoundException(ex.getResourceName());
		}
		
		UserProfileView result = mapUserProfile(userProfileViewDbObj);
		//transformProfileAvatarData(user, userProfileViewDbObj);

		return result;
	}
	
	public UserProfileView mapUserProfile(UserProfileViewDbObj userProfileViewDbObj){
		UserProfileView result = mapper.map(userProfileViewDbObj, UserProfileView.class);
		result.setProfileSummary(mapper.map(userProfileViewDbObj, ProfileSummary.class));
		result.setUserContactInfo(mapper.map(userProfileViewDbObj,UserContactInfo.class));
		result.getUserContactInfo().setEmail(mapper.map(userProfileViewDbObj, EmailAddress.class));
		result.setUserSecurityInfo(mapper.map(userProfileViewDbObj, UserSecurityInfo.class));
		result.setPersonalInfo(mapper.map(userProfileViewDbObj, PersonalInfo.class));
		result.getPersonalInfo().setAvatar(mapper.map(userProfileViewDbObj, Avatar.class));
		result.setNotificationSettings(mapper.map(userProfileViewDbObj,NotificationSettings.class));
		result.setPersonalMessagingSettings(mapper.map(userProfileViewDbObj, PersonalMessagingSettings.class));
		
		return result;
	}
	
	public void saveNotificationSettings(Users notificationSettings) throws Exception{
		notificationSettingsDao.updateOrInsert(notificationSettings.getNotificationSettings());
	}
	
	public void saveAccountSettings(Users accountSettings) throws Exception {
		//authenticationService.logEmailAddress(accountSettings.getEmailAddress());
		//create or update email address table
		emailAddressDao.updateOrInsert(accountSettings.getUserContactInfo().getEmail());
		
		userContactSettingsDao.updateOrInsert(accountSettings.getUserContactInfo());
		userSecuritySettingsDao.updateOrInsert(accountSettings.getUserSecurityInfo());
	}
	
	private void updateEmailAddress(Integer usersId, String email) throws Exception {
		
	}
	
	public void savePmSettings(Users pmSettings) throws Exception{
		pmSettingsDao.updateOrInsert(pmSettings.getPersonalMessagingSettings());
	}
	
	public void saveForumProfile(Users forumProfile) throws Exception{
		userPersonalInfoDao.updateOrInsert(forumProfile.getPersonalInfo());
	}
	
	public void updateUserPassword(Users user, String password) throws Exception{
		userSecuritySettingsDao.updateUserPassword(user.getUsersId(), password);
	}
	
	private void transformProfileAvatarData(Users user, UserProfileViewDbObj profile){
		//todo: add constants for urls
		//if they have a gallery avatar, use that as the filename
		/*Avatar avatar = new Avatar();
		avatar.setAvatarTypeId(profile.getAvatarTypeId());
		avatar.setAvatarGalleryId(profile.getAvatarGalleryId());
		avatar.setAvatarId(profile.getAvatarId());

		//if they have a custom avatar uploaded elsewhere, use that as the filename
		if(profile.getAvatarTypeId() == 3 && profile.getAvatarUrl() != null){
			avatar.setAvatarFileName(profile.getAvatarUrl());
		}
		
		user.setAvatar(avatar);*/
	}
}
