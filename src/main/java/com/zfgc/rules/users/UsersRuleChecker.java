package com.zfgc.rules.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.Users;
import com.zfgc.rules.AbstractRulesChecker;
import com.zfgc.rules.Rule;
import com.zfgc.services.authentication.AuthenticationService;
import com.zfgc.services.users.UsersService;

@Component
public class UsersRuleChecker extends AbstractRulesChecker<Users>{

	@Autowired
	AuthenticationService authenticationService;
	
	@Autowired
	UsersService usersService;
	
	@Override
	public void rulesCheck(Users model) throws Exception {
		try {
			if(authenticationService.doesEmailExist(model.getEmailAddress())){
				Rule emailDuplicate = new Rule();
				emailDuplicate.setRuleName("EMAIL_DUPLICATE");
				emailDuplicate.setErrorMessage("Email Address already exists");
				model.getErrors().getRuleErrors().add(emailDuplicate);
			}
			
			if(usersService.doesDisplayNameExist(model.getDisplayName())){
				Rule displayNameDuplicate = new Rule();
				displayNameDuplicate.setRuleName("DISPLAY_NAME_DUPLICATE");
				displayNameDuplicate.setErrorMessage("That display name is already taken");
				model.getErrors().getRuleErrors().add(displayNameDuplicate);
			}
			
			if(usersService.doesLoginNameExist(model.getLoginName())){
				Rule loginNameDuplicate = new Rule();
				loginNameDuplicate.setRuleName("LOGIN_NAME_DUPLICATE");
				loginNameDuplicate.setErrorMessage("That login name is already taken");
				model.getErrors().getRuleErrors().add(loginNameDuplicate);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	

}
