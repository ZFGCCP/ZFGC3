package com.zfgc.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.UserProfileDao;
import com.zfgc.dbobj.UserProfileViewDbObj;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.avatar.Avatar;
import com.zfgc.model.users.Users;
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
	NotificationsService notificationsService;
	
	public Users getUserProfile(Integer userId) throws Exception{
		UserProfileViewDbObj userProfileViewDbObj = null;
		try{
			userProfileViewDbObj = userProfileDao.getUserProfile(userId);
		}
		catch(ZfgcNotFoundException ex){
			throw new ZfgcNotFoundException(ex.getResourceName());
		}
		
		Users user = mapper.map(userProfileViewDbObj, Users.class);
		transformProfileAvatarData(user, userProfileViewDbObj);

		return user;
	}

	public void saveNotificationSettings(Users notificationSettings) throws Exception{
		notificationsService.saveNotificationSettings(notificationSettings.getNotificationSettings());
	}
	
	public void saveAccountSettings(Users accountSettings) throws Exception {
		authenticationService.logEmailAddress(accountSettings.getEmailAddress());
		userProfileDao.saveAccountSettings(accountSettings);
	}
	
	public void saveForumProfile(Users forumProfile) throws Exception{
		userProfileDao.saveAccountSettings(forumProfile);
	}
	
	private void transformProfileAvatarData(Users user, UserProfileViewDbObj profile){
		//todo: add constants for urls
		//if they have a gallery avatar, use that as the filename
		Avatar avatar = new Avatar();
		avatar.setAvatarTypeId(profile.getAvatarTypeId());
		avatar.setAvatarGalleryId(profile.getAvatarGalleryId());
		avatar.setAvatarId(profile.getAvatarId());

		//if they have a custom avatar uploaded elsewhere, use that as the filename
		if(profile.getAvatarTypeId() == 3 && profile.getAvatarUrl() != null){
			avatar.setAvatarFileName(profile.getAvatarUrl());
		}
		
		user.setAvatar(avatar);
	}
}
