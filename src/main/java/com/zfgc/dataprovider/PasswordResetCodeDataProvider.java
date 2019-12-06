package com.zfgc.dataprovider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.PasswordResetCodeDao;
import com.zfgc.dbobj.PasswordResetCodeDbObj;
import com.zfgc.dbobj.PasswordResetCodeDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.users.PasswordResetCode;

@Component
public class PasswordResetCodeDataProvider extends AbstractDataProvider {
	
	@Autowired
	private PasswordResetCodeDao passwordResetCodeDao;
	
	public PasswordResetCode getPasswordResetCodeByUserId(Integer usersId) {
		PasswordResetCodeDbObjExample ex = passwordResetCodeDao.getExample();
		ex.createCriteria().andUsersIdEqualTo(usersId);
		
		List<PasswordResetCodeDbObj> result = passwordResetCodeDao.get(ex);
		
		if(result.size() == 0) {
			throw new ZfgcNotFoundException("password reset code for user" + usersId);
		}
		
		return mapper.map(result.get(0), PasswordResetCode.class);
	}
	
	public PasswordResetCode getPasswordResetCodeByCode(String code) {
		PasswordResetCodeDbObjExample ex = passwordResetCodeDao.getExample();
		ex.createCriteria().andCodeEqualTo(code);
		
		List<PasswordResetCodeDbObj> result = passwordResetCodeDao.get(ex);
		
		if(result.size() == 0) {
			throw new ZfgcNotFoundException("password reset code " + code);
		}
		
		return mapper.map(result.get(0), PasswordResetCode.class);
	}
	
	public PasswordResetCode getPasswordResetCode(Integer usersId) {
		PasswordResetCodeDbObjExample ex = passwordResetCodeDao.getExample();
		ex.createCriteria().andUsersIdEqualTo(usersId);
		
		List<PasswordResetCodeDbObj> result = passwordResetCodeDao.get(ex);
		
		if(result.size() == 0) {
			throw new ZfgcNotFoundException("password reset code " + usersId);
		}
		
		return mapper.map(result.get(0), PasswordResetCode.class);
	}
	
	public PasswordResetCode createResetCode(PasswordResetCode code) {
		passwordResetCodeDao.updateOrInsert(code);
		return code;
	}
	
	public void deleteResetCode(PasswordResetCode code) {
		passwordResetCodeDao.hardDelete(code);
	}
	
}