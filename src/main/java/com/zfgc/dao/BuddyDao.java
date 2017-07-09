package com.zfgc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.BrBuddyIgnoreListDbObj;
import com.zfgc.dbobj.BrBuddyIgnoreListDbObjExample;
import com.zfgc.mappers.BrBuddyIgnoreListDbObjMapper;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.profile.Buddy;

@Component
public class BuddyDao extends AbstractDao<BrBuddyIgnoreListDbObjExample, BrBuddyIgnoreListDbObj> {

	@Autowired
	BrBuddyIgnoreListDbObjMapper brBuddyIgnoreListDbObjMapper;
	
	public List<Integer> getBuddyIds(Integer userId){
		List<Integer> result = new ArrayList<>();
		List<BrBuddyIgnoreListDbObj> buddies = null;
		BrBuddyIgnoreListDbObjExample ex = getExample();
		
		ex.createCriteria().andUserAIdEqualTo(userId).andBuddyFlagEqualTo(true);
		
		buddies = get(ex);
		
		for(BrBuddyIgnoreListDbObj obj : buddies){
			result.add(obj.getUserBId());
		}
		
		return result;
	}

	@Override
	public List<BrBuddyIgnoreListDbObj> get(BrBuddyIgnoreListDbObjExample ex) {
		return brBuddyIgnoreListDbObjMapper.selectByExample(ex);
	}

}
