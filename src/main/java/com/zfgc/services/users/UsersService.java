package com.zfgc.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zfgc.dataprovider.UsersDataProvider;
import com.zfgc.model.users.Users;
import com.zfgc.services.authentication.AuthenticationService;

@Service
public class UsersService {
	@Autowired 
	AuthenticationService authenticationService;
	
	@Autowired
	UsersDataProvider usersDataProvider;
	
	public Users createNewUser(Users user){
		user.getUserHashInfo().setPassSalt(authenticationService.generateSalt());
		user.getUserHashInfo().setPassword(authenticationService.createPasswordHash(user.getPassword(), user.getUserHashInfo().getPassSalt()));
		
		try {
			user = usersDataProvider.createUser(user);
			return user;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Boolean checkUserPassword(String password, String userName){
		try{
			return authenticationService.checkUserPassword(userName, password);
		}
		catch(Exception ex){
			return false;
		}
	}
}
