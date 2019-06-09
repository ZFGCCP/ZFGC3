package com.zfgc.rules.pm;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.pm.PersonalMessage;
import com.zfgc.model.users.Users;
import com.zfgc.rules.AbstractRulesChecker;
import com.zfgc.rules.Rule;

@Component
public class PmConversationRules extends AbstractRulesChecker<PersonalMessage> {

	@Override
	public void rulesCheck(PersonalMessage model, Users user) throws RuntimeException {
		if(model.getReceivers().size() < 2) {
			Rule participants = new Rule();
			participants.setRuleName("NOT_ENOUGH_RECEIVERS");
			participants.setErrorMessage("There must be at least 2 participants in a conversation.");
			model.getErrors().getRuleErrors().add(participants);
		}
		
		Boolean foundCurrentUser = false;
		Boolean foundDuplicateUser = false;
		Map<Integer, Integer> receiverCounts = new HashMap<>();
		for(Users receiver : model.getReceivers()) {
			if(!receiverCounts.containsKey(receiver.getUsersId())) {
				receiverCounts.put(receiver.getUsersId(), 0);
			}
			else {
				foundDuplicateUser = true;
			}
			
			Integer count = receiverCounts.get(receiver.getUsersId());
			count += 1;
			
			if(receiver.getUsersId().equals(user.getUsersId())) {
				foundCurrentUser = true;
			}
		}
		
		if(!foundCurrentUser) {
			Rule participants = new Rule();
			participants.setRuleName("NO_CURRENT_USER");
			participants.setErrorMessage("You must be included as a conversation member.");
			model.getErrors().getRuleErrors().add(participants);
		}
		
		if(foundDuplicateUser) {
			Rule participants = new Rule();
			participants.setRuleName("DUPLICATE_USER");
			participants.setErrorMessage("Each user can only be added once to a conversation.");
			model.getErrors().getRuleErrors().add(participants);
		}
	}

}
