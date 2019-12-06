package com.zfgc.services.avatar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zfgc.dataprovider.AvatarDataProvider;
import com.zfgc.dataprovider.AvatarStagingDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.avatar.Avatar;
import com.zfgc.model.avatar.AvatarStaging;
import com.zfgc.model.users.Users;
import com.zfgc.services.AbstractService;
import com.zfgc.services.RuleRunService;
import com.zfgc.services.content.ContentService;
import com.zfgc.validation.avatar.AvatarValidator;

@Component
public class AvatarService extends AbstractService {
	@Autowired
	private AvatarDataProvider avatarDataProvider;
	
	@Autowired
	private AvatarStagingDataProvider avatarStagingDataProvider;
	
	@Autowired
	private ContentService contentService;
	
	@Autowired
	private AvatarValidator avatarValidator;
	
	@Autowired
	private RuleRunService<AvatarStaging> ruleRunService;
	
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
	
	public AvatarStaging getAvatarStagingRecord(String mac) {
		AvatarStaging db = avatarStagingDataProvider.getStagedAvatar(mac);
		
		return db;
	}
	
	@Transactional
	public AvatarStaging stageAvatar(MultipartFile file, Users zfgcUser) {
		AvatarStaging validatorRecord = new AvatarStaging();
		validatorRecord.setFile(file);
		ruleRunService.runRules(avatarValidator, null, null, validatorRecord, zfgcUser);
		
		String fileName = contentService.writeFile(file, "G:\\ZFGC3\\ZFGC3 git\\ZFGC3\\src\\main\\webapp\\assets\\images\\avatar\\", zfgcUser);
		AvatarStaging staged = avatarStagingDataProvider.createStagedRecord(fileName, zfgcUser.getUsersId());
		
		return staged;
	}
}
