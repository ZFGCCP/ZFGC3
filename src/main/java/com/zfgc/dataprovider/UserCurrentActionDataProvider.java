package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.UserCurrentActionDao;
import com.zfgc.dbobj.UserCurrentActionDbObj;
import com.zfgc.dbobj.UserCurrentActionDbObjExample;
import com.zfgc.model.users.UserCurrentAction;

@Component
public class UserCurrentActionDataProvider extends AbstractDataProvider {

	@Autowired
	private UserCurrentActionDao userCurrentActionDao;
	
	public List<UserCurrentAction> getUserCurrentActions(Integer usersId){
		UserCurrentActionDbObjExample ex = new UserCurrentActionDbObjExample();
		ex.createCriteria().andUsersIdEqualTo(usersId);
		
		List<UserCurrentActionDbObj> dbObj = userCurrentActionDao.get(ex);
		List<UserCurrentAction> currentActions = new ArrayList<>();
		
		for(UserCurrentActionDbObj db : dbObj) {
			currentActions.add(mapper.map(db, UserCurrentAction.class));
		}
		
		return currentActions;
		
	}
	
	public UserCurrentAction updateUserAction(UserCurrentAction currentAction) {
		userCurrentActionDao.updateOrInsert(currentAction);
		return currentAction;
	}
	
	public void deleteAllUserActions(Integer usersId) {
		UserCurrentActionDbObjExample ex = new UserCurrentActionDbObjExample();
		ex.createCriteria().andUsersIdEqualTo(usersId);
		
		userCurrentActionDao.deleteByExample(null, ex);
	}
	
	public void deleteAllUserActions() {
		userCurrentActionDao.deleteByExample(null, new UserCurrentActionDbObjExample());
	}
	
}
