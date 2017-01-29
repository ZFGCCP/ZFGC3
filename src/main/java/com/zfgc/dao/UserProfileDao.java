package com.zfgc.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.UserProfileViewDbObj;
import com.zfgc.dbobj.UserProfileViewDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.mappers.UserProfileViewDbObjMapper;
import com.zfgc.model.users.profile.UserProfileView;

@Component
public class UserProfileDao extends AbstractDao<UserProfileView> {
	@Autowired
	private UserProfileViewDbObjMapper userProfileViewDbObjMapper;
	
	Logger LOGGER = Logger.getLogger(UserProfileDao.class);
	
	public UserProfileViewDbObj getUserProfile(Integer userId) throws Exception{
		UserProfileViewDbObjExample userProfileViewDbObjExample = new UserProfileViewDbObjExample();
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

	@Override
	public Boolean validateIntegrity(UserProfileView model) {
		// TODO Auto-generated method stub
		return null;
	}
}
