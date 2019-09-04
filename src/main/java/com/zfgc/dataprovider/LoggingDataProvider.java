package com.zfgc.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.LoggingDao;
import com.zfgc.model.logging.ActivityLog;
import com.zfgc.util.time.ZfgcTimeUtils;

@Component
public class LoggingDataProvider{
	@Autowired
	LoggingDao loggingDao;
	
	public void logAction(Integer logType, String description, Integer usersId, String ipAddress) throws Exception{
		try{
			ActivityLog log = new ActivityLog();
			log.setLogTypeId(logType);
			log.setDescription(description);
			log.setUsersId(usersId);
			log.setIpAddress(ipAddress);
			log.setLogDate(ZfgcTimeUtils.getToday());
			loggingDao.updateOrInsert(log);
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
}