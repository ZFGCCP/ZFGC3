package com.zfgc.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.zfgc.services.logging.LoggingService;

public class AbstractService {
	@Autowired
	protected LoggingService loggingService;
}
