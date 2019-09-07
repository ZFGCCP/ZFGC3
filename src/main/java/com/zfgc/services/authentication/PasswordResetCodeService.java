package com.zfgc.services.authentication;

import java.io.UnsupportedEncodingException;
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
import com.zfgc.dataprovider.UsersDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.users.PasswordResetCode;
import com.zfgc.model.users.UserEmailView;
import com.zfgc.model.users.Users;
import com.zfgc.services.AbstractService;
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
	
	@Transactional
	public void createNewResetCode(String username) {
		try {
			UserEmailView user = userEmailViewDataProvider.getActiveUserEmail(username);
			
			PasswordResetCode resetCode = new PasswordResetCode();
			resetCode.setCode(ZfgcSecurityUtils.generateCryptoString(32));
			resetCode.setUsersId(user.getUsersId());
			resetCode.setExpirationTs(DateUtils.addHours(new Date(), 1));
			
			passwordResetCodeDataProvider.createResetCode(resetCode);
			
			InternetAddress to = new InternetAddress();
			to.setAddress(user.getEmailAddress());
			zfgcEmailUtils.sendEmail("Password reset link for ZFGC", 
									 user.getDisplayName() + ",<br><br>" +
			                         "To reset your password, please click the following link:<br><br>" +
									 zfgcGeneralConfig.getUiUrl() + "/passwordReset?resetCode=" + resetCode.getCode() +
									 "<br><br>If you did not request this email, please contact us immediately.", to);
		}
		catch(ZfgcNotFoundException ex) {
			LOGGER.error(ex.getMessage());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	
}