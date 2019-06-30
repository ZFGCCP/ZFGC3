package com.zfgc.services.users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.CharBuffer;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.config.ZfgcGeneralConfig;
import com.zfgc.dao.LookupDao;
import com.zfgc.dataprovider.EmailAddressDataProvider;
import com.zfgc.dataprovider.IpDataProvider;
import com.zfgc.dataprovider.UserConnectionDataProvider;
import com.zfgc.dataprovider.UsersDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.model.users.AuthToken;
import com.zfgc.model.users.EmailAddress;
import com.zfgc.model.users.IpAddress;
import com.zfgc.model.users.MemberListingView;
import com.zfgc.model.users.MembersView;
import com.zfgc.model.users.UserConnection;
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
import com.zfgc.util.security.RsaKeyPair;
import com.zfgc.util.security.ZfgcSecurityUtils;
import com.zfgc.util.time.ZfgcTimeUtils;
import com.zfgc.validation.uservalidation.UserValidator;
import com.zfgc.model.avatar.Avatar;
import com.zfgc.model.online.OnlineUser;

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
	
	@Autowired
	UserConnectionDataProvider userConnectionDataProvider;
	
	@Autowired
	ZfgcGeneralConfig zfgcGeneralConfig;

	private Logger LOGGER = LogManager.getLogger(UsersService.class);

	public Users getUser(Integer usersId) throws Exception{
		Users user = usersDataProvider.getUser(usersId);
		user.setPrimaryIpAddress(ipAddressService.getIpAddress(user.getPrimaryIp()));
		
		return user;
	}
	
	public List<Users> getUsersByConversation(Integer conversationId) throws RuntimeException{
		List<Users> result = null;
		
		try{
			result = usersDataProvider.getUsersByConversation(conversationId);
		}
		catch(ZfgcNotFoundException ex){
			ex.printStackTrace();
			throw ex;
		}
		catch(RuntimeException ex){
			ex.printStackTrace();
			throw ex;
		}
		
		return result;
	}
	
	@Transactional
	public Users createNewUser(Users user, HttpServletRequest requestHeader) throws RuntimeException{
		
		
		try {
			user.setTimeOffsetLkup(lookupService.getLkupValue(LookupService.TIMEZONE, user.getTimeOffset()));
			ruleRunner.runRules(validator, requiredFieldsChecker, ruleChecker, user, user);
		} 
		catch(ZfgcValidationException ex){
			ex.printStackTrace();
			throw ex;
		}
		catch (RuntimeException ex) {
			ex.printStackTrace();
			throw ex;
		}
		
		if(!user.getErrors().hasErrors()){
			user.getUserHashInfo().setPassSalt(authenticationService.generateSalt());

			user.setDateRegistered(ZfgcTimeUtils.getToday(user.getTimeOffsetLkup()));
			user.setActiveFlag(false);
			user.setPrimaryMemberGroupId(2);
			generateUniqueActivationCode(user);
			
			IpAddress potentialIp = null;
			//does the remote Ip exist?
			try {
				IpAddress ipCheck = ipAddressService.getIpAddress(requestHeader.getRemoteAddr());
				potentialIp = ipCheck;
			}
			catch(ZfgcNotFoundException ex) {
				potentialIp = ipAddressService.createIpAddress(requestHeader.getRemoteAddr());
			}
			catch(RuntimeException ex) {
				ex.printStackTrace();
				throw ex;
			}
			
			user.setPrimaryIpAddress(potentialIp);
			user.setPrimaryIp(potentialIp.getIpAddressId());
			
			try {
				setUserIsSpammer(user);
				
				user.getUserContactInfo().setEmail(emailAddressDataProvider.createNewEmail(user.getUserContactInfo().getEmail()));
				Avatar avatar = new Avatar();
				avatar.setAvatarTypeId(1);
				
				user.getPersonalInfo().setAvatar(avatar);
				
				user = usersDataProvider.createUser(user);
				loggingService.logAction(7, "User account created for " + user.getLoginName(), user.getUsersId(), user.getPrimaryIpAddress().getIpAddress());
				
				if(!user.getUserContactInfo().getEmail().getIsSpammerFlag()) {
					String subject = "New Account Activation For ZFGC";
					String body = "Hello " + user.getDisplayName() + ", below you will find an activation link for your account on ZFGC.<br>" +
								  "If you think you have received this email in error, please ignore it.<br><br>" +
								  zfgcGeneralConfig.getUiUrl() + "/useractivation?activationCode=" + user.getEmailActivationCode();
					
					InternetAddress to = new InternetAddress(user.getUserContactInfo().getEmail().getEmailAddress(), user.getDisplayName());
					zfgcEmailUtils.sendEmail(subject, body, to);
				}
				
				//generate rsa key pair for PM, then AES encrypt the private key - base it off of the password for now
				//todo: when the encryption system for PMs is redone, update this to be a separate field distinct from the password
				pmService.createKeyPairs(user.getUsersId(), user.getUserSecurityInfo().getNewPassword());
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(ex);
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
	
	public IpAddress setPrimaryIp(Users user, String ipAddress) throws RuntimeException{
		IpAddress ip = ipAddressService.createIpAddress(ipAddress);
	    linkUserToIp(user,ip,true);
		return ip;
	}
	
	public void setUserIsSpammer(Users user) throws RuntimeException{
		user.getPrimaryIpAddress().setIsSpammerFlag(authenticationService.checkIpIsSpammer(user.getPrimaryIpAddress()));
		user.getUserContactInfo().getEmail().setIsSpammerFlag(authenticationService.checkEmailIsSpammer(user.getUserContactInfo().getEmail()));
	}
	
	public Users authenticateUserByToken(String token) throws RuntimeException{
		try{
			return authenticationService.authenticateWithToken(token);
		}
		catch(ZfgcNotFoundException ex){
			throw new ZfgcNotFoundException(ex.getResourceName());
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
	
	@Transactional
	public Users authenticateUser(Users user, String sourceIp) throws RuntimeException{
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
	
	public Boolean doesLoginNameExist(String loginName) throws RuntimeException {
		return usersDataProvider.doesLoginNameExist(loginName);
	}
	
	public Boolean doesDisplayNameExist(String loginName) throws RuntimeException {
		return usersDataProvider.doesDisplayNameExist(loginName);
	}

	private void linkUserToIp(Users user, IpAddress ipAddress, Boolean isPrimary) throws RuntimeException{
		usersDataProvider.linkUserToIp(user,ipAddress, isPrimary);
	}
	
	public Users getLoggedInUser(Users user) throws RuntimeException{
		if(user.getUsersId() == null || user.getUsersId() == -1){
			Users guest = new Users();
			guest.setDisplayName("Guest");
			guest.setPrimaryMemberGroupId(0);
			
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
	
	public MembersView getMemberListingView(Users user, Integer pageNumber, Integer range) throws RuntimeException{
		//todo: add permission check
		List<MemberListingView> result = usersDataProvider.getMemberListing(pageNumber - 1, range);
		Long totalUsers = usersDataProvider.getActiveUsersCount();
		MembersView members = new MembersView();
		
		members.setTotalCount(totalUsers);
		members.setMembers(result);
		
		
		return members;
	}
	
	public void setUserOnline(Users user, String sessionId) throws RuntimeException{
		user.setActiveConnections(user.getActiveConnections() + 1);
		user.setLastLogin(ZfgcTimeUtils.getToday());
		usersDataProvider.setUserOnline(user);
		String result = null;
		//create a connection entry for the user
		try {
			URL url = new URL("http://www.useragentstring.com?uas=" + user.getUserAgent().replace(" ", "%20") + "&getText=all");
			//URL url = new URL("http://api.userstack.com/detect?access_key=" + "198990e1212995a6e75023a0d5c0872f" + "&ua=" + user.getUserAgent().replace(" ", "%20"));
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setConnectTimeout(3000);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("User-Agent", "");

		    InputStream stream = conn.getInputStream();

			BufferedReader br = new BufferedReader(new InputStreamReader(stream));
			result = br.readLine();
			br.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		catch (RuntimeException ex){
			throw ex;
		}
		UserConnection onlineUser = userConnectionDataProvider.getUserConnectionTemplate(user);
		onlineUser.setSessionId(sessionId);
		if(result != null) {
			String[] params = result.split(";");
			Map<String, String> mappedParams = new HashMap<>();
			
			for(String param : params) {
				String[] split = param.split("=");
				
				mappedParams.put(split[0], split.length > 1 ? split[1] : null);
			}
			
			onlineUser.setAgentName(mappedParams.get("agent_name"));
			onlineUser.setAgentType(mappedParams.get("agent_type"));
			onlineUser.setAgentVersion(mappedParams.get("agent_version"));
			
			onlineUser.setOsName(mappedParams.get("os_name"));
			onlineUser.setOsType(mappedParams.get("os_type"));
			onlineUser.setOsVersionName(mappedParams.get("os_versionName"));
			onlineUser.setOsVersionNumber(mappedParams.get("os_versionNumber"));
		}
		
  		userConnectionDataProvider.insertNewConnection(onlineUser);
  		user.setUserConnectionId(onlineUser.getUserConnectionId());
	}
	
	public void setUserOffline(Users user, String sessionId) throws Exception{
		user.setActiveConnections(user.getActiveConnections() - 1);
		
		if(user.getActiveConnections() < 0){
			user.setActiveConnections(0);
		}
		user.setLastLogin(ZfgcTimeUtils.getToday());
		usersDataProvider.setUserOffline(user);
		
		userConnectionDataProvider.deleteUserConnection(sessionId);
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
	
	public void activateUserAccount(String activationCode) throws RuntimeException{
		usersDataProvider.activateUser(activationCode);
	}
	
	public void activateUserAccount(Integer usersId, Users zfgcUser) throws RuntimeException{
		//todo check the user role
		usersDataProvider.activateUser(usersId);
	}
	
	@PostConstruct
	public void resetAllActiveConnections() throws Exception {
		LOGGER.info("Resetting all active connection counts to 0...");
		usersDataProvider.resetActiveConnectionCounts();
		LOGGER.info("Finished resetting all active connection counts to 0.");
		
		LOGGER.info("Clearing out user connections...");
		userConnectionDataProvider.deleteAllUserConnections();
		LOGGER.info("Finished clearing out user connections.");
		
	}
}
