package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.HostnameDbObj;
import com.zfgc.dbobj.HostnameDbObjExample;
import com.zfgc.mappers.HostnameDbObjMapper;
import com.zfgc.model.users.Hostname;

@Component
public class HostnameDao extends AbstractDao<HostnameDbObjExample, HostnameDbObj, Hostname>{

	@Autowired
	private HostnameDbObjMapper hostnameDbObjMapper;
	
	@Override
	public List<HostnameDbObj> get(HostnameDbObjExample ex) throws RuntimeException {
		return hostnameDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(Hostname obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(Hostname obj) throws RuntimeException {
		if(obj.getHostnameId() == null) {
			HostnameDbObj dbObj = mapper.map(obj, HostnameDbObj.class); 
			hostnameDbObjMapper.insert(dbObj);
			obj.setHostnameId(dbObj.getHostnameId());
		}
		else {
			hostnameDbObjMapper.updateByPrimaryKey(mapper.map(obj, HostnameDbObj.class));
		}
		
	}

	@Override
	public void updateByExample(Hostname obj, HostnameDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(Hostname obj, HostnameDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByExample(Hostname obj, HostnameDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}