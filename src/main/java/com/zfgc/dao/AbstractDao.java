package com.zfgc.dao;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class AbstractDao{
	@Autowired
	protected NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	DozerBeanMapper mapper;
}