package com.zfgc.rules.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.UsersDataProvider;
import com.zfgc.exception.ZfgcValidationException;
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
	UsersDataProvider usersDataProvider;
	
	@Override
	public void rulesCheck(Users model, Users user) throws ZfgcValidationException, RuntimeException {
		if(authenticationService.doesEmailExist(model.getUserContactInfo().getEmail())){
			Rule emailDuplicate = new Rule();
			emailDuplicate.setRuleName("EMAIL_DUPLICATE");
			emailDuplicate.setErrorMessage("Email Address already exists");
			model.getErrors().getRuleErrors().add(emailDuplicate);
		}
		
		if(doesDisplayNameExist(model.getDisplayName())){
			Rule displayNameDuplicate = new Rule();
			displayNameDuplicate.setRuleName("DISPLAY_NAME_DUPLICATE");
			displayNameDuplicate.setErrorMessage("That display name is already taken");
			model.getErrors().getRuleErrors().add(displayNameDuplicate);
		}
		
		if(doesLoginNameExist(model.getLoginName())){
			Rule loginNameDuplicate = new Rule();
			loginNameDuplicate.setRuleName("LOGIN_NAME_DUPLICATE");
			loginNameDuplicate.setErrorMessage("That login name is already taken");
			model.getErrors().getRuleErrors().add(loginNameDuplicate);
		}
		
		if(model.getAge() < 13){
			Rule coppaViolation = new Rule();
			coppaViolation.setRuleName("COPPA_VIOLATION_AGE");
			coppaViolation.setErrorMessage("You must be 13 years of age or older to use this forum.");
			model.getErrors().getRuleErrors().add(coppaViolation);
		}
		
		if(!model.getUserSecurityInfo().getNewPassword().equals(model.getUserSecurityInfo().getConfirmNewPassword())) {
			Rule coppaViolation = new Rule();
			coppaViolation.setRuleName("UMATCHED_PASSWORD");
			coppaViolation.setErrorMessage("The password you entered did not match the confirmation.");
			model.getErrors().getRuleErrors().add(coppaViolation);
		}
		
		checkAgreeToTerms(model);
	}
	
	protected void checkAgreeToTerms(Users model){
		if(!model.getAgreeToTermsFlag()){
			Rule tosUnchecked = new Rule();
			tosUnchecked.setRuleName("TOS_UNCHECKED");
			tosUnchecked.setErrorMessage("You must acknowledge that you have read and agree to the terms of service and are 13 years of age or older.");
			model.getErrors().getRuleErrors().add(tosUnchecked);
		}
	}
	
	protected Boolean doesLoginNameExist(String loginName) throws RuntimeException {
		return usersDataProvider.doesLoginNameExist(loginName);
	}
	
	protected Boolean doesDisplayNameExist(String loginName) throws RuntimeException {
		return usersDataProvider.doesDisplayNameExist(loginName);
	}
}
