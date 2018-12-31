package com.zfgc.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.MemberListingViewDbObj;
import com.zfgc.dbobj.MemberListingViewDbObjExample;
import com.zfgc.mappers.MemberListingViewDbObjMapper;
import com.zfgc.model.users.MemberListingView;

@Component
public class MemberListViewDao extends AbstractDao<MemberListingViewDbObjExample, MemberListingViewDbObj, MemberListingView>{

	@Autowired
	private MemberListingViewDbObjMapper memberListingViewDbObjMapper;
	
	@Override
	public List<MemberListingViewDbObj> get(MemberListingViewDbObjExample ex) throws Exception {
		try{
			return memberListingViewDbObjMapper.selectByExample(ex);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void hardDelete(MemberListingView obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(MemberListingView obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(MemberListingView obj, MemberListingViewDbObjExample ex) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(MemberListingView obj, MemberListingViewDbObjExample ex) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countByExample(MemberListingView obj, MemberListingViewDbObjExample ex) throws Exception {
		return null;
	}

    
    
}