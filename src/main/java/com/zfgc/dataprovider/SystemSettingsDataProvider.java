package com.zfgc.dataprovider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.SystemSettingsDao;
import com.zfgc.dbobj.SystemSettingsDbObj;
import com.zfgc.dbobj.SystemSettingsDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.system.SystemSettings;

@Component
public class SystemSettingsDataProvider extends AbstractDataProvider {
	
	@Autowired
	private SystemSettingsDao systemSettingsDao; 
	
	public String getSystemValue(String settingName) {
		SystemSettingsDbObjExample ex = systemSettingsDao.getExample();
		ex.createCriteria().andCodeEqualTo(settingName);
		
		List<SystemSettingsDbObj> dbObj = systemSettingsDao.get(ex);
		
		if(dbObj.size() > 0) {
			return mapper.map(dbObj.get(0), SystemSettings.class).getValue();
		}
		else {
			throw new ZfgcNotFoundException("The system value " + settingName + " was not found.");
		}
	}
	
}