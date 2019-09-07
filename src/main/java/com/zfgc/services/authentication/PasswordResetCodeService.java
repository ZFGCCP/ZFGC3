package com.zfgc.services.authentication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.controller.LegacyController;
import com.zfgc.dataprovider.EmailAddressDataProvider;
import com.zfgc.dataprovider.PasswordResetCodeDataProvider;
import com.zfgc.dataprovider.UsersDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.users.PasswordResetCode;
import com.zfgc.model.users.Users;
import com.zfgc.services.AbstractService;

@Component
public class PasswordResetCodeService extends AbstractService {
	
	private Logger LOGGER = LogManager.getLogger(PasswordResetCodeService.class);	
	
	@Autowired
	private PasswordResetCodeDataProvider passwordResetCodeDataProvider;
	
	@Autowired
	private UsersDataProvider usersDataProvider;
	
	
	
	public void createNewResetCode(String username) {
		
		try {
			Users user = usersDataProvider.getUser(username);
			
			PasswordResetCode resetCode = new PasswordResetCode();
		}
		catch(ZfgcNotFoundException ex) {
			LOGGER.error(ex.getMessage());
		}
	}
	
}