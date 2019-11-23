package com.zfgc.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.UserSecuritySettingsDao;
import com.zfgc.model.users.NewPassword;
import com.zfgc.model.users.UserSecurityInfo;

@Component
public class UserSecuritySettingsDataProvider extends AbstractDataProvider {
	
	@Autowired
	UserSecuritySettingsDao userSecuritySettingsDao;
	
	public void saveSecuritySettings(UserSecurityInfo securitySettings) {
		userSecuritySettingsDao.updateOrInsert(securitySettings);
	}
	
	public void updatePassword(NewPassword newPassword) {
		userSecuritySettingsDao.updateUserPassword(newPassword.getUsersId(), newPassword.getNewPassword());
	}
	
}