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
public class AvatarDao extends AbstractDao<AvatarDbObjExample, AvatarDbObj>{

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

}
