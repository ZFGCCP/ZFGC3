package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.NavTabViewDbObj;
import com.zfgc.dbobj.NavTabViewDbObjExample;
import com.zfgc.mappers.NavTabViewDbObjMapper;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.Users;

@Component
public class NavTabDao extends AbstractDao<NavTabViewDbObjExample, NavTabViewDbObj> {

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
	public List<NavTabViewDbObj> get(NavTabViewDbObjExample ex) {
		// TODO Auto-generated method stub
		return null;
	}
}
