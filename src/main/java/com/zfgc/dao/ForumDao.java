package com.zfgc.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.ForumDbObj;
import com.zfgc.dbobj.ForumDbObjExample;
import com.zfgc.mappers.ForumDbObjMapper;

@Component
public class ForumDao extends AbstractDao {
	Logger LOGGER = Logger.getLogger(ForumDao.class);
	
	@Autowired
	ForumDbObjMapper forumDbObjMapper;
	
	public List<ForumDbObj> getForumsByParent(Short parentId) throws Exception{
		ForumDbObjExample forumDbObjExample = new ForumDbObjExample();
		forumDbObjExample.createCriteria().andParentForumIdEqualTo(parentId);
		
		try{
		return forumDbObjMapper.selectByExample(forumDbObjExample);
		}
		catch(Exception ex){
			super.logDbGeneralError(LOGGER, "FORUM");
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
	}
	
	public List<ForumDbObj> getForumsByParent(List<Short> parentId) throws Exception{
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT FORUM_ID,CATEGORY_ID,PARENT_FORUM_ID,SEQ_NO,NAME,DESCRIPTION \n")
		   .append("FROM FORUM \n")
		   .append("WHERE PARENT_FORUM_ID IN (:parentIds)");
		
		if(parentId.contains(null)){
			sql.append(" OR PARENT_FORUM_ID IS NULL");
		}
		
		sql.append(" ORDER BY PARENT_FORUM_ID ASC, SEQ_NO ASC");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("parentIds", parentId);
		try{
			return jdbcTemplate.query(sql.toString(), params, new BeanPropertyRowMapper(ForumDbObj.class));
		}
		catch(Exception ex){
			super.logDbGeneralError(LOGGER, "FORUM");
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
	}
	
	public List<ForumDbObj> getForumsByCategory(Integer categoryId) throws Exception{
		ForumDbObjExample forumDbObjExample = new ForumDbObjExample();
		forumDbObjExample.createCriteria().andCategoryIdEqualTo(categoryId);
		
		try{
		return forumDbObjMapper.selectByExample(forumDbObjExample);
		}
		catch(Exception ex){
			super.logDbGeneralError(LOGGER, "FORUM");
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
	}
	
	public List<ForumDbObj> getForumsByCategory(List<Integer> categoryId) throws Exception{
		ForumDbObjExample forumDbObjExample = new ForumDbObjExample();
		forumDbObjExample.createCriteria().andCategoryIdIn(categoryId);
		
		try{
		return forumDbObjMapper.selectByExample(forumDbObjExample);
		}
		catch(Exception ex){
			super.logDbGeneralError(LOGGER, "FORUM");
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
	}
}
