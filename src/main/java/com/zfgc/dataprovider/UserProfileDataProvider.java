package com.zfgc.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.BrMemberGroupUserDao;
import com.zfgc.dao.EmailAddressDao;
import com.zfgc.dao.NotificationSettingsDao;
import com.zfgc.dao.PersonalMessagingSettingsDao;
import com.zfgc.dao.UserContactSettingsDao;
import com.zfgc.dao.UserPersonalInfoDao;
import com.zfgc.dao.UserProfileDao;
import com.zfgc.dao.UserSecuritySettingsDao;
import com.zfgc.dao.UsersDao;
import com.zfgc.dbobj.BrMemberGroupUserDbObjExample;
import com.zfgc.dbobj.UserProfileViewDbObj;
import com.zfgc.dbobj.UsersDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.avatar.Avatar;
import com.zfgc.model.bridge.BrMemberGroupUser;
import com.zfgc.model.lkup.LkupMemberGroup;
import com.zfgc.model.users.EmailAddress;
import com.zfgc.model.users.Hostname;
import com.zfgc.model.users.IpAddress;
import com.zfgc.model.users.NewPassword;
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
	UserSecuritySettingsDataProvider userSecuritySettingsDataProvider;
	
	@Autowired
	UserPersonalInfoDao userPersonalInfoDao;
	
	@Autowired
	NotificationSettingsDao notificationSettingsDao;
	
	@Autowired
	PersonalMessagingSettingsDao pmSettingsDao;
	
	@Autowired
	EmailAddressDao emailAddressDao;
	
	@Autowired
	BrMemberGroupUserDao brMemberGroupUserDao;
	
	@Autowired
	UsersDao usersDao;
	
	public UserProfileView getUserProfile(Integer userId) throws RuntimeException{
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
		result.setPrimaryMemberGroup(mapper.map(userProfileViewDbObj, LkupMemberGroup.class));
		result.setPrimaryIpAddress(mapper.map(userProfileViewDbObj, IpAddress.class));
		result.setPrimaryHostname(mapper.map(userProfileViewDbObj, Hostname.class));
		
		return result;
	}
	
	public void saveNotificationSettings(UserProfileView notificationSettings) throws RuntimeException{
		notificationSettingsDao.updateOrInsert(notificationSettings.getNotificationSettings());
	}
	
	public void saveAccountSettings(UserProfileView accountSettings) throws RuntimeException {
		//authenticationService.logEmailAddress(accountSettings.getEmailAddress());
		//create or update email address table
		emailAddressDao.updateOrInsert(accountSettings.getUserContactInfo().getEmail());
		
		userContactSettingsDao.updateOrInsert(accountSettings.getUserContactInfo());
		userSecuritySettingsDataProvider.saveSecuritySettings(accountSettings.getUserSecurityInfo());
		
		BrMemberGroupUserDbObjExample ex = brMemberGroupUserDao.getExample();
		brMemberGroupUserDao.deleteByExample(null, ex);
		
		for(LkupMemberGroup group : accountSettings.getSecondaryMemberGroups().getMemberGroups()){
			BrMemberGroupUser memberGroupUser = new BrMemberGroupUser();
			memberGroupUser.setMemberGroupId(group.getMemberGroupId());
			memberGroupUser.setUsersId(accountSettings.getUsersId());
			brMemberGroupUserDao.updateOrInsert(memberGroupUser);
		}
		
		Users user = new Users();
		user.setPrimaryMemberGroupId(accountSettings.getPrimaryMemberGroup().getMemberGroupId());
		UsersDbObjExample example = usersDao.getExample();
		ex.createCriteria().andUsersIdEqualTo(accountSettings.getUsersId());
		usersDao.updateByExample(user, example);
		
	}
	
	public void savePmSettings(UserProfileView pmSettings) throws Exception{
		pmSettingsDao.updateOrInsert(pmSettings.getPersonalMessagingSettings());
	}
	
	public void saveForumProfile(UserProfileView forumProfile) throws RuntimeException{
		userPersonalInfoDao.updateOrInsert(forumProfile.getPersonalInfo());
	}
	
	public void updateUserPassword(Users user, String password) throws RuntimeException{
		NewPassword newPassword = new NewPassword();
		newPassword.setUsersId(user.getUsersId());
		newPassword.setNewPassword(password);
		updateUserPassword(newPassword);
	}
	
	public void updateUserPassword(NewPassword password) throws RuntimeException{
		userSecuritySettingsDataProvider.updatePassword(password);
	}
}
