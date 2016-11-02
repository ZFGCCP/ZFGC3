package com.zfgc.services.lookups;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.LookupDao;
import com.zfgc.dao.UsersDao;
import com.zfgc.model.lookups.Lookup;

@Component
public class LookupService{
	@Autowired
	LookupDao lookupDao;
	
	Logger LOGGER = Logger.getLogger(LookupDao.class);
	private Map<String,List<Lookup>> lookups = new HashMap<>();
	
	public static final String TIMEZONE = "TIMEZONE";
	public static final String MEMBER_GROUP = "MEMBER_GROUP";
	public static final String LANGUAGE = "LANGUAGE";
	
	@PostConstruct
	public void loadLookups(){
		
		try {
			LOGGER.info("Loading lookups...");
			lookups.put(TIMEZONE, lookupDao.getLookup(TIMEZONE));
			lookups.put(MEMBER_GROUP, lookupDao.getLookup(MEMBER_GROUP));
			lookups.put(LANGUAGE, lookupDao.getLookup(LANGUAGE));
			LOGGER.info("Finished loading lookups.");
		} catch (Exception e) {
			LOGGER.error("Failed to load lookups due to exception.");
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public List<Lookup> getLookups(String lookupName){
		if(lookups.containsKey(lookupName)){
			return lookups.get(lookupName);
		}
		else{
			return null;
		}
	}
}