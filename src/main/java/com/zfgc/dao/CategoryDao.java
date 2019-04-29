package com.zfgc.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.CategoryDbObj;
import com.zfgc.dbobj.CategoryDbObjExample;
import com.zfgc.mappers.CategoryDbObjMapper;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.forum.Category;

@Component
public class CategoryDao extends AbstractDao<CategoryDbObjExample, CategoryDbObj, Category> {
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

	@Override
	public List<CategoryDbObj> get(CategoryDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void hardDelete(Category obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(Category obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(Category obj, CategoryDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(Category obj, CategoryDbObjExample ex) throws RuntimeException {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long countByExample(Category obj, CategoryDbObjExample ex)
			throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
}
