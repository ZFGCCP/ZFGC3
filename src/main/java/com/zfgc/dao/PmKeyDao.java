package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.PmKeyDbObj;
import com.zfgc.dbobj.PmKeyDbObjExample;
import com.zfgc.mappers.PmKeyDbObjMapper;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.pm.PmKey;

@Component
public class PmKeyDao extends AbstractDao<PmKeyDbObjExample, PmKeyDbObj, PmKey>{

	@Autowired
	PmKeyDbObjMapper pmKeyDbObjMapper;
	
	@Override
	public List<PmKeyDbObj> get(PmKeyDbObjExample ex) throws RuntimeException {
		return pmKeyDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(PmKey obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(PmKey obj) throws RuntimeException {
		PmKeyDbObj dbObj = mapper.map(obj, PmKeyDbObj.class);
		
		if(dbObj.getPmKeyId() == null || dbObj.getPmKeyId() == -1){
			pmKeyDbObjMapper.insert(dbObj);
		}
		else{
			pmKeyDbObjMapper.updateByPrimaryKey(dbObj);
		}
	}

	@Override
	public void updateByExample(PmKey obj, PmKeyDbObjExample ex) throws RuntimeException {
		PmKeyDbObj dbObj = mapper.map(obj, PmKeyDbObj.class);
		pmKeyDbObjMapper.updateByExample(dbObj, ex);
		
	}

	@Override
	public Integer deleteByExample(PmKey obj, PmKeyDbObjExample ex) throws RuntimeException {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long countByExample(PmKey obj, PmKeyDbObjExample ex)
			throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

}
