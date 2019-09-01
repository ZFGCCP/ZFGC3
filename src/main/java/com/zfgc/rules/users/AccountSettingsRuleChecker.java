package com.zfgc.rules.users;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.UsersDataProvider;
import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.UserProfileView;
import com.zfgc.rules.AbstractRulesChecker;
import com.zfgc.rules.Rule;

@Component
public class AccountSettingsRuleChecker extends AbstractRulesChecker<UserProfileView>{

	@Autowired
	UsersDataProvider usersDataProvider;
	
	@Override
	public void rulesCheck(UserProfileView model, Users user) throws RuntimeException {
		
		/*if(user.getPrimaryMemberGroupId() != 2){
			if(user.getUsersId() != model.getUsersId()){
				checkProfileChanged(model);
			}
			loginNameChanged(model);
		}*/
		
		if(!StringUtils.isEmpty(model.getUserSecurityInfo().getCurrentPassword())){
			if(!usersDataProvider.checkUserPassword(model.getUsersId(), model.getUserSecurityInfo().getCurrentPassword())){
				Rule wrongPassword = new Rule();
				wrongPassword.setRuleName("WRONG_PASSWORD");
				wrongPassword.setErrorMessage("The password you entered is invalid.");
				model.getErrors().getRuleErrors().add(wrongPassword);
			}
		}
	}
	
	/*private void loginNameChanged(Users model){
		if(!model.getProfileSummary().getLoginName().equals(model.getSavedProfile().getProfileSummary().getLoginName())){
			Rule loginNameChanged = new Rule();
			loginNameChanged.setRuleName("LOGIN_NAME_CHANGED");
			loginNameChanged.setErrorMessage("You do not have permission to modify the field 'UserName'");
			model.getErrors().getRuleErrors().add(loginNameChanged);
		}
	}
	
	private void checkProfileChanged(Users model){
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
	}*/
}