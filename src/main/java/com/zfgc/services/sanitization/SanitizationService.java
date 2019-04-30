package com.zfgc.services.sanitization;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.ibatis.annotations.Results;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.HtmlEntityDataProvider;
import com.zfgc.services.AbstractService;
import com.zfgc.services.bbcode.BbcodeService;

@Component
public class SanitizationService extends AbstractService {

	@Autowired
	HtmlEntityDataProvider htmlEntityDataProvider;
	
	private Map<String,String> entities = null;
	private Map<String,String> reverseEntities = null;
	
	private Logger LOGGER = LogManager.getLogger(SanitizationService.class);
	
	public String sanitizeMessage(String inputMessage){
		return transformMessage(inputMessage,entities);
	}
	
	public String reverseSanitizeMessage(String inputMessage){
		return transformMessage(inputMessage,reverseEntities);
	}
	
	private String transformMessage(String inputMessage, Map<String,String> sanitizeMap){
		if(inputMessage == null){
			return null;
		}
		
		String output = new String(inputMessage);
		
		for(String entity : sanitizeMap.keySet()){
			output = output.replaceAll(entity, sanitizeMap.get(entity));
		}
		
		return output;
	}
	
	private Map<String,String> createReverseEntityMap(Map<String,String> entities){
		Map<String,String> result = new HashMap<>();
		
		for(String entity : entities.keySet()){
			String x = entity;
			result.put(entities.get(entity),x);
		}
		
		return result;
	}
	
	@PostConstruct
	public void loadHtmlEntities(){
		LOGGER.info("Loading HTML entities for sanitization...");
		entities = htmlEntityDataProvider.getEntityMap();
		reverseEntities = createReverseEntityMap(entities);
		LOGGER.info("Finished loading HTML entities.");
	}
	
}
