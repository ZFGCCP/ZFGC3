package com.zfgc.dataprovider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.AvatarStagingDao;
import com.zfgc.dbobj.AvatarStagingDbObj;
import com.zfgc.dbobj.AvatarStagingDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.avatar.AvatarStaging;
import com.zfgc.util.security.ZfgcSecurityUtils;

@Component
public class AvatarStagingDataProvider extends AbstractDataProvider {

	@Autowired
	private AvatarStagingDao avatarStagingDao;
	
	public AvatarStaging getStagedAvatar(String mac) {
		AvatarStagingDbObjExample ex = avatarStagingDao.getExample();
		ex.createCriteria().andMacEqualTo(mac);
		
		List<AvatarStagingDbObj> dbObj = avatarStagingDao.get(ex);
		
		if(dbObj.size() == 0) {
			throw new ZfgcNotFoundException("Avatar Staging " + mac);
		}
		
		return mapper.map(dbObj.get(0), AvatarStaging.class);
	}
	
	public AvatarStaging createStagedRecord(String fileName, Integer usersId) {
		AvatarStaging staged = new AvatarStaging();
		staged.setFilename(fileName);
		staged.setMac(ZfgcSecurityUtils.generateCryptoString(16));
		staged.setUsersId(usersId);
		
		avatarStagingDao.updateOrInsert(staged);
		
		return staged;
	}
}
