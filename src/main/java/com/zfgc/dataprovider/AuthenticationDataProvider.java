package com.zfgc.dataprovider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.AuthenticationDao;
import com.zfgc.dbobj.AuthTokenDbObj;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.users.AuthToken;
import com.zfgc.model.users.EmailAddress;
import com.zfgc.model.users.IpAddress;
import com.zfgc.model.users.Users;

@Component
public class AuthenticationDataProvider extends AbstractDataProvider{
	
	@Autowired
	private AuthenticationDao authenticationDao;
	
	public void logIpAddress(IpAddress ipAddress) throws Exception{
		try{
			authenticationDao.logIpAddress(ipAddress);
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	public void logEmailAddress(EmailAddress emailAddress) throws Exception{
		try{
			authenticationDao.logEmailAddress(emailAddress);
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	public IpAddress getIpSpamInfo(IpAddress ipAddress) throws Exception{
		IpAddress ipSpamInfo = new IpAddress();
		ipSpamInfo.setIpAddress(ipAddress.getIpAddress());

		//stopforumspam currently does not support ipv6! if we get a v6 address, just pass it as false for now.
		
		if(ipAddress.getVersion() == 6){
			ipSpamInfo.setIsSpammerFlag(false);
		}
		else{
			try {
				ipSpamInfo.setIsSpammerFlag(getSpamInfoFromUrl("http://api.stopforumspam.org/api?ip=" + ipAddress.getIpAddress()));

			} catch (Exception ex) {
				throw new Exception(ex.getMessage());
			}
		}
		
		return ipSpamInfo;
	}
	
	public EmailAddress getEmailSpamInfo(EmailAddress emailAddress) throws Exception{
		EmailAddress emailSpamInfo = new EmailAddress();
		emailSpamInfo.setEmailAddress(emailAddress.getEmailAddress());
		
		try{
			emailSpamInfo.setIsSpammerFlag(getSpamInfoFromUrl("http://api.stopforumspam.org/api?email=" + emailAddress.getEmailAddress()));
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
		
		return emailSpamInfo;
	}
	
	private Boolean getSpamInfoFromUrl(String apiCall) throws Exception{
		try {
			URL url = new URL(apiCall);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			br.readLine();
			br.readLine();
			String output = br.readLine();

			return !output.contains("no");

		} catch (IOException ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
	}
	
	public Boolean doesEmailExist(EmailAddress emailAddress) throws Exception{
		return authenticationDao.getEmailAddress(emailAddress.getEmailAddress()) != null;
	}
	
	public void createAuthToken(AuthToken authToken) throws Exception{
		authenticationDao.saveAuthToken(authToken);
	}
	
	public List<AuthToken> getAuthTokensForUser(Users user) throws Exception{
		List<AuthTokenDbObj> result = authenticationDao.getAuthTokenByUser(user);
		
		List<AuthToken> output = new ArrayList<>();
		
		for(AuthTokenDbObj authToken : result){
			output.add(mapper.map(authToken, AuthToken.class));
		}
		
		return output;
	}
	
	public AuthToken getAuthToken(String authToken) throws Exception{
		try{
			AuthToken auth = mapper.map(authenticationDao.getAuthToken(authToken), AuthToken.class);
			
			return auth;
		}
		catch(ZfgcNotFoundException ex){
			throw new ZfgcNotFoundException(ex.getResourceName());
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
}