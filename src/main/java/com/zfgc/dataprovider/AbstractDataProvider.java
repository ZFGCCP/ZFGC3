package com.zfgc.dataprovider;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.zfgc.model.forum.PaginationBounds;

public class AbstractDataProvider {
	@Autowired
	DozerBeanMapper mapper;
	
	protected PaginationBounds calculatePaginationBounds(Integer pageNo, Integer itemsPerPage){
		PaginationBounds result = new PaginationBounds();
		result.setLowerBound((pageNo - 1) * itemsPerPage);
		result.setUpperBound(result.getLowerBound() + itemsPerPage);
		
		return result;
	}
}
