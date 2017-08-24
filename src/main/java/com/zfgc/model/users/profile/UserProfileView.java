package com.zfgc.model.users.profile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.util.time.ZfgcTimeUtils;

public class UserProfileView extends BaseZfgcModel {
	private Integer usersId;
	private ProfileSummary profileSummary;
	
	@JsonIgnore
	private UserProfileView savedProfile;
	
	public UserProfileView getSavedProfile() {
		return savedProfile;
	}
	public void setSavedSummary(UserProfileView savedProfile) {
		this.savedProfile = savedProfile;
	}
	public Integer getUsersId() {
		return usersId;
	}
	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}
	public ProfileSummary getProfileSummary() {
		return profileSummary;
	}
	public void setProfileSummary(ProfileSummary profileSummary) {
		this.profileSummary = profileSummary;
	}
	@Override
	public String getHMAC() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public BaseZfgcModel copy(BaseZfgcModel other) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
