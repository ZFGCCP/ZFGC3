package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.dao.MemberListViewDao;
import com.zfgc.dao.UsersDao;
import com.zfgc.dbobj.MemberListingViewDbObj;
import com.zfgc.dbobj.MemberListingViewDbObjExample;
import com.zfgc.dbobj.UsersDbObj;
import com.zfgc.dbobj.UsersDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.users.EmailAddress;
import com.zfgc.model.users.IpAddress;
import com.zfgc.model.users.MemberListingView;
import com.zfgc.model.users.Users;
import com.zfgc.util.time.ZfgcTimeUtils;

@Component
@Transactional
public class UsersDataProvider extends AbstractDataProvider {
	@Autowired
	private DozerBeanMapper mapper;
	
	@Autowired 
	private UsersDao usersDao;
	
	@Autowired
	private IpDataProvider ipDataProvider;
	
	@Autowired 
	private AuthenticationDataProvider authenticationDataProvider;
	
	@Autowired
	private AvatarDataProvider avatarDataProvider;
	
	@Autowired
	private MemberListViewDao memberListingViewDao;
	
	Logger LOGGER = Logger.getLogger(UsersDataProvider.class);
	
	public Users getUserByToken(String token) throws Exception{
		try{
			UsersDbObj dbObj = usersDao.getUserByToken(token);
			return mapper.map(dbObj, Users.class);
		}
		catch(ZfgcNotFoundException ex){
			throw new ZfgcNotFoundException(ex.getResourceName());
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	public List<Users> getUsersByConversation(Integer conversationId) throws ZfgcNotFoundException, Exception{
		try{
			List<UsersDbObj> dbObj = usersDao.getUsersByConversation(conversationId);
			List<Users> users = new ArrayList<>();
			
			for(UsersDbObj db : dbObj){
				users.add(mapper.map(db, Users.class));
			}
			
			return users;
			
		}
		catch(ZfgcNotFoundException ex){
			throw new ZfgcNotFoundException(ex.getResourceName());
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	@Transactional
	public Users createUser(Users user) throws Exception{
		
		try {
			//log Ip Address
			logIpAddress(user.getPrimaryIpAddress(),true);
			
			//log email address
			logEmailAddress(user.getEmailAddress());
			
			UsersDbObj usersDbObj = usersDao.createUser(user);
			user.setUsersId(usersDbObj.getUsersId());
			
			return user;
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@Transactional
	public void setLogintime(Date loginTime,Users user){
		UsersDbObjExample ex = usersDao.getExample();
		ex.createCriteria().andUsersIdEqualTo(user.getUsersId());
		
		Users update = new Users();
		update.setLastLogin(loginTime);
	}
	
	private void logIpAddress(IpAddress ipAddress, Boolean newUser){
		try{
			authenticationDataProvider.logIpAddress(ipAddress);
		}
		catch(Exception ex){
			if(newUser){
				LOGGER.info("IP Address " + ipAddress.getIpAddress() + " already exists.");
			}
		}
	}
	
	private  void logEmailAddress(EmailAddress emailAddress) throws Exception{
		try{
			authenticationDataProvider.logEmailAddress(emailAddress);
		}
		catch(Exception ex){
			LOGGER.info("Email Address " + emailAddress.getEmailAddress() + " already exists.");
			throw new Exception("Email Address " + emailAddress.getEmailAddress() + " already exists.");
		}
	}
	
	public Boolean doesLoginNameExist(String loginName) throws Exception{
		return usersDao.doesLoginNameExist(loginName);
	}
	
	public Boolean doesDisplayNameExist(String displayName) throws Exception{
		return usersDao.doesDisplayNameExist(displayName);
	}
	
	public Users getUserByLoginName(String loginName) throws Exception{
		try{
			return usersDao.getUserByLoginName(loginName);
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	public Integer incrementLoginFailCount(String loginName) throws Exception{
		try{
			return usersDao.incrementLoginFails(loginName);
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	public void lockAccount(String loginName, Date lockTime) throws Exception{
		try{
			usersDao.lockAccount(loginName, lockTime);
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	public void unlockAccount(String loginName) throws Exception{
		try{
			usersDao.unlockAccount(loginName);
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	public Date getLockTime(String loginName) throws Exception{
		try{
			return usersDao.getAccountLockTime(loginName);
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}

	public void linkUserToIp(Users user, IpAddress ipAddress, Boolean setPrimary) throws Exception {
		try{
			usersDao.linkUserToIp(user,ipAddress,setPrimary);
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	public String getLoginNameByToken(String token){
		return usersDao.getLoginNameByToken(token);
	}
	
	public Boolean getActiveFlagByToken(String token){
		return usersDao.getActiveFlagByToken(token);
	}
	
	public List<String> getMemberGroupNames(Integer usersId){
		return usersDao.getMemberGroups(usersId);
	}
	
	public List<Integer> getMemberGroupsByToken(String token){
		return usersDao.getMemberGroupsByToken(token);
	}
	
	public Integer getPrimaryMemberGroupByToken(String token){
		return usersDao.getPrimaryMemberGroupByToken(token);
	}
	
	public Integer getUsersIdByToken(String token){
		return usersDao.getUsersIdByToken(token);
	}

	public Integer getPrimaryMemberGroupIdByToken(String token) {
		return usersDao.getPrimaryMemberGroupIdByToken(token);
	}
	
	public List<Users> simpleUserSearch(String displayNameQuery, Integer start, Integer length){
		UsersDbObjExample ex = usersDao.getExample();
		ex.createCriteria().andDisplayNameLike("%" + displayNameQuery + "%").andActiveFlagEqualTo(true);
		ex.or(ex.createCriteria().andEmailAddressLike("%" + displayNameQuery + "%").andActiveFlagEqualTo(true));
		
		List<UsersDbObj> db = usersDao.get(ex);
		List<Users> result = new ArrayList<>();
		
		
		if(start < db.size()){
			for(int i = start; i < start + length && i < db.size(); i++){
				UsersDbObj dbUser = db.get(i);	
				
				Users user = mapper.map(dbUser, Users.class);
				try {
					user.setAvatar(avatarDataProvider.getAvatar(dbUser.getAvatarId()));
				} catch (ZfgcNotFoundException e) {
					user.setAvatar(null);
				}
				result.add(user);
			}
		}
		
		return result;
	}
	
	public String getDisplayName(Integer usersId){
		return usersDao.getDisplayName(usersId);
	}
	
	public List<MemberListingView> getMemberListing(Integer pageIndex, Integer usersPerPage) throws Exception{
		MemberListingViewDbObjExample ex = memberListingViewDao.getExample();
		ex.setLimitStart(pageIndex * usersPerPage);
		ex.setLimitRange(usersPerPage);
		
		List<MemberListingViewDbObj> dbObj = memberListingViewDao.get(ex);
		
		Map<Integer, MemberListingView> mapping = new HashMap<>();
		
		for(MemberListingViewDbObj obj : dbObj) {
			if(!mapping.containsKey(obj.getUsersId())) {
				mapping.put(obj.getUsersId(), mapper.map(obj, MemberListingView.class));
			}
			
			mapping.get(obj.getUsersId()).getMemberGroups().add(obj.getGroupName());
		}
		
		return new ArrayList<>(mapping.values());
		
	}
}
