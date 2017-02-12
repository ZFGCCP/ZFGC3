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
	public static final String LOG_TYPE = "LOG_TYPE";
	public static final String THREAD_STATUS = "THREAD_STATUS";
	public static final String POST_ICON = "POST_ICON";
	public static final String AVATAR_GALLERY = "AVATAR_GALLERY";
	public static final String AVATAR_TYPE = "AVATAR_TYPE";
	public static final String GENDER = "GENDER";
	
	@PostConstruct
	public void loadLookups(){
		
		try {
			LOGGER.info("Loading lookups...");
			lookups.put(TIMEZONE, lookupDao.getLookup(TIMEZONE));
			lookups.put(MEMBER_GROUP, lookupDao.getLookup(MEMBER_GROUP));
			lookups.put(LANGUAGE, lookupDao.getLookup(LANGUAGE));
			lookups.put(LOG_TYPE, lookupDao.getLookup(LOG_TYPE));
			lookups.put(THREAD_STATUS, lookupDao.getLookup(THREAD_STATUS));
			lookups.put(POST_ICON, lookupDao.getLookup(POST_ICON));
			lookups.put(AVATAR_GALLERY, lookupDao.getLookup(AVATAR_GALLERY));
			lookups.put(AVATAR_TYPE, lookupDao.getLookup(AVATAR_TYPE));
			lookups.put(GENDER, lookupDao.getLookup(GENDER));
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
	
	public String getLkupValue(String lookupName, Integer id){
		if(id != null){
			if(lookups.containsKey(lookupName)){
				for(Lookup lkup : lookups.get(lookupName)){
					if(lkup.getId().equals(id)){
						return lkup.getValue();
					}
				}
			}
		}

		return null;
	}
	
	public Boolean isLkupIdValid(String lookupName, Integer id){
		return getLkupValue(lookupName, id) != null;
	}
}