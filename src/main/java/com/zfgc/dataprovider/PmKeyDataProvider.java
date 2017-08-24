package com.zfgc.dataprovider;

import java.util.List;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.PmKeyDao;
import com.zfgc.dbobj.PmKeyDbObj;
import com.zfgc.dbobj.PmKeyDbObjExample;
import com.zfgc.model.pm.PmKey;
import com.zfgc.util.security.RsaKeyPair;
import com.zfgc.util.security.ZfgcSecurityUtils;

@Component
public class PmKeyDataProvider extends AbstractDataProvider{
	@Autowired
	PmKeyDao pmKeyDao;
	
	public PmKey getPmKeyByUsersId(Integer usersId){
		PmKeyDbObjExample ex = pmKeyDao.getExample();
		ex.createCriteria().andUsersIdEqualTo(usersId);
		
		List<PmKeyDbObj> dbObj = pmKeyDao.get(ex);
		
		return super.mapper.map(dbObj.get(0), PmKey.class);
	}
	
	public void createPmKeyPair(PmKey pmKey){
		pmKeyDao.updateOrInsert(pmKey);
	}
}
