package com.zfgc.services.authentication;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Service;

import com.zfgc.dao.UsersDao;
import com.zfgc.dataprovider.AuthenticationDataProvider;
import com.zfgc.dataprovider.PmKeyDataProvider;
import com.zfgc.dataprovider.UsersDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.exception.security.ZfgcInvalidAesKeyException;
import com.zfgc.model.pm.PmKey;
import com.zfgc.model.pm.TwoFactorKey;
import com.zfgc.model.users.AuthToken;
import com.zfgc.model.users.EmailAddress;
import com.zfgc.model.users.IpAddress;
import com.zfgc.model.users.UserHashInfo;
import com.zfgc.model.users.Users;
import com.zfgc.services.AbstractService;
import com.zfgc.services.lookups.LookupService;
import com.zfgc.util.security.ZfgcSecurityUtils;
import com.zfgc.util.time.ZfgcTimeUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class AuthenticationService  extends AbstractService {
	
	private final static String HASH_ALGORITHM = "SHA-256";
	private final int SALT_LENGTH = 128;
	public final String PM_PARITY_WORD = "ZFGC3";
	private Logger LOGGER = LogManager.getLogger(AuthenticationService.class);

	@Autowired
	private AuthenticationDataProvider authenticationDataProvider;
	
	@Autowired
	private PmKeyDataProvider pmKeyDataProvider;
	
	public String createPasswordHash(String password, String salt) throws RuntimeException{
		String hashThis = password + salt;
		
		try{
			return generateSha256(hashThis);
		}
		catch(NoSuchAlgorithmException ex){
			LOGGER.error(ex.getMessage());
			throw new RuntimeException(ex.getMessage());
		}
	}
	
	//generates a cryptographically secure salt for passwords
	public String generateSalt(){
		return generateCryptoString(SALT_LENGTH);
	}
	
	public static String generateCryptoString(int unencodedLength){
		Random cryptoRand = new SecureRandom();
		byte[] salt = new byte[unencodedLength];
		cryptoRand.nextBytes(salt);
		return Base64.encodeBase64URLSafeString(salt);
	}
	
	public static String generateSha256(String digestStr) throws NoSuchAlgorithmException, RuntimeException{
		try{
			MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
			digest.update(digestStr.getBytes());
			byte[] hash = digest.digest();
			String str = new String(hash);
			return Base64.encodeBase64URLSafeString(hash);
		}
		catch(NoSuchAlgorithmException ex){
			throw ex;
		}
		catch(RuntimeException ex){
			throw ex;
		}
	}
	
	public String generateAuthenticationToken(Users user, Integer ttl) throws RuntimeException{
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
		catch(RuntimeException ex){
			ex.printStackTrace();
			throw ex;
		}
		
		return authToken.getToken();
	}
	
	public Boolean isTokenValid(Users user, String token) throws RuntimeException{
		List<AuthToken> tokens = null;
		try{
			tokens = authenticationDataProvider.getAuthTokensForUser(user);
		}
		catch(RuntimeException ex){
			ex.printStackTrace();
			throw ex;
		}
		
		Date now = ZfgcTimeUtils.getToday();
		
		for(AuthToken authToken : tokens){
			if(now.before(authToken.getTtl()) && authToken.getToken().equals(token)){
				return true;
			}
		}
		
		return false;
	}
	
	public Boolean checkToken(String authToken) throws RuntimeException{
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
		catch(RuntimeException e){
			throw new RuntimeException(e.getMessage());
		}
	}
	
	private Boolean checkPassword(String password, UserHashInfo userHashInfo) throws RuntimeException{
		try{
			String hashCompare = createPasswordHash(password, userHashInfo.getPassSalt());
			Boolean result =  hashCompare != null && hashCompare.equals(userHashInfo.getPassword());
			
			return result;
		}
		catch(Exception ex){
			LOGGER.error("Error checking password");
			throw new RuntimeException(ex.getMessage());
		}
	}
	
	public Boolean checkIpIsSpammer(IpAddress ipAddress) throws RuntimeException{
		return authenticationDataProvider.getIpSpamInfo(ipAddress).getIsSpammerFlag();
	}
	
	public Boolean checkEmailIsSpammer(EmailAddress emailAddress) throws RuntimeException{
		return authenticationDataProvider.getEmailSpamInfo(emailAddress).getIsSpammerFlag();
	}
	
	public Boolean doesEmailExist(EmailAddress emailAddress) throws RuntimeException{
		return authenticationDataProvider.doesEmailExist(emailAddress);
	}
	
	public Boolean isValidAesKey(TwoFactorKey aes) throws ZfgcInvalidAesKeyException{
		/*PmKey pmKey = pmKeyDataProvider.getPmKeyByUsersId(aes.getUsersId());
		
		if(aes.getKey() == null){
			throw new ZfgcInvalidAesKeyException(pmKey.getParityWord());
		}
		
		String decrypted = ZfgcSecurityUtils.decryptAes(pmKey.getParityWord(), aes.getKey());
		
		if(decrypted == null){
			throw new ZfgcInvalidAesKeyException(pmKey.getParityWord());
		}
		
		return decrypted.equals(PM_PARITY_WORD);*/
		//temporarily disable encryption
		return true;
	}
}
