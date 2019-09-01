package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.OnlineUserDetailDbObj;
import com.zfgc.dbobj.OnlineUserDetailDbObjExample;
import com.zfgc.mappers.OnlineUserDetailDbObjMapper;
import com.zfgc.model.online.OnlineUser;

@Component
public class WhosOnlineDetailViewDao extends AbstractDao<OnlineUserDetailDbObjExample, OnlineUserDetailDbObj, OnlineUser>{

	@Autowired
	private OnlineUserDetailDbObjMapper onlineUserDetailDbObjMapper;
	
	@Override
	public List<OnlineUserDetailDbObj> get(OnlineUserDetailDbObjExample ex) throws RuntimeException {
		return onlineUserDetailDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(OnlineUser obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(OnlineUser obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(OnlineUser obj, OnlineUserDetailDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(OnlineUser obj, OnlineUserDetailDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByExample(OnlineUser obj, OnlineUserDetailDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}