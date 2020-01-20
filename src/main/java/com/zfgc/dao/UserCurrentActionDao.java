package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.UserCurrentActionDbObj;
import com.zfgc.dbobj.UserCurrentActionDbObjExample;
import com.zfgc.mappers.UserCurrentActionDbObjMapper;
import com.zfgc.model.users.UserCurrentAction;

@Component
public class UserCurrentActionDao extends AbstractDao<UserCurrentActionDbObjExample, UserCurrentActionDbObj, UserCurrentAction> {

	@Autowired
	private UserCurrentActionDbObjMapper userCurrentActionDbObjMapper;
	
	@Override
	public List<UserCurrentActionDbObj> get(UserCurrentActionDbObjExample ex) throws RuntimeException {
		return userCurrentActionDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(UserCurrentAction obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(UserCurrentAction obj) throws RuntimeException {
		UserCurrentActionDbObj dbObj = mapper.map(obj, UserCurrentActionDbObj.class);
		if(dbObj.getUserCurrentActionId().equals(-1)) {
			userCurrentActionDbObjMapper.insert(dbObj);
		}
		else {
			userCurrentActionDbObjMapper.updateByPrimaryKey(dbObj);
		}
		
		obj.setUserCurrentActionId(dbObj.getUserCurrentActionId());
	}

	@Override
	public void updateByExample(UserCurrentAction obj, UserCurrentActionDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(UserCurrentAction obj, UserCurrentActionDbObjExample ex) throws RuntimeException {
		return userCurrentActionDbObjMapper.deleteByExample(ex);
	}

	@Override
	public Long countByExample(UserCurrentAction obj, UserCurrentActionDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}