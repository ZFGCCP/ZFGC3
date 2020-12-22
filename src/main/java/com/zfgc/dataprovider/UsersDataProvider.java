package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.dao.MemberListViewDao;
import com.zfgc.dao.NotificationSettingsDao;
import com.zfgc.dao.PersonalMessagingSettingsDao;
import com.zfgc.dao.UserContactSettingsDao;
import com.zfgc.dao.UserPersonalInfoDao;
import com.zfgc.dao.UserSecuritySettingsDao;
import com.zfgc.dao.UsersDao;
import com.zfgc.dbobj.MemberListingViewDbObj;
import com.zfgc.dbobj.MemberListingViewDbObjExample;
import com.zfgc.dbobj.UserPersonalInfoDbObjExample;
import com.zfgc.dbobj.UsersDbObj;
import com.zfgc.dbobj.UsersDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.pm.BrUserConversation;
import com.zfgc.model.users.EmailAddress;
import com.zfgc.model.users.IpAddress;
import com.zfgc.model.users.MemberListingView;
import com.zfgc.model.users.UserContactInfo;
import com.zfgc.model.users.UserSecurityInfo;
import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.PersonalInfo;
import com.zfgc.util.time.ZfgcTimeUtils;

@Component
public class UsersDataProvider extends AbstractDataProvider {
	@Autowired
	private DozerBeanMapper mapper;
	
	@Autowired 
	private UsersDao usersDao;
	
	@Autowired 
	private AuthenticationDataProvider authenticationDataProvider;
	
	@Autowired
	private AvatarDataProvider avatarDataProvider;
	
	@Autowired
	private MemberListViewDao memberListingViewDao;
	
	@Autowired
	private UserContactSettingsDao userContactSettingsDao;
	
	@Autowired
	private UserSecuritySettingsDao userSecuritySettingsDao;
	
	@Autowired
	private UserPersonalInfoDao userPersonalInfoDao;
	
	@Autowired
	private PersonalMessagingSettingsDao personalMessagingSettingsDao;
	
	@Autowired
	private NotificationSettingsDao notificationSettingsDao;
	
	@Autowired
	private PmConversationDataProvider pmConversationDataProvider;
	
	private Logger LOGGER = LogManager.getLogger(UsersDataProvider.class);
	
	public PersonalInfo getPersonalInfo(Integer usersId) {
		UserPersonalInfoDbObjExample ex = userPersonalInfoDao.getExample();
		ex.createCriteria().andUsersIdEqualTo(usersId);
		
		return mapper.map(userPersonalInfoDao.get(ex).get(0), PersonalInfo.class);
	}
	
	public Users getUser(Integer usersId) {
		UsersDbObjExample ex = usersDao.getExample();
		ex.createCriteria().andUsersIdEqualTo(usersId);
		
		return mapper.map(usersDao.get(ex).get(0), Users.class);
		
	}
	
	public Users getUser(String username) {
		UsersDbObjExample ex = usersDao.getExample();
		ex.createCriteria().andLoginNameEqualTo(username);
		
		List<UsersDbObj> result = usersDao.get(ex);
		
		if(result.size() == 0) {
			throw new ZfgcNotFoundException("user " + username);
		}
		
		return mapper.map(result.get(0), Users.class);
	}
	
	public void saveUser(Users user) {
		UsersDbObjExample ex = usersDao.getExample();
		ex.createCriteria().andUsersIdEqualTo(user.getUsersId());
		usersDao.updateByExample(user, ex);
	}
	
	public List<Users> getUsersByConversation(Integer conversationId) throws ZfgcNotFoundException, RuntimeException{
		try{
			List<BrUserConversation> dbObj = pmConversationDataProvider.getUsersByConversation(conversationId);
			List<Users> users = new ArrayList<>();
			
			for(BrUserConversation db : dbObj){
				users.add(mapper.map(db, Users.class));
			}
			
			return users;
			
		}
		catch(ZfgcNotFoundException ex){
			throw new ZfgcNotFoundException(ex.getResourceName());
		}
		catch(RuntimeException ex){
			throw ex;
		}
	}
	
