package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.NotificationSettingsDbObj;
import com.zfgc.dbobj.NotificationSettingsDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.mappers.NotificationSettingsDbObjMapper;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.profile.NotificationSettings;

@Component
public class NotificationSettingsDao extends AbstractDao<NotificationSettings>{

	@Autowired
	private NotificationSettingsDbObjMapper notificationSettingsDbObjMapper;
	
	public void updateNotificationSettings(NotificationSettings notifSettings){
		NotificationSettingsDbObj dbObj = mapper.map(notifSettings,NotificationSettingsDbObj.class);
		notificationSettingsDbObjMapper.updateByPrimaryKeySelective(dbObj);
	}
	
	public NotificationSettingsDbObj insertNotificationSettings(NotificationSettings notifSettings){
		NotificationSettingsDbObj dbObj = mapper.map(notifSettings,NotificationSettingsDbObj.class);
		notificationSettingsDbObjMapper.insert(dbObj);
		
		return dbObj;
	}
	
	public NotificationSettingsDbObj getNotificationSettingsByUserId(Integer usersId) throws ZfgcNotFoundException{
		NotificationSettingsDbObjExample example = new NotificationSettingsDbObjExample();
		example.createCriteria().andUsersIdEqualTo(usersId);
		
		List<NotificationSettingsDbObj> dbObj = notificationSettingsDbObjMapper.selectByExample(example);
		
		if(dbObj == null || dbObj.size() == 0){
			throw new ZfgcNotFoundException("Notification Settings For user" + usersId);
		}
		
		return dbObj.get(0);
	}

	@Override
	public Boolean validateIntegrity(NotificationSettings model) {
		// TODO Auto-generated method stub
		return null;
	}
	
}