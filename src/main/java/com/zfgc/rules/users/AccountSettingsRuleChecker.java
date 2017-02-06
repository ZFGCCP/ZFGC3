package com.zfgc.rules.users;

import org.springframework.stereotype.Component;

import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.UserProfileView;
import com.zfgc.rules.AbstractRulesChecker;
import com.zfgc.rules.Rule;

@Component
public class AccountSettingsRuleChecker extends AbstractRulesChecker<UserProfileView>{

	@Override
	public void rulesCheck(UserProfileView model, Users user) throws Exception {
		
		if(user.getPrimaryMemberGroupId() != 2){
			if(user.getUsersId() != model.getUsersId()){
				checkProfileChanged(model);
			}
			loginNameChanged(model);
		}
	}
	
	private void loginNameChanged(UserProfileView model){
		if(!model.getProfileSummary().getLoginName().equals(model.getSavedProfile().getProfileSummary().getLoginName())){
			Rule loginNameChanged = new Rule();
			loginNameChanged.setRuleName("LOGIN_NAME_CHANGED");
			loginNameChanged.setErrorMessage("You do not have permission to modify the field 'UserName'");
			model.getErrors().getRuleErrors().add(loginNameChanged);
		}
	}
	
	private void checkProfileChanged(UserProfileView model){
		UserProfileView saved = model.getSavedProfile();
		
		if(!model.getProfileSummary().getDisplayName().equals(saved.getProfileSummary().getDisplayName()) ||
		   !model.getProfileSummary().getDateRegistered().equals(saved.getProfileSummary().getDateRegistered()) ||
		   !model.getProfileSummary().getPrimaryMemberGroupId().equals(saved.getProfileSummary().getPrimaryMemberGroupId()) ||
		   !model.getProfileSummary().getHideEmailFlag().equals(saved.getProfileSummary().getHideEmailFlag()) ||
		   !saved.getProfileSummary().getEmailAddress().equals(model.getProfileSummary().getEmailAddress())){
			   Rule profileChanged = new Rule();
			   profileChanged.setRuleName("PROFILE_CHANGED");
			   profileChanged.setErrorMessage("You do not have permission to modify this profile.");
			   model.getErrors().getRuleErrors().add(profileChanged);
		   }
	}
}