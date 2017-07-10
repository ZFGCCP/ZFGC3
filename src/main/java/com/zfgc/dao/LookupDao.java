package com.zfgc.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.lookups.Lookup;

@Component
public class LookupDao extends AbstractDao<Object,Object,Object>{
	
	Logger LOGGER = Logger.getLogger(LookupDao.class);
	
	public List<Lookup> getLookup(String lookupName) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT LKUP_ID AS ID, LKUP_DESC AS VALUE \n")
		   .append("FROM LKUP_ALL_VIEW \n")
		   .append("WHERE LKUP_NAME = :lookupName");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("lookupName",lookupName);
		
		try{
			List<Lookup> lookups = jdbcTemplate.query(sql.toString(), params, new BeanPropertyRowMapper(Lookup.class));
			if(lookups == null || lookups.size() == 0){
				throw new Exception("Lookup " + lookupName + " returned zero results.");
			}
			
			LOGGER.info("Loaded lookup " + lookupName);
			return lookups;
		}
		catch(Exception ex){
			LOGGER.error("Error getting lookups for " + lookupName);
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	public List<Object> get(Object ex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void hardDelete(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(Object obj, Object ex) {
		// TODO Auto-generated method stub
		
	}

	
}