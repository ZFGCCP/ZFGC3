package com.zfgc.rules.pm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.constants.pm.PmConstants;
import com.zfgc.constants.user.UserConstants;
import com.zfgc.dao.PersonalMessagingSettingsDao;
import com.zfgc.dataprovider.BuddyDataProvider;
import com.zfgc.dataprovider.PersonalMessagingSettingsDataProvider;
import com.zfgc.dataprovider.UserPermissionViewDataProvider;
import com.zfgc.model.pm.PersonalMessage;
import com.zfgc.model.users.Permissions;
import com.zfgc.model.users.UserPermissionView;
import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.Buddy;
import com.zfgc.model.users.profile.PersonalMessagingSettings;
import com.zfgc.rules.AbstractRulesChecker;
import com.zfgc.rules.Rule;

@Component
public class PmConversationRules extends AbstractRulesChecker<PersonalMessage> {

	@Autowired
	BuddyDataProvider buddyDataProvider;
	
	@Autowired
	PersonalMessagingSettingsDataProvider pmSettingsDataProvider;
	
	@Autowired
	UserPermissionViewDataProvider userPermissionViewDataProvider;
	
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
		for(Integer receiver : model.getReceivers()) {
			
			PersonalMessagingSettings pmSettings = null;
			
			if(!receiverCounts.containsKey(receiver)) {
				pmSettings = pmSettingsDataProvider.getPmSettings(receiver);
				receiverCounts.put(receiver, 0);

				canSendToUser(receiver, model, pmSettings, user);
			}
			else {
				foundDuplicateUser = true;
			}
			
			Integer count = receiverCounts.get(receiver);
			count += 1;
			
			if(receiver.equals(user.getUsersId())) {
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
	
	private void canSendToUser(Integer receiverId, PersonalMessage model, PersonalMessagingSettings pmSettings, Users user){
		if(!pmSettings.getReceiveFromId().equals(1)) {
		
			List<Buddy> ignoreList = buddyDataProvider.getIgnoresByUserId(receiverId);
			
			for(Buddy ignore : ignoreList) {
				if(ignore.getUserBId().equals(user.getUsersId())) {
					Rule participants = new Rule();
					participants.setRuleName("IGNORE_USER");
					participants.setErrorMessage("You may not contact this user.");
					model.getErrors().getRuleErrors().add(participants);
					return;
				}
			}
			
			if(!pmSettings.getReceiveFromId().equals(2)) {
				boolean isStaff = false;
				
				for(Permissions perm : user.getPermissions()) {
					if(perm.getPermissionsCode().equals(UserConstants.permissions.ZFGC_STAFF)) {
						isStaff = true;
						break;
					}
				}
				
				if(pmSettings.getReceiveFromId().equals(4)) {
					if(!isStaff) {
						Rule participants = new Rule();
						participants.setRuleName("IGNORE_USER");
						participants.setErrorMessage("You may not contact this user.");
						model.getErrors().getRuleErrors().add(participants);
						return;
					}
				}
				else {
					List<Buddy> buddyList = buddyDataProvider.getBuddiesByUserId(receiverId);
					
					for(Buddy buddy : buddyList) {
						if(buddy.getUserBId().equals(user.getUsersId())) {
							return;
						}
					}
					
					if(!isStaff) {
						Rule participants = new Rule();
						participants.setRuleName("IGNORE_USER");
						participants.setErrorMessage("You may not contact this user.");
						model.getErrors().getRuleErrors().add(participants);
					}
				}
			}
		}
	}
}
