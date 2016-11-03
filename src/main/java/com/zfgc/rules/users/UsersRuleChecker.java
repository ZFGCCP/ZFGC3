package com.zfgc.rules.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.Users;
import com.zfgc.rules.AbstractRulesChecker;
import com.zfgc.rules.Rule;
import com.zfgc.services.authentication.AuthenticationService;

@Component
public class UsersRuleChecker extends AbstractRulesChecker<Users>{

	@Autowired
	AuthenticationService authenticationService;
	
	@Override
	public void rulesCheck(Users model) throws Exception {
		try {
			if(authenticationService.doesEmailExist(model.getEmailAddress())){
				Rule emailDuplicate = new Rule();
				emailDuplicate.setRuleName("EMAIL_DUPLICATE");
				emailDuplicate.setErrorMessage("Email Address already exists");
				model.getErrors().getRuleErrors().add(emailDuplicate);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	

}
