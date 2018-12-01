package com.zfgc.dataprovider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.FileUploadTempDao;
import com.zfgc.dbobj.FileUploadTempDbObjExample;
import com.zfgc.dbobj.FileUploadTempDbObjKey;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.file.FileUploadTemp;

@Component
public class FileUploadTempDataProvider extends AbstractDataProvider{
	
	@Autowired
	private FileUploadTempDao fileUploadTempDao;
	
	public void createTempRecord(String fileName, Integer usersId) throws Exception{
		FileUploadTemp temp = new FileUploadTemp();
		temp.setFileName(fileName);
		temp.setUsersId(usersId);
		
		fileUploadTempDao.updateOrInsert(temp);
	}
	
	public FileUploadTemp getTempRecord(String fileName, Integer usersId, boolean delete) throws Exception{
		FileUploadTempDbObjExample ex = fileUploadTempDao.getExample();
		ex.createCriteria().andFileNameEqualTo(fileName).andUsersIdEqualTo(usersId);
		
		List<FileUploadTempDbObjKey> temp = fileUploadTempDao.get(ex);
		
		if(temp.size() == 0){
			throw new ZfgcNotFoundException();
		}
		
		if(delete){
			deleteTempRecord(fileName,usersId);
		}
		
		return mapper.map(temp.get(0), FileUploadTemp.class);
	}
	
	private void deleteTempRecord(String fileName, Integer usersId) throws Exception{
		FileUploadTemp temp = new FileUploadTemp();
		temp.setFileName(fileName);
		temp.setUsersId(usersId);
		
		fileUploadTempDao.hardDelete(temp);
	}
}