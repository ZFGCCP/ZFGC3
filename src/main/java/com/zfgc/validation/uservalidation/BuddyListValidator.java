package com.zfgc.validation.uservalidation;

import org.springframework.stereotype.Component;

import com.zfgc.model.users.profile.Buddy;
import com.zfgc.rules.Rule;
import com.zfgc.validation.AbstractValidator;

@Component
public class BuddyListValidator extends AbstractValidator<Buddy>{

	@Override
	public void validator(Buddy model) throws Exception {
		checkUsersAreNotEqual(model);
	}
	
	private void checkUsersAreNotEqual(Buddy model){
		if(model.getUserAId().equals(model.getUserBId())){
			Rule usersAreEqual = new Rule();
			usersAreEqual.setRuleName("CANNOT_BE_OWN_BUDDY");
			usersAreEqual.setErrorMessage("You cannot be your own buddy :( ");
			model.getErrors().getValidationErrors().add(usersAreEqual);
		}
	}
}