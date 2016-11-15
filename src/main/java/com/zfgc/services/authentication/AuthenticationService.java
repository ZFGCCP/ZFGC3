package com.zfgc.services.authentication;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Service;

import com.zfgc.dao.UsersDao;
import com.zfgc.dataprovider.AuthenticationDataProvider;
import com.zfgc.model.users.AuthToken;
import com.zfgc.model.users.EmailAddress;
import com.zfgc.model.users.IpAddress;
import com.zfgc.model.users.UserHashInfo;
import com.zfgc.model.users.Users;
import com.zfgc.services.AbstractService;
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
	
	//returns null if the hash fails
	public String createPasswordHash(String password, String salt){
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
			return null;
		}
	}
	
	//generates a cryptographically secure salt for passwords
	public String generateSalt(){
		Random cryptoRand = new SecureRandom();
		byte[] salt = new byte[SALT_LENGTH];
		cryptoRand.nextBytes(salt);
		return Base64.encodeBase64String(salt);
	}
	
	public String generateAuthenticationToken(Users user, Integer ttl) throws Exception{
		Random cryptoRand = new SecureRandom();
		byte[] token = new byte[16];
		cryptoRand.nextBytes(token);
		
		AuthToken authToken = new AuthToken();
		authToken.setCreateTimestamp(ZfgcTimeUtils.getToday());
		authToken.setTtl(DateUtils.addSeconds(authToken.getCreateTimestamp(), ttl));
		authToken.setUsersId(user.getUsersId());
		authToken.setToken(new String(Hex.encode(token)));
		
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
	
	private Boolean checkPassword(String password, UserHashInfo userHashInfo){
		String hashCompare = createPasswordHash(password, userHashInfo.getPassSalt());
		Boolean result =  hashCompare != null && hashCompare.equals(userHashInfo.getPassword());
		
		return result;
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
