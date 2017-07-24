package com.zfgc.dataprovider;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.HtmlEntityDao;
import com.zfgc.dbobj.HtmlEntityDbObj;
import com.zfgc.dbobj.HtmlEntityDbObjExample;

@Component
public class HtmlEntityDataProvider extends AbstractDataProvider {
	
	@Autowired
	HtmlEntityDao htmlEntityDao;
	
	public Map<String,String> getEntityMap(){
		Map<String,String> entities = new LinkedHashMap<>();
		HtmlEntityDbObjExample ex = new HtmlEntityDbObjExample();
		ex.setOrderByClause("HTML_ENTITY_ID ASC");
		
		List<HtmlEntityDbObj> dbObj = htmlEntityDao.get(ex);
		
		for(HtmlEntityDbObj entity : dbObj){
			entities.put(entity.getHtmlCharacter(), entity.getHtmlEntity());
		}
		
		return entities;
	}
}
