package com.zfgc.rules.passwordreset;

import org.springframework.stereotype.Component;

import com.zfgc.model.users.NewPassword;
import com.zfgc.model.users.Users;
import com.zfgc.rules.AbstractRulesChecker;
import com.zfgc.rules.Rule;

@Component
public class PasswordResetRules extends AbstractRulesChecker<NewPassword>{

	@Override
	public void rulesCheck(NewPassword model, Users user) throws RuntimeException {
		if(!model.getConfirmPassword().equals(model.getNewPassword())) {
			Rule coppaViolation = new Rule();
			coppaViolation.setRuleName("UMATCHED_PASSWORD");
			coppaViolation.setErrorMessage("The password you entered did not match the confirmation.");
			model.getErrors().getRuleErrors().add(coppaViolation);
		}
		
	}

}
