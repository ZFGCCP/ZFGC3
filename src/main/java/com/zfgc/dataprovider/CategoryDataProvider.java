package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.CategoryDao;
import com.zfgc.dbobj.CategoryDbObj;
import com.zfgc.model.forum.Category;

@Component
public class CategoryDataProvider extends AbstractDataProvider{
	@Autowired
	CategoryDao categoryDao;
	
	public List<Category> getCategories() throws Exception{
		try{
			List<CategoryDbObj> categoryDb = categoryDao.getCategories();
			List<Category> categories = new ArrayList<>();
			
			for(CategoryDbObj category : categoryDb){
				categories.add(mapper.map(category, Category.class));
			}
			
			return categories;
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
}
