package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.forum.PaginationBounds;

public class AbstractDataProvider{
	@Autowired
	DozerBeanMapper mapper;
	
	//todo: the fuck is this?
	protected PaginationBounds calculatePaginationBounds(Integer pageNo, Integer itemsPerPage){
		PaginationBounds result = new PaginationBounds();
		result.setLowerBound((pageNo - 1) * itemsPerPage);
		result.setUpperBound(result.getLowerBound() + itemsPerPage);
		
		return result;
	}

}
