package com.zfgc.services.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.NotificationsDataProvider;
import com.zfgc.model.users.profile.NotificationSettings;
import com.zfgc.services.AbstractService;

@Component
public class NotificationsService extends AbstractService {
	@Autowired
	NotificationsDataProvider notificationsDataProvider;
	
	public void saveNotificationSettings(NotificationSettings notifSettings){
		notificationsDataProvider.saveNotificationSettings(notifSettings);
	}
}
