package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.AvatarStagingDbObj;
import com.zfgc.dbobj.AvatarStagingDbObjExample;
import com.zfgc.mappers.AvatarStagingDbObjMapper;
import com.zfgc.model.avatar.AvatarStaging;

@Component
public class AvatarStagingDao extends AbstractDao<AvatarStagingDbObjExample, AvatarStagingDbObj, AvatarStaging>{

	@Autowired
	private AvatarStagingDbObjMapper avatarStagingDbObjMapper;
	
	@Override
	public List<AvatarStagingDbObj> get(AvatarStagingDbObjExample ex) throws RuntimeException {
		return avatarStagingDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(AvatarStaging obj) throws RuntimeException {
		avatarStagingDbObjMapper.deleteByPrimaryKey(obj.getAvatarStagingId());
	}

	@Override
	public void updateOrInsert(AvatarStaging obj) throws RuntimeException {
		AvatarStagingDbObj dbObj = mapper.map(obj, AvatarStagingDbObj.class);
		
		avatarStagingDbObjMapper.insert(dbObj);
		obj.setAvatarStagingId(dbObj.getAvatarStagingId());
		
	}

	@Override
	public void updateByExample(AvatarStaging obj, AvatarStagingDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(AvatarStaging obj, AvatarStagingDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByExample(AvatarStaging obj, AvatarStagingDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}