package com.zfgc.dao;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.zfgc.model.BaseZfgcModel;

public abstract class AbstractDao<T extends BaseZfgcModel>{
	@Autowired
	protected NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	DozerBeanMapper mapper;
	
	protected void get(){

	}
	
	protected void logDbInsertError(Logger LOGGER, String tableName){
		LOGGER.error("Error inserting into " + tableName);
	}
	
	protected void logDbSelectError(Logger LOGGER, String tableName){
		LOGGER.error("Error selecting from " + tableName);
	}
	
	protected void logDbUpdateError(Logger LOGGER, String tableName){
		LOGGER.error("Error updating database table " + tableName);
	}
	
	protected void logDbGeneralError(Logger LOGGER, String tableName){
		LOGGER.error("Error querying database table " + tableName);
	}
	
	protected void logDbDuplicateKeyError(Logger LOGGER, String tableName, String pkValue){
		LOGGER.error("Error inserting into " + tableName + ". Primary Key value '" + pkValue + "' already exists.");
	}
	
	public abstract Boolean validateIntegrity(T model);
}