package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.AvatarGalleryDbObj;
import com.zfgc.dbobj.AvatarGalleryDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.mappers.AvatarGalleryDbObjMapper;
import com.zfgc.model.avatar.AvatarGallery;

@Component
public class AvatarGalleryDao extends AbstractDao<AvatarGalleryDbObjExample, AvatarGalleryDbObj, AvatarGallery>{

	@Autowired
	private AvatarGalleryDbObjMapper avatarGalleryDbObjMapper;
	
	@Override
	public List<AvatarGalleryDbObj> get(AvatarGalleryDbObjExample ex)
			throws Exception {
		List<AvatarGalleryDbObj> result = avatarGalleryDbObjMapper.selectByExample(ex);
		
		if(result == null || result.size() == 0){
			throw new ZfgcNotFoundException("Avatar Gallery");
		}
		
		return result;
	}

	@Override
	public void hardDelete(AvatarGallery obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(AvatarGallery obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(AvatarGallery obj, AvatarGalleryDbObjExample ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(AvatarGallery obj,
			AvatarGalleryDbObjExample ex) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countByExample(AvatarGallery obj,
			AvatarGalleryDbObjExample ex) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}