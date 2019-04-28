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
	public List<BrBuddyIgnoreListDbObj> get(BrBuddyIgnoreListDbObjExample ex) throws RuntimeException {
		return brBuddyIgnoreListDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(Buddy obj) throws RuntimeException {
		BrBuddyIgnoreListDbObj dbObj = mapper.map(obj, BrBuddyIgnoreListDbObj.class);
		brBuddyIgnoreListDbObjMapper.deleteByPrimaryKey(dbObj);
	}

	@Override
	public void updateOrInsert(Buddy obj) throws RuntimeException {
		BrBuddyIgnoreListDbObj dbObj = mapper.map(obj, BrBuddyIgnoreListDbObj.class);
		brBuddyIgnoreListDbObjMapper.insert(dbObj);
	}

	@Override
	public void updateByExample(Buddy obj, BrBuddyIgnoreListDbObjExample ex) throws RuntimeException {
		BrBuddyIgnoreListDbObj dbObj = mapper.map(obj, BrBuddyIgnoreListDbObj.class);
		brBuddyIgnoreListDbObjMapper.updateByExample(dbObj,ex);
	}

	@Override
	public Integer deleteByExample(Buddy obj, BrBuddyIgnoreListDbObjExample ex) throws RuntimeException {
		return brBuddyIgnoreListDbObjMapper.deleteByExample(ex);
	}

	@Override
	public Long countByExample(Buddy obj, BrBuddyIgnoreListDbObjExample ex)
			throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

}
