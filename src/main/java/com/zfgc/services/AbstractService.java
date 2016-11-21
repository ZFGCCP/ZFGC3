package com.zfgc.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.zfgc.services.logging.LoggingService;
import com.zfgc.services.lookups.LookupService;

public class AbstractService {
	@Autowired
	protected LoggingService loggingService;
	
	@Autowired 
	protected LookupService lookupService;
}
