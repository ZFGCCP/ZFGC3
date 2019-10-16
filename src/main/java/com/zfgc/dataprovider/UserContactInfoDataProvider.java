package com.zfgc.dataprovider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.UserContactSettingsDao;
import com.zfgc.dbobj.UserContactSettingsDbObj;
import com.zfgc.dbobj.UserContactSettingsDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.users.UserContactInfo;

@Component
public class UserContactInfoDataProvider extends AbstractDataProvider {
	
	@Autowired
	private UserContactSettingsDao userContactDao;
	
	@Autowired
	private EmailAddressDataProvider emailAddressDataProvider;
	
	public UserContactInfo getUserContactInfo(Integer usersId) {
		UserContactSettingsDbObjExample ex = userContactDao.getExample();
		ex.createCriteria().andUsersIdEqualTo(usersId);
		
		List<UserContactSettingsDbObj> dbObj = userContactDao.get(ex);
		
		if(dbObj.size() > 0) {
			UserContactInfo info = mapper.map(dbObj.get(0), UserContactInfo.class);
			info.setEmail(emailAddressDataProvider.getEmail(dbObj.get(0).getEmailAddressId()));
			return info;
		}
		
		throw new ZfgcNotFoundException("User contact settings " + usersId);
	}
	
}
