package com.zfgc.dataprovider;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.AvatarDao;
import com.zfgc.dao.AvatarGalleryDao;
import com.zfgc.dbobj.AvatarDbObj;
import com.zfgc.dbobj.AvatarDbObjExample;
import com.zfgc.dbobj.AvatarGalleryDbObj;
import com.zfgc.dbobj.AvatarGalleryDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.avatar.Avatar;
import com.zfgc.model.avatar.AvatarGallery;

@Component
public class AvatarDataProvider extends AbstractDataProvider  {

	@Autowired
	private AvatarDao avatarDao;
	
	@Autowired
	private AvatarGalleryDao avatarGalleryDao;

	public AvatarGallery getAvatarGallery(Integer galleryId) throws ZfgcNotFoundException, Exception{
		AvatarGalleryDbObjExample ex = avatarGalleryDao.getExample();
		ex.createCriteria().andAvatarGalleryIdEqualTo(galleryId);
		
		List<AvatarGalleryDbObj> result = avatarGalleryDao.get(ex);
		
		return mapper.map(result.get(0), AvatarGallery.class);
		
	}
	
	public Avatar getAvatar(Integer avatarId) throws ZfgcNotFoundException{
		AvatarDbObj dbObj = avatarDao.getAvatar(avatarId);
		return mapper.map(dbObj,Avatar.class);
		
	}
	
	public String getAvatarFileName(Integer avatarId) throws Exception{
		String fileName = avatarDao.getAvatarFileLocation(avatarId);
		return fileName;
	}
	
	public void deleteAvatarRecord(Integer avatarId) throws Exception{
		AvatarDbObjExample ex = avatarDao.getExample();
		ex.createCriteria().andAvatarIdEqualTo(avatarId);
		avatarDao.deleteByExample(null, ex);
	}
	
	public Avatar createAvatarRecord(Avatar avatar) throws Exception {
		avatarDao.updateOrInsert(avatar);
		return avatar;
	}
		
}
