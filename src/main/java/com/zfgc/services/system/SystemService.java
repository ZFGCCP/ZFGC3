package com.zfgc.services.system;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.SystemSettingsDataProvider;
import com.zfgc.services.AbstractService;
import com.zfgc.services.lookups.LookupService;

@Component
public class SystemService extends AbstractService{

	@Autowired
	private LookupService lookups;
	
	@Autowired
	private SystemSettingsDataProvider systemSettingsDataProvider;
	
	public static String TIME_ZONE = "";
	public static String AVATAR_DIRECTORY = "";
	
	@PostConstruct
	public void initializeSystemSettings() {
		TIME_ZONE = lookups.getLkupValue("TIMEZONE", Integer.parseInt(systemSettingsDataProvider.getSystemValue("TIME_ZONE")));
		AVATAR_DIRECTORY = systemSettingsDataProvider.getSystemDirectory("AVAGAL");
	}
	
}
