package com.zfgc.services.authentication;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Service;

import com.zfgc.dao.UsersDao;
import com.zfgc.dataprovider.AuthenticationDataProvider;
import com.zfgc.dataprovider.UsersDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.users.AuthToken;
import com.zfgc.model.users.EmailAddress;
import com.zfgc.model.users.IpAddress;
import com.zfgc.model.users.UserHashInfo;
import com.zfgc.model.users.Users;
import com.zfgc.services.AbstractService;
import com.zfgc.services.lookups.LookupService;
import com.zfgc.util.time.ZfgcTimeUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class AuthenticationService  extends AbstractService {
	
	private final String HASH_ALGORITHM = "SHA-256";
	private final int SALT_LENGTH = 128;
	private Logger LOGGER = Logger.getLogger(AuthenticationService.class);
	
	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private AuthenticationDataProvider authenticationDataProvider;
	
	@Autowired
	private UsersDataProvider usersDataProvider;
	
	//returns null if the hash fails
	public String createPasswordHash(String password, String salt) throws Exception{
		String hashThis = password + salt;
		
		try{
			MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
			digest.update(hashThis.getBytes());
			byte[] hash = digest.digest();
			
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
			    if ((0xff & hash[i]) < 0x10) {
			        hexString.append("0"
			                + Integer.toHexString((0xFF & hash[i])));
			    } else {
			        hexString.append(Integer.toHexString(0xFF & hash[i]));
			    }
			}
			
			return hexString.toString();
		}
		catch(NoSuchAlgorithmException ex){
			LOGGER.error(ex.getMessage());
			throw new Exception(ex.getMessage());
		}
	}
	
	//generates a cryptographically secure salt for passwords
	public String generateSalt(){
		return generateCryptoString(SALT_LENGTH);
	}
	
	private String generateCryptoString(int unencodedLength){
		Random cryptoRand = new SecureRandom();
		byte[] salt = new byte[unencodedLength];
		cryptoRand.nextBytes(salt);
		return Base64.encodeBase64URLSafeString(salt);
	}
	
	public String generateAuthenticationToken(Users user, Integer ttl) throws Exception{
		Random cryptoRand = new SecureRandom();
		byte[] token = new byte[16];
		cryptoRand.nextBytes(token);
		
		AuthToken authToken = new AuthToken();
		authToken.setCreateTimestamp(ZfgcTimeUtils.getToday());
		
		if(ttl != null){
			authToken.setTtl(DateUtils.addSeconds(authToken.getCreateTimestamp(), ttl));
		}
		else{
			authToken.setTtl(DateUtils.addSeconds(authToken.getCreateTimestamp(), Integer.MAX_VALUE));
		}
		authToken.setUsersId(user.getUsersId());
		authToken.setToken(generateCryptoString(32));
		
		try{
			authenticationDataProvider.createAuthToken(authToken);
		}
		catch(Exception ex){
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
		
		return authToken.getToken();
	}
	
	public Boolean isTokenValid(Users user, String token) throws Exception{
		List<AuthToken> tokens = null;
		try{
			tokens = authenticationDataProvider.getAuthTokensForUser(user);
		}
		catch(Exception ex){
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
		
		Date now = ZfgcTimeUtils.getToday();
		
		for(AuthToken authToken : tokens){
			if(now.before(authToken.getTtl()) && authToken.getToken().equals(token)){
				return true;
			}
		}
		
		return false;
	}
	
	public Boolean checkUserPassword(Users user) throws Exception{
		try {
			UserHashInfo hashInfo = usersDao.getUserPasswordAndSaltByName(user.getLoginName());
			
			return checkPassword(user.getPassword(),hashInfo);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public Users authenticateWithToken(String authToken) throws Exception{
		try{
			Boolean isTokenValid = checkToken(authToken);

			if(isTokenValid){
				Users user = usersDataProvider.getUserByToken(authToken);
				user.setTimeOffsetLkup(lookupService.getLkupValue(LookupService.TIMEZONE, user.getTimeOffset()));
				return user;
			}
			else{
				return null;
			}
		}
		catch(ZfgcNotFoundException e){
			throw new ZfgcNotFoundException(e.getResourceName());
		}
		catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
	
	public Boolean checkToken(String authToken) throws Exception{
		try{
			AuthToken token = authenticationDataProvider.getAuthToken(authToken);
			
			Date now = ZfgcTimeUtils.getToday();
			if(now.before(token.getTtl())){
				return true;
			}
			
			return false;
		}
		catch(ZfgcNotFoundException e){
			throw new ZfgcNotFoundException(e.getResourceName());
		}
		catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
	
	private Boolean checkPassword(String password, UserHashInfo userHashInfo) throws Exception{
		try{
			String hashCompare = createPasswordHash(password, userHashInfo.getPassSalt());
			Boolean result =  hashCompare != null && hashCompare.equals(userHashInfo.getPassword());
			
			return result;
		}
		catch(Exception ex){
			LOGGER.error("Error checking password");
			throw new Exception(ex.getMessage());
		}
	}
	
	public Boolean checkIpIsSpammer(IpAddress ipAddress) throws Exception{
		return authenticationDataProvider.getIpSpamInfo(ipAddress).getIsSpammerFlag();
	}
	
	public Boolean checkEmailIsSpammer(EmailAddress emailAddress) throws Exception{
		return authenticationDataProvider.getEmailSpamInfo(emailAddress).getIsSpammerFlag();
	}
	
	public Boolean doesEmailExist(EmailAddress emailAddress) throws Exception{
		return authenticationDataProvider.doesEmailExist(emailAddress);
	}
}
