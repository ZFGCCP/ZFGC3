package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.NavTabViewDbObj;
import com.zfgc.dbobj.NavTabViewDbObjExample;
import com.zfgc.mappers.NavTabViewDbObjMapper;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.NavTab;

@Component
public class NavTabDao extends AbstractDao<NavTabViewDbObjExample, NavTabViewDbObj, NavTab> {

	@Autowired
	private NavTabViewDbObjMapper navTabViewDbObjMapper;
	
	public List<NavTabViewDbObj> getNavigationTabs(Users user) throws Exception{
		try{
			List<NavTabViewDbObj> navTabView = navTabViewDbObjMapper.getNavigationTabs(user.getMemberGroups(), user.getPrimaryMemberGroupId());
			return navTabView;
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	public List<NavTabViewDbObj> get(NavTabViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void hardDelete(NavTab obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(NavTab obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(NavTab obj, NavTabViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(NavTab obj, NavTabViewDbObjExample ex) throws RuntimeException {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer countByExample(NavTab obj, NavTabViewDbObjExample ex)
			throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
}
