package com.zfgc.services.users;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zfgc.dataprovider.UsersDataProvider;
import com.zfgc.model.users.AuthToken;
import com.zfgc.model.users.IpAddress;
import com.zfgc.model.users.Users;
import com.zfgc.requiredfields.users.UsersRequiredFieldsChecker;
import com.zfgc.rules.users.UsersRuleChecker;
import com.zfgc.services.AbstractService;
import com.zfgc.services.authentication.AuthenticationService;
import com.zfgc.services.ip.IpAddressService;
import com.zfgc.util.time.ZfgcTimeUtils;
import com.zfgc.validation.uservalidation.UserValidator;

@Service
public class UsersService extends AbstractService {
	@Autowired 
	AuthenticationService authenticationService;
	
	@Autowired
	UsersDataProvider usersDataProvider;
	
	@Autowired
	IpAddressService ipAddressService;
	
	@Autowired 
	UsersRequiredFieldsChecker requiredFieldsChecker;
	
	@Autowired
	UserValidator validator;
	
	@Autowired
	UsersRuleChecker ruleChecker;
	
	public Users createNewUser(Users user, HttpServletRequest requestHeader){
		
		try {
			requiredFieldsChecker.requiredFieldsCheck(user);
			validator.validator(user);
			ruleChecker.rulesCheck(user);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
		if(!user.getErrors().hasErrors()){
			user.getUserHashInfo().setPassSalt(authenticationService.generateSalt());
			user.getUserHashInfo().setPassword(authenticationService.createPasswordHash(user.getPassword(), user.getUserHashInfo().getPassSalt()));
			
			user.setDateRegistered(ZfgcTimeUtils.getToday());
			user.setIsActiveFlag(false);
			
			user.setPrimaryIpAddress(ipAddressService.createIpAddress(requestHeader.getRemoteAddr()));
			
			try {
				setUserIsSpammer(user);
				user = usersDataProvider.createUser(user);
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
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
		user.getEmailAddress().setIsSpammerFlag(authenticationService.checkEmailIsSpammer(user.getEmailAddress()));
	}
	
	public Users authenticateUser(Users user, String sourceIp) throws Exception{
		if(isAccountLocked(user)){
			loggingService.logAction(7, "Login failed for user " + user.getLoginName() + ". Account is locked.", null, sourceIp);
			user.getErrors().getGeneralErrors().add("You have exceeded the allowed number of login attempts.  Please try again later.");
		}
		else if (doesLoginNameExist(user.getLoginName()) && authenticationService.checkUserPassword(user)){
			Users authenticatedUser = usersDataProvider.getUserByLoginName(user.getLoginName());
			loggingService.logAction(7, "Login success for user " + user.getLoginName(), authenticatedUser.getUsersId(), sourceIp);
			setPrimaryIp(user,sourceIp);
			String token = authenticationService.generateAuthenticationToken(user, user.getTtlLogin());
			authenticatedUser.setAuthToken(token);
			return authenticatedUser;
		}
		else{
			Integer attempts = usersDataProvider.incrementLoginFailCount(user.getLoginName());
			user.getErrors().getGeneralErrors().add("Login failed for user " + user.getLoginName() + ". Incorrect username or password.  " + (5 - attempts) + " attempts remaining.");
			loggingService.logAction(3, "Login failed for user " + user.getLoginName() + ". " + (5 - attempts) + " attempts remaining.", null, sourceIp);
			if(attempts >= 5){
				lockAccount(user.getLoginName(), sourceIp);
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
}
