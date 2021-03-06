package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.PmArchiveBoxViewDbObj;
import com.zfgc.dbobj.PmArchiveBoxViewDbObjExample;
import com.zfgc.dbobj.PmArchiveBoxViewDbObjWithBLOBs;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.mappers.PmArchiveBoxViewDbObjMapper;
import com.zfgc.model.pm.PmArchiveBoxView;

@Component
public class PmArchiveBoxViewDao extends AbstractDao<PmArchiveBoxViewDbObjExample,PmArchiveBoxViewDbObjWithBLOBs,PmArchiveBoxView>{

	@Autowired
	PmArchiveBoxViewDbObjMapper dbObjMapper;
	
	@Override
	public List<PmArchiveBoxViewDbObjWithBLOBs> get(PmArchiveBoxViewDbObjExample ex)
			throws RuntimeException {
		List<PmArchiveBoxViewDbObjWithBLOBs> result = null;
		result = dbObjMapper.selectByExampleWithBLOBs(ex);

		return result;
	}

	@Override
	public void hardDelete(PmArchiveBoxView obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(PmArchiveBoxView obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(PmArchiveBoxView obj,
			PmArchiveBoxViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(PmArchiveBoxView obj,
			PmArchiveBoxViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByExample(PmArchiveBoxView obj,
			PmArchiveBoxViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}