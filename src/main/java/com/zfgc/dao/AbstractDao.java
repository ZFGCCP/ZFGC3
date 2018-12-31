package com.zfgc.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.zfgc.model.BaseZfgcModel;

public abstract class AbstractDao<Example, DbObj, Model>{
	@Autowired
	protected NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	DozerBeanMapper mapper;
	
	private  final Class<?>[] types = GenericTypeResolver.resolveTypeArguments(getClass(), AbstractDao.class);
	
	public Example getExample(){
		try {
			return (Example) types[0].newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public abstract List<DbObj> get(Example ex) throws Exception;
	public abstract void hardDelete(Model obj);
	public abstract void updateOrInsert(Model obj) throws Exception;
	public abstract void updateByExample(Model obj, Example ex) throws Exception;
	public abstract Integer deleteByExample(Model obj, Example ex) throws Exception;
	public abstract Integer countByExample(Model obj, Example ex) throws Exception;
	
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
}