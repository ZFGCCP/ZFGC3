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
public class BuddyDao extends AbstractDao<BrBuddyIgnoreListDbObjExample, BrBuddyIgnoreListDbObj, Buddy> {

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
	
	public List<Integer> getIgnoreIds(Integer userId){
		List<Integer> result = new ArrayList<>();
		List<BrBuddyIgnoreListDbObj> ignores = null;
		BrBuddyIgnoreListDbObjExample ex = getExample();
		
		ex.createCriteria().andUserAIdEqualTo(userId).andIgnoreFlagEqualTo(true);
		
		ignores = get(ex);
		
		for(BrBuddyIgnoreListDbObj obj : ignores){
			result.add(obj.getUserBId());
		}
		
		return result;
	}

	@Override
	public List<BrBuddyIgnoreListDbObj> get(BrBuddyIgnoreListDbObjExample ex) {
		return brBuddyIgnoreListDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(Buddy obj) {
		BrBuddyIgnoreListDbObj dbObj = mapper.map(obj, BrBuddyIgnoreListDbObj.class);
		brBuddyIgnoreListDbObjMapper.deleteByPrimaryKey(dbObj);
	}

	@Override
	public void updateOrInsert(Buddy obj) {
		BrBuddyIgnoreListDbObj dbObj = mapper.map(obj, BrBuddyIgnoreListDbObj.class);
		if(obj.getAdd()){
			brBuddyIgnoreListDbObjMapper.insert(dbObj);
		}
		else{
			brBuddyIgnoreListDbObjMapper.updateByPrimaryKey(dbObj);
		}
	}

	@Override
	public void updateByExample(Buddy obj, BrBuddyIgnoreListDbObjExample ex) {
		BrBuddyIgnoreListDbObj dbObj = mapper.map(obj, BrBuddyIgnoreListDbObj.class);
		brBuddyIgnoreListDbObjMapper.updateByExample(dbObj,ex);
	}

	@Override
	public Integer deleteByExample(Buddy obj, BrBuddyIgnoreListDbObjExample ex) {
		return null;
		// TODO Auto-generated method stub
		
	}

}
