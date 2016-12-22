package com.zfgc.services.forum;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.CategoryDataProvider;
import com.zfgc.model.forum.Category;
import com.zfgc.services.AbstractService;

@Component
public class CategoryService extends AbstractService{
	@Autowired
	CategoryDataProvider categoryDataProvider;
	
	public List<Category> getCategories() throws Exception{
		try{
			return categoryDataProvider.getCategories();
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	public List<Category> removeEmptyCategories(List<Category> categories){
		if(categories == null){
			return null;
		}
		
		List<Category> output = new ArrayList<>();
		
		for(Category category : categories){
			if(category.getForums().size() > 0){
				output.add(category);
			}
		}
		
		return output;
	}
}
