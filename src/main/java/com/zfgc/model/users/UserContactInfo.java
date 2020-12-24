package com.zfgc.model.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.zfgc.model.BaseZfgcModel;

@JsonInclude(Include.NON_NULL)
public class UserContactInfo extends BaseZfgcModel{

	private Integer userContactSettingsId;
	private Integer usersId;

	private String skype;
	private String gtalk;
	private String facebook;
	private String psn;
	private String xboxLive;
	private String steam;
	private String nnid;
	private EmailAddress email;
	
	public boolean getHasContactInfo() {
		return skype != null ||
			   gtalk != null ||
			   facebook != null ||
			   psn != null ||
			   xboxLive != null ||
			   steam != null ||
			   nnid != null ||
			   email != null;
	}
	
	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getGtalk() {
		return gtalk;
	}

	public void setGtalk(String gtalk) {
		this.gtalk = gtalk;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getPsn() {
		return psn;
	}

	public void setPsn(String psn) {
		this.psn = psn;
	}

	public String getXboxLive() {
		return xboxLive;
	}

	public void setXboxLive(String xboxLive) {
		this.xboxLive = xboxLive;
	}

	public String getSteam() {
		return steam;
	}

	public void setSteam(String steam) {
		this.steam = steam;
	}

	public String getNnid() {
		return nnid;
	}

	public void setNnid(String nnid) {
		this.nnid = nnid;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseZfgcModel copy(BaseZfgcModel other) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getUserContactSettingsId() {
		return userContactSettingsId;
	}

	public void setUserContactSettingsId(Integer userContactSettingsId) {
		this.userContactSettingsId = userContactSettingsId;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public EmailAddress getEmail() {
		return email;
	}

	public void setEmail(EmailAddress email) {
		this.email = email;
	}
	
}