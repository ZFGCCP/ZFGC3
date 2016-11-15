package com.zfgc.services.logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.LoggingDataProvider;

@Component
public class LoggingService {
	@Autowired
	LoggingDataProvider loggingDataProvider;
	
	public void logAction(Integer logType, String description, Integer usersId, String ipAddress) throws Exception{
		try{
			loggingDataProvider.logAction(logType, description, usersId, ipAddress);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
