package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.AvatarDbObj;
import com.zfgc.dbobj.AvatarDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.mappers.AvatarDbObjMapper;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.avatar.Avatar;

@Component
public class AvatarDao extends AbstractDao<AvatarDbObjExample, AvatarDbObj, Avatar>{

	@Autowired
	private AvatarDbObjMapper avatarDbObjMapper;
	
	public AvatarDbObj getAvatar(Integer avatarId) throws ZfgcNotFoundException{
		AvatarDbObj dbObj = avatarDbObjMapper.selectByPrimaryKey(avatarId);
		
		if(dbObj == null){
			throw new ZfgcNotFoundException("Avatar " + avatarId);
		}
		
		return dbObj;
	}
	
	public String getAvatarFileLocation(Integer avatarId) throws Exception{
		String avatarFileLocation = "";
		try{
			avatarFileLocation = avatarDbObjMapper.getAvatarFileLocation(avatarId);
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
		
		if(avatarFileLocation == null){
			throw new ZfgcNotFoundException("Avatar " + avatarId);
		}
		
		return avatarFileLocation;
	}

	@Override
	public List<AvatarDbObj> get(AvatarDbObjExample ex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void hardDelete(Avatar obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(Avatar obj) {
		AvatarDbObj dbObj = mapper.map(obj, AvatarDbObj.class);
		if(obj.getAvatarId() == null || obj.getAvatarId() == -1){
			avatarDbObjMapper.insert(dbObj);
		}
		else{
			avatarDbObjMapper.updateByPrimaryKey(dbObj);
		}
		
		obj.setAvatarId(dbObj.getAvatarId());
	}

	@Override
	public void updateByExample(Avatar obj, AvatarDbObjExample ex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(Avatar obj, AvatarDbObjExample ex) {
		return avatarDbObjMapper.deleteByExample(ex);
	}

	@Override
	public Integer countByExample(Avatar obj, AvatarDbObjExample ex)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
