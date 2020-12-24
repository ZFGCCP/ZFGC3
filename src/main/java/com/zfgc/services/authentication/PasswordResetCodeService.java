package com.zfgc.services.authentication;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

import javax.mail.internet.InternetAddress;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.config.ZfgcGeneralConfig;
import com.zfgc.controller.LegacyController;
import com.zfgc.dataprovider.EmailAddressDataProvider;
import com.zfgc.dataprovider.PasswordResetCodeDataProvider;
import com.zfgc.dataprovider.UserEmailViewDataProvider;
import com.zfgc.dataprovider.UserPasswordResetViewDataProvider;
import com.zfgc.dataprovider.UserSecuritySettingsDataProvider;
import com.zfgc.dataprovider.UsersDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.exception.security.ZfgcUnauthorizedException;
import com.zfgc.model.users.NewPassword;
import com.zfgc.model.users.PasswordResetCode;
import com.zfgc.model.users.UserEmailView;
import com.zfgc.model.users.UserSecurityInfo;
import com.zfgc.model.users.Users;
import com.zfgc.requiredfields.passwordreset.PasswordResetRequiredFields;
import com.zfgc.rules.passwordreset.PasswordResetRules;
import com.zfgc.services.AbstractService;
import com.zfgc.services.RuleRunService;
import com.zfgc.util.ZfgcEmailUtils;
import com.zfgc.util.security.ZfgcSecurityUtils;

@Component
public class PasswordResetCodeService extends AbstractService {
	
	private Logger LOGGER = LogManager.getLogger(PasswordResetCodeService.class);	
	
	@Autowired
	private PasswordResetCodeDataProvider passwordResetCodeDataProvider;
	
	@Autowired
	private UserEmailViewDataProvider userEmailViewDataProvider;
	
	@Autowired
	private ZfgcEmailUtils zfgcEmailUtils;
	
	@Autowired
	private ZfgcGeneralConfig zfgcGeneralConfig;
	
	@Autowired
	private UserSecuritySettingsDataProvider userSecuritySettingsDataProvider;
	
	@Autowired
	private UsersDataProvider usersDataProvider;
	
	@Autowired
	private UserPasswordResetViewDataProvider userPasswordResetViewDataProvider;
	
	@Autowired
	private RuleRunService<NewPassword> ruleRunner;
	
	@Autowired
	private PasswordResetRequiredFields requiredFields;
	
	@Autowired
	private PasswordResetRules rules;
	
	@Transactional
	public void createNewResetCode(String username, Users zfgcUser) {
		//a user should not be logged in when doing this
		if(zfgcUser.getUsersId() != null) {
			throw new ZfgcUnauthorizedException();
		}
			
		UserEmailView user = userEmailViewDataProvider.getActiveUserEmail(username);
		
		PasswordResetCode check = checkResetCode(user.getUsersId(), zfgcUser);
		
		PasswordResetCode resetCode = null;
		if(check != null) {
			resetCode = check;
		}
		else {
			resetCode = new PasswordResetCode(); 
			resetCode.setCode(ZfgcSecurityUtils.generateCryptoString(32));
			resetCode.setUsersId(user.getUsersId());
			resetCode.setExpirationTs(DateUtils.addHours(new Date(), 1));
			
			passwordResetCodeDataProvider.createResetCode(resetCode);
		}

		InternetAddress to = new InternetAddress();
		to.setAddress(user.getEmailAddress());
		zfgcEmailUtils.sendEmail("Password reset link for ZFGC", 
								 user.getDisplayName() + ",<br><br>" +
		                         "To reset your password, please click the following link:<br><br>" +
								 zfgcGeneralConfig.getUiUrl() + "/password-reset/reset?resetCode=" + resetCode.getCode() +
								 "<br><br>If you did not request this email, please contact us immediately.", to);


	}
	
	@Transactional
	public PasswordResetCode checkResetCode(String resetCode, Users zfgcUser) {
		//a user should not be logged in when doing this
		if(zfgcUser.getUsersId() != null) {
			throw new ZfgcUnauthorizedException();
		}
		
		PasswordResetCode check = passwordResetCodeDataProvider.getPasswordResetCodeByCode(resetCode);
		
		return checkResetCode(check);
		
	}
	
	@Transactional
	public NewPassword getNewPasswordModel(String resetCode, Users zfgcUser) {
		if(zfgcUser.getUsersId() != null) {
			throw new ZfgcUnauthorizedException();
		}
		
		NewPassword model = userPasswordResetViewDataProvider.getPasswordResetByCode(resetCode);
		
		return model;
	}
	
	@Transactional
	public PasswordResetCode checkResetCode(Integer usersId, Users zfgcUser) {
		//a user should not be logged in when doing this
		if(zfgcUser.getUsersId() != null) {
			throw new ZfgcUnauthorizedException();
		}
		
		PasswordResetCode check = passwordResetCodeDataProvider.getPasswordResetCode(usersId);
		
		return checkResetCode(check);
		
	}
	
	private PasswordResetCode checkResetCode(PasswordResetCode check) {
		//check if the code is expired
		Date today = new Date();
		if(check.getExpirationTs().compareTo(today) <= 0) {
			passwordResetCodeDataProvider.deleteResetCode(check);
			return null;
		}
		
		return check;
	}
	
	public NewPassword createPasswordResetModel(String resetCode, Users zfgcUser){
		PasswordResetCode code = checkResetCode(resetCode, zfgcUser);
		if(code != null){
			NewPassword newPassword = new NewPassword();
			Users user = usersDataProvider.getUser(code.getUsersId());
			
			newPassword.setUsersId(user.getUsersId());
			newPassword.setDisplayName(user.getDisplayName());
			newPassword.setCode(code.getCode());
			
			return newPassword;
		}
		
		return null;
	}
	
	
	
	@Transactional
	public void resetUserPassword(NewPassword newPassword, Users zfgcUser) {
		ruleRunner.runRules(null, requiredFields, rules, newPassword, zfgcUser);
		
		PasswordResetCode code = checkResetCode(newPassword.getCode(), zfgcUser);
		if(code != null) {
			userSecuritySettingsDataProvider.updatePassword(newPassword);
			passwordResetCodeDataProvider.deleteResetCode(code);
		}
	}
	
}