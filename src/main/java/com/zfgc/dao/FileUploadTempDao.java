package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.FileUploadTempDbObjExample;
import com.zfgc.dbobj.FileUploadTempDbObjKey;
import com.zfgc.mappers.FileUploadTempDbObjMapper;
import com.zfgc.model.file.FileUploadTemp;

@Component
public class FileUploadTempDao extends AbstractDao<FileUploadTempDbObjExample, FileUploadTempDbObjKey, FileUploadTemp>{

	@Autowired
	private FileUploadTempDbObjMapper fileUploadTempDbObjMapper;
	
	@Override
	public List<FileUploadTempDbObjKey> get(FileUploadTempDbObjExample ex)
			throws RuntimeException {
		return fileUploadTempDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(FileUploadTemp obj) throws RuntimeException {
		FileUploadTempDbObjKey dbObj = mapper.map(obj,FileUploadTempDbObjKey.class);
		fileUploadTempDbObjMapper.deleteByPrimaryKey(dbObj);
		
	}

	@Override
	public void updateOrInsert(FileUploadTemp obj) throws RuntimeException {
		FileUploadTempDbObjKey dbObj = mapper.map(obj,FileUploadTempDbObjKey.class);
		fileUploadTempDbObjMapper.insert(dbObj);
	}

	@Override
	public void updateByExample(FileUploadTemp obj,
			FileUploadTempDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(FileUploadTemp obj,
			FileUploadTempDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countByExample(FileUploadTemp obj,
			FileUploadTempDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}