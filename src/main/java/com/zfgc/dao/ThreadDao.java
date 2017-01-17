package com.zfgc.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.ForumDbObj;
import com.zfgc.dbobj.ThreadDbObj;
import com.zfgc.dbobj.ThreadDbObjExample;
import com.zfgc.mappers.ThreadDbObjMapper;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.Users;

@Component
public class ThreadDao extends AbstractDao {
	Logger LOGGER = Logger.getLogger(ThreadDao.class);
	
	@Autowired
	ThreadDbObjMapper threadDbObjMapper;
	
	public Integer getNumberOfThreadsInForum(Short forumId){
		ThreadDbObjExample threadDbObjExample = new ThreadDbObjExample();
		threadDbObjExample.createCriteria().andParentForumIdEqualTo(forumId);
		
		return threadDbObjMapper.countByExample(threadDbObjExample);
	}
	
	public List<ThreadDbObj> getThreadsByParentForumId(Short parentForumId, Integer itemsPerPage, Integer pageNo, Boolean stickyOnly, Users user) throws Exception{
		StringBuilder sql = new StringBuilder();
		List<Integer> groups = user.getMemberGroups();
		
		
		
		sql.append("SELECT RANK, THREAD_ID,NAME,THREAD_STARTER_ID,AUTHOR_NAME,VIEWS,POST_ICON_ID,NEW_POSTS_FLAG,POST_STATUS_ID,LOCKED_FLAG,STICKY_FLAG,POLL_FLAG,PARENT_FORUM_ID FROM \n")
		   .append("(SELECT (@RANK := @RANK + 1) AS RANK, T.THREAD_ID,T.NAME,T.THREAD_STARTER_ID,U.DISPLAY_NAME AS AUTHOR_NAME,T.VIEWS,T.POST_ICON_ID,T.NEW_POSTS_FLAG,T.POST_STATUS_ID,T.LOCKED_FLAG,T.STICKY_FLAG,T.POLL_FLAG,T.PARENT_FORUM_ID \n")
		   .append("FROM THREAD T \n")
		   .append("INNER JOIN users U ON U.USERS_ID = T.THREAD_STARTER_ID \n")
		   .append("INNER JOIN FORUM F ON F.FORUM_ID = T.PARENT_FORUM_ID \n")
		   .append("INNER JOIN BR_MEMBER_GROUP_FORUM M ON M.FORUM_ID = F.FORUM_ID AND (");
		
		if(groups.size() > 0){
			sql.append("M.MEMBER_GROUP_ID IN (:secondaryGroups) OR ");
		}
		
		sql.append("M.MEMBER_GROUP_ID = :primaryGroup) \n")
		   .append("JOIN (SELECT @RANK := 0) R \n")
		   .append("WHERE T.PARENT_FORUM_ID = :parentForumId \n")
		   .append("AND (M.READ_FLAG = 1 OR M.WRITE_FLAG = 1) \n");
		
		if(stickyOnly){
			sql.append("AND T.STICKY_FLAG = 1");
		}
		
		sql.append(") AS TOPICS \n");
		
		sql.append("WHERE ")
		   .append("RANK >= :lowerBound AND RANK <= :upperBound");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("secondaryGroups", groups);
		params.addValue("primaryGroup", user.getPrimaryMemberGroupId());
		params.addValue("parentForumId", parentForumId);
		params.addValue("lowerBound", itemsPerPage * pageNo - itemsPerPage + 1);
		params.addValue("upperBound", itemsPerPage * pageNo);
		
		try{
			return jdbcTemplate.query(sql.toString(), params, new BeanPropertyRowMapper(ThreadDbObj.class));
		}
		catch(Exception ex){
			super.logDbGeneralError(LOGGER, "FORUM");
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
		
		
	}

	@Override
	public Boolean validateIntegrity(BaseZfgcModel model) {
		// TODO Auto-generated method stub
		return null;
	}
}
