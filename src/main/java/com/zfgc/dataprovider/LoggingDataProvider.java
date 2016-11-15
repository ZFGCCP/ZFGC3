package com.zfgc.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.LoggingDao;

@Component
public class LoggingDataProvider{
	@Autowired
	LoggingDao loggingDao;
	
	public void logAction(Integer logType, String description, Integer usersId, String ipAddress) throws Exception{
		try{
			loggingDao.logAction(logType, description, usersId, ipAddress);
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
}