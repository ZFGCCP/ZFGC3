package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.BbCodeAttributeDbObj;
import com.zfgc.dbobj.BbCodeAttributeDbObjExample;
import com.zfgc.dbobj.BbCodeAttributeModeDbObj;
import com.zfgc.dbobj.BbCodeAttributeModeDbObjExample;
import com.zfgc.dbobj.BbCodeConfigDbObj;
import com.zfgc.dbobj.BbCodeConfigDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.mappers.BbCodeAttributeDbObjMapper;
import com.zfgc.mappers.BbCodeAttributeModeDbObjMapper;
import com.zfgc.mappers.BbCodeConfigDbObjMapper;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.bbcode.Bbcode;
import com.zfgc.model.bbcode.BbcodeConfig;

@Component
public class BbcodeDao extends AbstractDao<BbCodeConfigDbObjExample, BbCodeConfigDbObj, BbcodeConfig>{

	@Autowired
	BbCodeAttributeDbObjMapper bbCodeAttributeDbObjMapper;
	
	@Autowired
	BbCodeAttributeModeDbObjMapper bbCodeAttributeModeDbObjMapper;
	
	@Autowired
	BbCodeConfigDbObjMapper bbCodeConfigDbObjMapper;
	
	public List<BbCodeConfigDbObj> getValidBbCodes() throws ZfgcNotFoundException{
		BbCodeConfigDbObjExample ex = new BbCodeConfigDbObjExample();
		List<BbCodeConfigDbObj> results = bbCodeConfigDbObjMapper.selectByExample(ex);
		
		if(results.size() == 0){
			throw new ZfgcNotFoundException("BbCode Configs");
		}
		
		return results;
	}
	
	public List<BbCodeAttributeModeDbObj> getAttributeModesByBbCode(Integer bbCodeId) throws ZfgcNotFoundException{
		BbCodeAttributeModeDbObjExample ex = new BbCodeAttributeModeDbObjExample();
		ex.createCriteria().andBbCodeConfigIdEqualTo(bbCodeId);
		List<BbCodeAttributeModeDbObj> results = bbCodeAttributeModeDbObjMapper.selectByExample(ex);
		
		if(results.size() == 0){
			throw new ZfgcNotFoundException("BbCode AttributeMode for BbCode " + bbCodeId);
		}
		
		return results;
	}
	
	public List<BbCodeAttributeDbObj> getAttributesByMode(Integer modeId){
		BbCodeAttributeDbObjExample ex = new BbCodeAttributeDbObjExample();
		ex.createCriteria().andBbCodeAttributeModeIdEqualTo(modeId.byteValue());
		List<BbCodeAttributeDbObj> results = bbCodeAttributeDbObjMapper.selectByExample(ex);

		return results;
	}

	@Override
	public List<BbCodeConfigDbObj> get(BbCodeConfigDbObjExample ex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void hardDelete(BbcodeConfig obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(BbcodeConfig obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(BbcodeConfig obj, BbCodeConfigDbObjExample ex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(BbcodeConfig obj, BbCodeConfigDbObjExample ex) {
		return null;
		// TODO Auto-generated method stub
		
	}

}