	public Users createUser(Users user) throws RuntimeException{
		
		try {
			UsersDbObj usersDbObj = usersDao.createUser(user);
			user.setUsersId(usersDbObj.getUsersId());
			
			createContactInfo(user);
			createPersonalInfo(user);
			createUserSecuritySettings(user);
			createUserPersonalMessagingSettings(user);
			createUserNotificationSettings(user);
			
			//ogIpAddress(user.getPrimaryIpAddress(),true);
			
			//log email address
			//logEmailAddress(user.getUserContactInfo().getEmail());
			
			return user;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
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
	
	public Boolean doesLoginNameExist(String loginName) throws RuntimeException{
		UsersDbObjExample ex = usersDao.getExample();
		ex.createCriteria().andLoginNameEqualTo(loginName);
		
		return usersDao.countByExample(null, ex) > 0;
	}
	
	public Boolean doesDisplayNameExist(String displayName) throws RuntimeException{
		UsersDbObjExample ex = usersDao.getExample();
		ex.createCriteria().andDisplayNameEqualTo(displayName);
		
		return usersDao.countByExample(null, ex) > 0;
	}
	
	public Users getUserByLoginName(String loginName) throws RuntimeException{
		try{
			UsersDbObjExample ex = usersDao.getExample();
			ex.createCriteria().andLoginNameEqualTo(loginName);
			List<UsersDbObj> result = usersDao.get(ex);
			
			if(result.size() == 0) {
				throw new ZfgcNotFoundException("loginName " + loginName);
			}
			
			return mapper.map(result.get(0), Users.class);
		}
		catch(RuntimeException ex){
			throw ex;
		}
	}

	public List<Users> simpleUserSearch(String displayNameQuery, Integer start, Integer length){
		UsersDbObjExample ex = usersDao.getExample();
		ex.createCriteria().andDisplayNameLike("%" + displayNameQuery + "%").andActiveFlagEqualTo(true);
		//ex.or(ex.createCriteria().andEmailAddressLike("%" + displayNameQuery + "%").andActiveFlagEqualTo(true));
		
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
	
	public List<MemberListingView> getMemberListing(Integer pageIndex, Integer usersPerPage, Users user, String sortBy, String sortOrder) throws RuntimeException{
		MemberListingViewDbObjExample ex = memberListingViewDao.getExample();
		
		if(!user.isModerationStaff()) {
			ex.createCriteria().andActiveFlagEqualTo(true);
		}
		
		ex.setLimitStart(pageIndex * usersPerPage);
		ex.setLimitRange(usersPerPage);
		
		ex.setOrderByClause(sortBy + " " + sortOrder);
		
		List<MemberListingViewDbObj> dbObj = memberListingViewDao.get(ex);
		
		return dbObj.stream()
				    .map(x -> mapper.map(x, MemberListingView.class))
					.collect(Collectors.toList());
		
	}
	
	public Boolean checkUserPassword(Integer usersId, String password) throws RuntimeException{
		return usersDao.checkUserPassword(usersId, password) > 0;
	}
	
	public void setUserOnline(Users user) throws RuntimeException{
		UsersDbObjExample userEx = usersDao.getExample();
		userEx.createCriteria().andUsersIdEqualTo(user.getUsersId());

		usersDao.updateByExample(user, userEx);
	}
	
	public void setUserOffline(Users user) throws Exception{
		UsersDbObjExample userEx = usersDao.getExample();
		userEx.createCriteria().andUsersIdEqualTo(user.getUsersId());
		
		usersDao.updateByExample(user, userEx);
	}
	
	private void createContactInfo(Users user) throws Exception{
		user.getUserContactInfo().setUsersId(user.getUsersId());
		userContactSettingsDao.updateOrInsert(user.getUserContactInfo());
	}
	
	private void createPersonalInfo(Users user) throws Exception{
		avatarDataProvider.createAvatarRecord(user.getPersonalInfo().getAvatar());
		
		user.getPersonalInfo().setUsersId(user.getUsersId());
		userPersonalInfoDao.updateOrInsert(user.getPersonalInfo());
	}
	
	private void createUserSecuritySettings(Users user) throws Exception{
		user.getUserSecurityInfo().setUsersId(user.getUsersId());
		userSecuritySettingsDao.updateOrInsert(user.getUserSecurityInfo());
	}
	
	private void createUserPersonalMessagingSettings(Users user) throws RuntimeException{
		user.getPersonalMessagingSettings().setUsersId(user.getUsersId());
		personalMessagingSettingsDao.updateOrInsert(user.getPersonalMessagingSettings());
	}
	
	private void createUserNotificationSettings(Users user) throws RuntimeException{
		user.getNotificationSettings().setUsersId(user.getUsersId());
		notificationSettingsDao.updateOrInsert(user.getNotificationSettings());
	}
	
	public void activateUser(String activationCode) throws RuntimeException{
		UsersDbObjExample ex = usersDao.getExample();
		ex.createCriteria().andEmailActivationCodeEqualTo(activationCode);
		
		Users user = new Users();
		user.setEmailActivationCode(activationCode);
		user.setActiveFlag(true);
		
		usersDao.updateByExample(user, ex);
	}
	
	public void activateUser(Integer usersId) throws RuntimeException{
		UsersDbObjExample ex = usersDao.getExample();
		ex.createCriteria().andUsersIdEqualTo(usersId);
		
		Users user = new Users();
		user.setActiveFlag(true);
		
		usersDao.updateByExample(user, ex);
	}
	
	public void resetActiveConnectionCounts() throws RuntimeException {
		UsersDbObjExample ex = usersDao.getExample();
		ex.createCriteria().andActiveConnectionsGreaterThan(0);
		
		Users user = new Users();
		user.setPrimaryMemberGroupId(null);
		user.setActiveConnections(0);
		
		usersDao.updateByExample(user, ex);
	}
	
	public Long getActiveUsersCount() throws RuntimeException {
		MemberListingViewDbObjExample ex = memberListingViewDao.getExample();
		return memberListingViewDao.countByExample(null, ex);
	}
	
	public Users getMostRecentMember() {
		return mapper.map(usersDao.getMostRecentMember(), Users.class);
	}
}
