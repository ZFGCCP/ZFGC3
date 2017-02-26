package com.zfgc.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.NotificationSettingsDao;
import com.zfgc.model.users.profile.NotificationSettings;

@Component
public class NotificationsDataProvider{
	@Autowired
	NotificationSettingsDao notificationSettingsDao;
	
	public void saveNotificationSettings(NotificationSettings notifSettings){
		notificationSettingsDao.updateNotificationSettings(notifSettings);
	}
}