package com.zfgc.dataprovider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.PersonalMessagingSettingsDao;
import com.zfgc.dbobj.PersonalMessagingSettingsDbObj;
import com.zfgc.dbobj.PersonalMessagingSettingsDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.users.profile.PersonalMessagingSettings;

@Component
public class PersonalMessagingSettingsDataProvider extends AbstractDataProvider {
	
	@Autowired
	private PersonalMessagingSettingsDao pmSettingsDao;
	
	public PersonalMessagingSettings getPmSettings(Integer usersId) {
		PersonalMessagingSettingsDbObjExample ex = pmSettingsDao.getExample();
		ex.createCriteria().andUsersIdEqualTo(usersId);
		
		List<PersonalMessagingSettingsDbObj> dbObj = pmSettingsDao.get(ex);
		if(dbObj.size() > 0) {
			return mapper.map(dbObj.get(0), PersonalMessagingSettings.class);
		}
		
		throw new ZfgcNotFoundException("UsersId" + usersId);
	}
	
}