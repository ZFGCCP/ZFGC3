package com.zfgc.services.users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.dao.LookupDao;
import com.zfgc.dataprovider.EmailAddressDataProvider;
import com.zfgc.dataprovider.UsersDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.model.users.AuthToken;
import com.zfgc.model.users.EmailAddress;
import com.zfgc.model.users.IpAddress;
import com.zfgc.model.users.MemberListingView;
import com.zfgc.model.users.UserContactInfo;
import com.zfgc.model.users.UserSecurityInfo;
import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.PersonalInfo;
import com.zfgc.requiredfields.users.UsersRequiredFieldsChecker;
import com.zfgc.rules.users.UsersRuleChecker;
import com.zfgc.services.AbstractService;
import com.zfgc.services.RuleRunService;
import com.zfgc.services.authentication.AuthenticationService;
import com.zfgc.services.ip.IpAddressService;
import com.zfgc.services.lookups.LookupService;
import com.zfgc.services.pm.PmService;
import com.zfgc.util.ZfgcEmailUtils;
import com.zfgc.util.security.ZfgcSecurityUtils;
import com.zfgc.util.time.ZfgcTimeUtils;
import com.zfgc.validation.uservalidation.UserValidator;
import com.zfgc.model.avatar.Avatar;

@Service
public class UsersService extends AbstractService {
	@Autowired 
	AuthenticationService authenticationService;
	
	@Autowired
	UsersDataProvider usersDataProvider;
	
	@Autowired
	IpAddressService ipAddressService;
	
	@Autowired
	EmailAddressDataProvider emailAddressDataProvider;
	
	@Autowired
	private ZfgcEmailUtils zfgcEmailUtils;
	
	@Autowired 
	UsersRequiredFieldsChecker requiredFieldsChecker;
	
	@Autowired
	UserValidator validator;
	
	@Autowired
	UsersRuleChecker ruleChecker;
	
	@Autowired
	PmService pmService;
	
	@Autowired
	RuleRunService<Users> ruleRunner;
	
