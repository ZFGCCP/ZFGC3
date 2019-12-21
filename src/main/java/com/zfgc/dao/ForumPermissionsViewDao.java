package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.ForumPermissionsViewDbObj;
import com.zfgc.dbobj.ForumPermissionsViewDbObjExample;
import com.zfgc.mappers.ForumPermissionsViewDbObjMapper;
import com.zfgc.model.forum.ForumPermissionsView;

@Component
public class ForumPermissionsViewDao extends AbstractDao<ForumPermissionsViewDbObjExample, ForumPermissionsViewDbObj, ForumPermissionsView> {

	@Autowired
	private ForumPermissionsViewDbObjMapper forumPermissionsViewDbObjMapper;
	
	@Override
	public List<ForumPermissionsViewDbObj> get(ForumPermissionsViewDbObjExample ex) throws RuntimeException {
		return forumPermissionsViewDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(ForumPermissionsView obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(ForumPermissionsView obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(ForumPermissionsView obj, ForumPermissionsViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(ForumPermissionsView obj, ForumPermissionsViewDbObjExample ex)
			throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByExample(ForumPermissionsView obj, ForumPermissionsViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

}
