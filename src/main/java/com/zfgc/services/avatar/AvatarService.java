package com.zfgc.services.avatar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.AvatarDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.avatar.Avatar;
import com.zfgc.services.AbstractService;

@Component
public class AvatarService extends AbstractService {
	@Autowired
	private AvatarDataProvider avatarDataProvider;
	
	public String getAvatarFileName(Integer avatarId) throws ZfgcNotFoundException{
		try{
			Avatar av = avatarDataProvider.getAvatar(avatarId);
			if(av.getAvatarTypeId() == 4){
				return avatarDataProvider.getAvatarGallery(av.getAvatarGalleryId()).getFilePath();
			}
			
			return avatarDataProvider.getAvatarFileName(avatarId);
		}
		catch(ZfgcNotFoundException ex){
			ex.printStackTrace();
			throw new ZfgcNotFoundException("Avatar " + avatarId);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public String getAvatarGallery(Integer galleryId) throws ZfgcNotFoundException, Exception{
		return avatarDataProvider.getAvatarGallery(galleryId).getFilePath();
	}
	
	public void deleteAvatarRecord(Integer avatarId) throws Exception{
		avatarDataProvider.deleteAvatarRecord(avatarId);
	}
	
	public Avatar createAvatarRecordFromExternal(Avatar avatar) throws RuntimeException{
		Avatar av = avatarDataProvider.createAvatarRecord(avatar);
		return av;
	}
}
