package com.zfgc.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.AvatarDao;
import com.zfgc.dbobj.AvatarDbObj;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.avatar.Avatar;

@Component
public class AvatarDataProvider extends AbstractDataProvider  {

	@Autowired
	private AvatarDao avatarDao;
	
	public Avatar getAvatar(Integer avatarId) throws ZfgcNotFoundException{
		AvatarDbObj dbObj = avatarDao.getAvatar(avatarId);
		return mapper.map(dbObj,Avatar.class);
		
	}
	
	public String getAvatarFileName(Integer avatarId) throws Exception{
		String fileName = avatarDao.getAvatarFileLocation(avatarId);
		return fileName;
	}
		
}
