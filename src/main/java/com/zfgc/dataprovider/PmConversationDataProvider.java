package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.PmConversationBoxViewDao;
import com.zfgc.dao.PmConversationDao;
import com.zfgc.dbobj.PmConversationBoxViewDbObj;
import com.zfgc.dbobj.PmConversationBoxViewDbObjExample;
import com.zfgc.dbobj.PmConversationBoxViewDbObjWithBLOBs;
import com.zfgc.model.pm.PmConversation;
import com.zfgc.model.pm.PmConversationView;
import com.zfgc.util.time.ZfgcTimeUtils;

@Component
public class PmConversationDataProvider extends AbstractDataProvider{
	
	@Autowired
	PmConversationDao pmConversationDao;
	
	@Autowired
	PmConversationBoxViewDao pmConversationBoxViewDao;
	
	public PmConversation createConversation(){
		PmConversation obj = new PmConversation();
		obj.setStartDt(ZfgcTimeUtils.getToday());
		
		pmConversationDao.updateOrInsert(obj);
		
		return obj;
	}
	
	public List<PmConversationView> getBoxViewByUsersId(Integer usersId) throws Exception{
		PmConversationBoxViewDbObjExample ex = new PmConversationBoxViewDbObjExample();
		ex.createCriteria().andUsersIdEqualTo(usersId);
		
		try {
			List<PmConversationBoxViewDbObjWithBLOBs> dbObj = pmConversationBoxViewDao.get(ex);
			List<PmConversationView> result = new ArrayList<>();
			
			for(PmConversationBoxViewDbObjWithBLOBs obj : dbObj){
				result.add(mapper.map(obj, PmConversationView.class));
			}
			
			return result;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} 
		
		
	}
}