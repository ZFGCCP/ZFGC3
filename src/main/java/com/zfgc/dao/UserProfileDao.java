package com.zfgc.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.PersonalMessagingSettingsDbObj;
import com.zfgc.dbobj.UserProfileViewDbObj;
import com.zfgc.dbobj.UserProfileViewDbObjExample;
import com.zfgc.dbobj.UsersDbObj;
import com.zfgc.dbobj.UsersDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.mappers.PersonalMessagingSettingsDbObjMapper;
import com.zfgc.mappers.UserProfileViewDbObjMapper;
import com.zfgc.mappers.UsersDbObjMapper;
import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.UserProfileView;

@Component
public class UserProfileDao extends AbstractDao<UserProfileViewDbObjExample, UserProfileViewDbObj, UserProfileView> {
	@Autowired
	private UserProfileViewDbObjMapper userProfileViewDbObjMapper;
	
	@Autowired
	private UsersDbObjMapper usersDbObjMapper;
	
	@Autowired
	private PersonalMessagingSettingsDbObjMapper personalMessagingSettingsDbObjMapper;
	
	Logger LOGGER = Logger.getLogger(UserProfileDao.class);
	
	public UserProfileViewDbObj getUserProfile(Integer userId) throws Exception{
		UserProfileViewDbObjExample userProfileViewDbObjExample = super.getExample();
		userProfileViewDbObjExample.createCriteria().andUsersIdEqualTo(userId);
		List<UserProfileViewDbObj> userProfileViewDbObj = null;
		try{
			userProfileViewDbObj = userProfileViewDbObjMapper.selectByExample(userProfileViewDbObjExample);
		}
		catch(Exception ex){
			logDbSelectError(LOGGER,"USER_PROFILE_VIEW");
			throw new Exception(ex.getMessage());
		}
		
		if(userProfileViewDbObj == null || userProfileViewDbObj.size() == 0){
			LOGGER.error("Unable to find profile for userId " + userId);
			throw new ZfgcNotFoundException("User profile Id: " + userId);
		}
		
		return userProfileViewDbObj.get(0);
	}

	public void saveAccountSettings(Users accountSettings) {
		UsersDbObj dbObj = mapper.map(accountSettings, UsersDbObj.class);
		usersDbObjMapper.updateByPrimaryKeySelective(dbObj);
	}
	
	public void savePmSettings(Users pmSettings){
		PersonalMessagingSettingsDbObj dbObj = mapper.map(pmSettings.getPersonalMessagingSettings(), PersonalMessagingSettingsDbObj.class);
		personalMessagingSettingsDbObjMapper.updateByPrimaryKeySelective(dbObj);
	}

	@Override
	public List<UserProfileViewDbObj> get(UserProfileViewDbObjExample ex) throws ZfgcNotFoundException {
		List<UserProfileViewDbObj> db = userProfileViewDbObjMapper.selectByExample(ex);
		
		if(db.size() == 0){
			throw new ZfgcNotFoundException("User profile could not be found");
		}
		
		return db;
	}

	@Override
	public void hardDelete(UserProfileView obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(UserProfileView obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(UserProfileView obj,
			UserProfileViewDbObjExample ex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(UserProfileView obj,
			UserProfileViewDbObjExample ex) {
				return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer countByExample(UserProfileView obj,
			UserProfileViewDbObjExample ex) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
