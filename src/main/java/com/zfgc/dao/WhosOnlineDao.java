package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.OnlineUserDbObj;
import com.zfgc.dbobj.OnlineUserDbObjExample;
import com.zfgc.mappers.OnlineUserDbObjMapper;
import com.zfgc.model.online.OnlineUser;

@Component
public class WhosOnlineDao extends AbstractDao<OnlineUserDbObjExample, OnlineUserDbObj, OnlineUser>{

	@Autowired
	OnlineUserDbObjMapper onlineUserDbObjMapper;
	
	@Override
	public List<OnlineUserDbObj> get(OnlineUserDbObjExample ex)
			throws RuntimeException {
		return onlineUserDbObjMapper.selectByExample(ex);
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
	public void updateByExample(OnlineUser obj, OnlineUserDbObjExample ex)
			throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(OnlineUser obj, OnlineUserDbObjExample ex)
			throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countByExample(OnlineUser obj, OnlineUserDbObjExample ex)
			throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}