	Logger LOGGER = Logger.getLogger(UsersService.class);

	
	public List<Users> getUsersByConversation(Integer conversationId) throws Exception{
		List<Users> result = null;
		
		try{
			result = usersDataProvider.getUsersByConversation(conversationId);
		}
		catch(ZfgcNotFoundException ex){
			ex.printStackTrace();
			throw new ZfgcNotFoundException(ex.getResourceName());
		}
		catch(Exception ex){
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
		
		return result;
	}
	
	@Transactional
	public Users createNewUser(Users user, HttpServletRequest requestHeader) throws Exception{
		
		
		try {
			user.setTimeOffsetLkup(lookupService.getLkupValue(LookupService.TIMEZONE, user.getTimeOffset()));
			ruleRunner.runRules(validator, requiredFieldsChecker, ruleChecker, user, user);
		} 
		catch(ZfgcValidationException ex){
			ex.printStackTrace();
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		
		if(!user.getErrors().hasErrors()){
			user.getUserHashInfo().setPassSalt(authenticationService.generateSalt());
			
			user.setDateRegistered(ZfgcTimeUtils.getToday(user.getTimeOffsetLkup()));
			user.setActiveFlag(false);
			generateUniqueActivationCode(user);
			
			user.setPrimaryIpAddress(ipAddressService.createIpAddress(requestHeader.getRemoteAddr()));
			
			try {
				setUserIsSpammer(user);
				
				user.getUserContactInfo().setEmail(emailAddressDataProvider.createNewEmail(user.getUserContactInfo().getEmail()));
				Avatar avatar = new Avatar();
				avatar.setAvatarTypeId(1);
				
				user = usersDataProvider.createUser(user);
				loggingService.logAction(7, "User account created for " + user.getLoginName(), user.getUsersId(), user.getPrimaryIpAddress().getIpAddress());
				
				if(!user.getUserContactInfo().getEmail().getIsSpammerFlag()) {
					String subject = "New Account Activation For ZFGC";
					String body = "Hello " + user.getDisplayName() + ", below you will find an activation link for your account on ZFGC.<br>" +
								  "If you think you have received this email in error, please ignore it.<br><br>" +
								  "http://localhost:8080/forum/zfgcui/useractivation?activationCode=" + user.getEmailActivationCode();
					
					InternetAddress to = new InternetAddress(user.getUserContactInfo().getEmail().getEmailAddress(), user.getDisplayName());
					zfgcEmailUtils.sendEmail(subject, body, to);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				throw ex;
			}
		}
		return user;
	}
	
	public Boolean checkUserPassword(String password, String userName){
		try{
			Users user = new Users();
			user.setPassword(password);
			user.setLoginName(userName);
			return authenticationService.checkUserPassword(user);
		}
		catch(Exception ex){
			return false;
		}
	}
	
	public IpAddress setPrimaryIp(Users user, String ipAddress) throws Exception{
		IpAddress ip = ipAddressService.createIpAddress(ipAddress);
	    linkUserToIp(user,ip,true);
		return ip;
	}
	
	public void setUserIsSpammer(Users user) throws Exception{
		user.getPrimaryIpAddress().setIsSpammerFlag(authenticationService.checkIpIsSpammer(user.getPrimaryIpAddress()));
		user.getUserContactInfo().getEmail().setIsSpammerFlag(authenticationService.checkEmailIsSpammer(user.getUserContactInfo().getEmail()));
	}
	
	public Users authenticateUserByToken(String token) throws Exception{
		try{
			return authenticationService.authenticateWithToken(token);
		}
		catch(ZfgcNotFoundException ex){
			throw new ZfgcNotFoundException(ex.getResourceName());
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	@Transactional
	public Users authenticateUser(Users user, String sourceIp) throws Exception{
		IpAddress ipAddress = ipAddressService.createIpAddress(sourceIp);
		Boolean doesUserExist = doesLoginNameExist(user.getLoginName());
		if(isAccountLocked(user) || ipAddressService.isIpLocked(ipAddress)){
			loggingService.logAction(7, "Login failed for user " + user.getLoginName() + ". Account is locked.", null, sourceIp);
			user.getErrors().getGeneralErrors().add("You have exceeded the allowed number of login attempts.  Please try again later.");
		}
		else if (doesUserExist && authenticationService.checkUserPassword(user)){
			Users authenticatedUser = usersDataProvider.getUserByLoginName(user.getLoginName());
			loggingService.logAction(7, "Login success for user " + user.getLoginName(), authenticatedUser.getUsersId(), sourceIp);
			setPrimaryIp(authenticatedUser,sourceIp);
			String token = authenticationService.generateAuthenticationToken(authenticatedUser, authenticatedUser.getTtlLogin());
			authenticatedUser.setAuthToken(token);
			return authenticatedUser;
		}
		else{
			Integer attempts = 0;
			if(doesUserExist){
				attempts = usersDataProvider.incrementLoginFailCount(user.getLoginName());
			}
			Integer ipAttempts = ipAddressService.incrementLoginFailCount(ipAddress);

			user.getErrors().getGeneralErrors().add("Login failed for user " + user.getLoginName() + ". Incorrect username or password.  " + (5 - ipAttempts) + " attempts remaining.");
			loggingService.logAction(3, "Login failed for user " + user.getLoginName() + ". " + (5 - ipAttempts) + " attempts remaining.", null, sourceIp);
			
			if(attempts >= 5){
				lockAccount(user.getLoginName(), sourceIp);
			}
			if(ipAttempts >= 5){
				ipAddressService.lockIp(ipAddress);
			}
		}
		return user;
	}
	
	private Boolean lockAccount(String loginName, String sourceIp){
		Date lockTime = ZfgcTimeUtils.getToday();
		lockTime = DateUtils.addMinutes(lockTime, 10);
		try {
			usersDataProvider.lockAccount(loginName,lockTime);
			loggingService.logAction(3, "Account for " + loginName + " locked.", null, sourceIp);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Boolean isAccountLocked(Users user){
		try{
			Date lockTime = usersDataProvider.getLockTime(user.getLoginName());
			user.setLockedUntil(lockTime);
			
			if(lockTime != null && lockTime.compareTo(ZfgcTimeUtils.getToday()) < 0){
				unlockAccount(user.getLoginName());
				return false;
			}
			if(lockTime != null && lockTime.compareTo(ZfgcTimeUtils.getToday()) >= 0){
				return true;
			}
			
			return false;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	private Boolean unlockAccount(String loginName){
		try{
			usersDataProvider.unlockAccount(loginName);
			loggingService.logAction(7, "Account for " + loginName + " unlocked.", null, "127.0.0.1");
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Boolean doesLoginNameExist(String loginName) throws Exception {
		return usersDataProvider.doesLoginNameExist(loginName);
	}
	
	public Boolean doesDisplayNameExist(String loginName) throws Exception {
		return usersDataProvider.doesDisplayNameExist(loginName);
	}

	private void linkUserToIp(Users user, IpAddress ipAddress, Boolean isPrimary) throws Exception{
		usersDataProvider.linkUserToIp(user,ipAddress, isPrimary);
	}
	
	public Users getLoggedInUser(Users user) throws Exception{
		if(user.getUsersId() == null){
			Users guest = new Users();
			user.setDisplayName("Guest");
			Map<Integer, String> role = new HashMap<>();
			
			role.put(0,"Guest");
			
			return guest;
		}
		
		user.setUnreadPmCount(pmService.getUnreadPmCount(user));
		
		return user;
	}
	
	public Users getDisplayName(Integer usersId){
		Users user = new Users();
		user.setUsersId(usersId);
		user.setDisplayName(usersDataProvider.getDisplayName(usersId));
		return user;
	}
	
	public List<MemberListingView> getMemberListingView(Users user, Integer pageNumber, Integer range) throws Exception{
		//todo: add permission check
		List<MemberListingView> result = usersDataProvider.getMemberListing(pageNumber - 1, range);
		
		return result;
	}
	
	public void setUserOnline(Users user) throws Exception{
		user.setActiveConnections(user.getActiveConnections() + 1);
		user.setLastLogin(ZfgcTimeUtils.getToday());
		usersDataProvider.setUserOnline(user);
	}
	
	public void setUserOffline(Users user) throws Exception{
		user.setActiveConnections(user.getActiveConnections() - 1);
		
		if(user.getActiveConnections() < 0){
			user.setActiveConnections(0);
		}
		user.setLastLogin(ZfgcTimeUtils.getToday());
		usersDataProvider.setUserOffline(user);
	}

	public Users getNewUserTemplate() {
		Users user = new Users();
		
		user.setActiveFlag(false);
		user.setUserContactInfo(new UserContactInfo());
		user.getUserContactInfo().setEmail(new EmailAddress());
		user.setUserSecurityInfo(new UserSecurityInfo());
		user.setPersonalInfo(new PersonalInfo());
		
		return user;
	}
	
	private void generateUniqueActivationCode(Users user) {
		user.setEmailActivationCode(ZfgcSecurityUtils.generateCryptoString(32));
	}
	
	public void activateUserAccount(String activationCode) throws Exception{
		usersDataProvider.activateUser(activationCode);
	}
	
	public void activateUserAccount(Integer usersId, Users zfgcUser) throws Exception{
		//todo check the user role
		usersDataProvider.activateUser(usersId);
	}
	
	@PostConstruct
	public void resetAllActiveConnections() throws Exception {
		LOGGER.info("Resetting all active connection counts to 0...");
		usersDataProvider.resetActiveConnectionCounts();
		LOGGER.info("Finished resetting all active connection counts to 0.");
		
	}
}
