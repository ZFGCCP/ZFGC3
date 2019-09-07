package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.UserEmailViewDao;
import com.zfgc.dbobj.UserEmailViewDbObj;
import com.zfgc.dbobj.UserEmailViewDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.users.UserEmailView;

@Component
public class UserEmailViewDataProvider extends AbstractDataProvider {
	
	@Autowired
	UserEmailViewDao userEmailViewDao;
	
	public UserEmailView getActiveUserEmail(String loginName){
		UserEmailViewDbObjExample ex = userEmailViewDao.getExample();
		ex.createCriteria().andActiveFlagEqualTo(true)
		                   .andLoginNameEqualTo(loginName);
		
		
		List<UserEmailViewDbObj> result = userEmailViewDao.get(ex);
		
		if(result.size() == 0 ) {
			throw new ZfgcNotFoundException("user email " + loginName);
		}
		
		return mapper.map(result.get(0), UserEmailView.class);
	}
}
