package com.zfgc.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.mappers.LkupAllViewDbObjMapper;
import com.zfgc.model.lookups.Lookup;
import com.zfgc.dbobj.LkupAllViewDbObj;
import com.zfgc.dbobj.LkupAllViewDbObjExample;

@Component
public class LookupDao extends AbstractDao<Object,Object,Object>{
	
	private Logger LOGGER = LogManager.getLogger(LookupDao.class);
	
	@Autowired
	private LkupAllViewDbObjMapper lkupAllViewDbObjMapper;
	
	
	public List<Lookup> getLookup(String lookupName) throws Exception{
		LkupAllViewDbObjExample ex = new LkupAllViewDbObjExample();
		ex.createCriteria().andLkupNameEqualTo(lookupName);
		ex.setOrderByClause("LKUP_ID ASC");
		List<LkupAllViewDbObj> lkupDb = lkupAllViewDbObjMapper.selectByExample(ex);
		
		if(lkupDb == null || lkupDb.size() == 0){
			throw new RuntimeException("Lookup " + lookupName + " returned zero results.");
		}
		
		LOGGER.info("Loaded lookup " + lookupName);
		return lkupDb.stream().map(x -> {
			Lookup lkup = new Lookup();
			lkup.setId(x.getLkupId());
			lkup.setValue(x.getLkupDesc());
			return lkup;
		}).collect(Collectors.toList());
	}

	@Override
	public List<Object> get(Object ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void hardDelete(Object obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(Object obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(Object obj, Object ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(Object obj, Object ex) throws RuntimeException {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long countByExample(Object obj, Object ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	
}