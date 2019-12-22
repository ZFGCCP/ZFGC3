package com.zfgc.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.ForumDbObj;
import com.zfgc.dbobj.ForumDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.mappers.ForumDbObjMapper;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.forum.BrMemberGroupForum;
import com.zfgc.model.forum.Forum;
import com.zfgc.model.users.Users;

@Component
public class ForumDao extends AbstractDao<ForumDbObjExample, ForumDbObj, Forum> {
	private Logger LOGGER = LogManager.getLogger(ForumDao.class);
	
	@Autowired
	ForumDbObjMapper forumDbObjMapper;

	@Override
	public List<ForumDbObj> get(ForumDbObjExample ex) throws RuntimeException {
		return forumDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(Forum obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(Forum obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(Forum obj, ForumDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(Forum obj, ForumDbObjExample ex) throws RuntimeException {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long countByExample(Forum obj, ForumDbObjExample ex)
			throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
}
