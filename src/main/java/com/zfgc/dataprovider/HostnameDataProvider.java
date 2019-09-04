package com.zfgc.dataprovider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.HostnameDao;
import com.zfgc.dbobj.HostnameDbObj;
import com.zfgc.dbobj.HostnameDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.users.Hostname;

@Component
public class HostnameDataProvider extends AbstractDataProvider {

	@Autowired
	private HostnameDao hostnameDao;
	
	public void saveHost(Hostname hostname) {
		hostnameDao.updateOrInsert(hostname);
	}
	
	public Hostname getHost(String hostname) {
		HostnameDbObjExample ex = hostnameDao.getExample();
		ex.createCriteria().andHostnameEqualTo(hostname);
		List<HostnameDbObj> hostDb = hostnameDao.get(ex);
		
		if(hostDb.size() == 0) {
			throw new ZfgcNotFoundException("hostname " + hostname);
		}
		
		return mapper.map(hostDb.get(0), Hostname.class);
	}
	
	public Hostname getHost(Integer hostnameId) {
		HostnameDbObjExample ex = hostnameDao.getExample();
		ex.createCriteria().andHostnameIdEqualTo(hostnameId);
		List<HostnameDbObj> hostDb = hostnameDao.get(ex);
		
		if(hostDb.size() == 0) {
			throw new ZfgcNotFoundException("hostnameId " + hostnameId);
		}
		
		return mapper.map(hostDb.get(0), Hostname.class);
	}
	
}
