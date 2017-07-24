package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.HtmlEntityDbObj;
import com.zfgc.dbobj.HtmlEntityDbObjExample;
import com.zfgc.mappers.HtmlEntityDbObjMapper;

@Component
public class HtmlEntityDao extends AbstractDao<HtmlEntityDbObjExample, HtmlEntityDbObj, Object> {

	@Autowired
	HtmlEntityDbObjMapper htmlEntityDbObjMapper;
	
	@Override
	public List<HtmlEntityDbObj> get(HtmlEntityDbObjExample ex) {
		return htmlEntityDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(Object obj, HtmlEntityDbObjExample ex) {
		// TODO Auto-generated method stub
		
	}

}
