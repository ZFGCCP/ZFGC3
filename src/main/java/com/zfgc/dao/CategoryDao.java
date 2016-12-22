package com.zfgc.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.CategoryDbObj;
import com.zfgc.dbobj.CategoryDbObjExample;
import com.zfgc.mappers.CategoryDbObjMapper;

@Component
public class CategoryDao extends AbstractDao {
	@Autowired
	CategoryDbObjMapper categoryDbObjMapper;

	Logger LOGGER = Logger.getLogger(CategoryDao.class);
	
	public List<CategoryDbObj> getCategories() throws Exception{
		try{
			CategoryDbObjExample categoryDbObjExample = new CategoryDbObjExample();
			categoryDbObjExample.setOrderByClause("SEQ_NO ASC");
			return categoryDbObjMapper.selectByExample(categoryDbObjExample);
		}
		catch(Exception e){
			super.logDbGeneralError(LOGGER, "CATEGORY");
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}
