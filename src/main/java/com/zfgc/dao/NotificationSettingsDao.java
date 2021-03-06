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
public class NotificationSettingsDao extends AbstractDao<NotificationSettingsDbObjExample, NotificationSettingsDbObj, NotificationSettings>{

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
	public List<NotificationSettingsDbObj> get(NotificationSettingsDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void hardDelete(NotificationSettings obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(NotificationSettings obj) throws RuntimeException {
		NotificationSettingsDbObj dbObj = mapper.map(obj, NotificationSettingsDbObj.class);
		if(dbObj.getNotificationSettingsId() == null || dbObj.getNotificationSettingsId() == -1){
			notificationSettingsDbObjMapper.insert(dbObj);
			obj.setNotificationSettingsId(dbObj.getNotificationSettingsId());
		}
		else{
			notificationSettingsDbObjMapper.updateByPrimaryKey(dbObj);
		}
	}

	@Override
	public void updateByExample(NotificationSettings obj,
			NotificationSettingsDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(NotificationSettings obj,
			NotificationSettingsDbObjExample ex) throws RuntimeException {
				return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long countByExample(NotificationSettings obj,
			NotificationSettingsDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}