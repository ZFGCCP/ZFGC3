package com.zfgc.dataprovider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.UserPasswordResetViewDao;
import com.zfgc.dbobj.UserPasswordResetViewDbObj;
import com.zfgc.dbobj.UserPasswordResetViewDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.users.NewPassword;

@Component
public class UserPasswordResetViewDataProvider extends AbstractDataProvider {
	
	@Autowired
	private UserPasswordResetViewDao userPasswordResetViewDao;
	
	public NewPassword getPasswordResetByCode(String code) {
		UserPasswordResetViewDbObjExample ex = userPasswordResetViewDao.getExample();
		ex.createCriteria().andCodeEqualTo(code);
		
		List<UserPasswordResetViewDbObj> dbObj = userPasswordResetViewDao.get(ex);
		
		if(dbObj.size() == 0) {
			throw new ZfgcNotFoundException("Password reset code " + code);
		}
		
		return mapper.map(dbObj.get(0), NewPassword.class);
	}
	
}