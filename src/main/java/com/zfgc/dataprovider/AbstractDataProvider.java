package com.zfgc.dataprovider;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDataProvider {
	@Autowired
	DozerBeanMapper mapper;
}
