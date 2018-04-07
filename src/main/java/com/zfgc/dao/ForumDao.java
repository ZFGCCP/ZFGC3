package com.zfgc.dao;

import java.util.List;

import org.apache.log4j.Logger;
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
	Logger LOGGER = Logger.getLogger(ForumDao.class);
	
	@Autowired
	ForumDbObjMapper forumDbObjMapper;
	
	public List<ForumDbObj> getForumsByParent(List<Short> parentId, Users user) throws Exception{
		
		StringBuilder sql = new StringBuilder();
		List<Integer> groups = user.getMemberGroups();
		//show all forums this user has permission to read.
		//this includes anything permission with a read or write flag
		//including the guest role
		sql.append("SELECT F.FORUM_ID,F.CATEGORY_ID,F.PARENT_FORUM_ID,F.SEQ_NO,F.NAME,F.DESCRIPTION \n")
		   .append("FROM FORUM F\n")
		   .append("INNER JOIN BR_MEMBER_GROUP_FORUM M ON M.FORUM_ID = F.FORUM_ID AND (");
		   
		   if(groups.size() > 0){
			   sql.append("M.MEMBER_GROUP_ID IN (:secondaryGroups) OR ");
		   }
		   sql.append("M.MEMBER_GROUP_ID = :primaryGroup) \n")
		   .append("WHERE PARENT_FORUM_ID IN (:parentIds)");
		
		if(parentId.contains(null)){
			sql.append(" OR PARENT_FORUM_ID IS NULL");
		}
		
		sql.append(" AND (M.READ_FLAG = 1 OR M.WRITE_FLAG = 1) \n")
		   .append("GROUP BY F.FORUM_ID \n")
		   .append("ORDER BY PARENT_FORUM_ID ASC, SEQ_NO ASC");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("parentIds", parentId);
		params.addValue("secondaryGroups", groups);
		params.addValue("primaryGroup", user.getPrimaryMemberGroupId());
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
	
	public ForumDbObj getForum(Short forumId, Users user) throws ZfgcNotFoundException, Exception{
		StringBuilder sql = new StringBuilder();
		
		List<Integer> groups = user.getMemberGroups();
		
		sql.append("SELECT F.FORUM_ID, F.NAME, F.CATEGORY_ID, F.PARENT_FORUM_ID \n")
		   .append("FROM FORUM F \n")
		   .append("INNER JOIN BR_MEMBER_GROUP_FORUM M ON M.FORUM_ID = F.FORUM_ID AND (");
		
		if(groups.size() > 0){
			sql.append("M.MEMBER_GROUP_ID IN (:secondaryGroups) OR");
		}
		
		sql.append("M.MEMBER_GROUP_ID = :primaryGroupId) \n")
		   .append("WHERE (M.READ_FLAG = 1 OR M.WRITE_FLAG = 1) AND\n")
		   .append("      F.FORUM_ID = :forumId");

		List<ForumDbObj> results = null;
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("secondaryGroups", groups);
		params.addValue("primaryGroupId", user.getPrimaryMemberGroupId());
		params.addValue("forumId",forumId);
		try{
			results = jdbcTemplate.query(sql.toString(), params,new BeanPropertyRowMapper(ForumDbObj.class));
		}
		catch(Exception ex){
			super.logDbSelectError(LOGGER, "FORUM");
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
		
		if(results.size() == 0){
			throw new ZfgcNotFoundException("Forum Id" + forumId);
		}
		
		return results.get(0);
		   
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
	
	public void createNewForumViewPermissions(Integer memberGroupId, List<BrMemberGroupForum> memberGroupForums){
		//TODO
		/*StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO BR_MEMBER_GROUP_FORUM \n")
		   .append("(FORUM_ID,MEMBER_GROUP_ID,READ_FLAG,WRITE_FLAG) \n");
		
		for(BrMemberGroupForum brMemberGroupForum : memberGroupForums){
			sql.append("(")
		}*/
	}

	@Override
	public List<ForumDbObj> get(ForumDbObjExample ex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void hardDelete(Forum obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(Forum obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(Forum obj, ForumDbObjExample ex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(Forum obj, ForumDbObjExample ex) {
		return null;
		// TODO Auto-generated method stub
		
	}
}
