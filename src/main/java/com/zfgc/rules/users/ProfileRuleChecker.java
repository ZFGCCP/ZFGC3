package com.zfgc.rules.users;

import org.springframework.stereotype.Component;

import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.UserProfileView;
import com.zfgc.rules.AbstractRulesChecker;
import com.zfgc.rules.Rule;

@Component
public class ProfileRuleChecker extends AbstractRulesChecker<UserProfileView>{

	@Override
	public void rulesCheck(UserProfileView model, Users user) throws RuntimeException {
		/*if(model.getAge() < 13){
			Rule coppaViolation = new Rule();
			coppaViolation.setRuleName("COPPA_VIOLATION_AGE");
			coppaViolation.setErrorMessage("You must be 13 years of age or older to use this forum.");
			model.getErrors().getRuleErrors().add(coppaViolation);
		}*/
		
	}
	
}