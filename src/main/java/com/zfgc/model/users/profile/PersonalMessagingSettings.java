package com.zfgc.model.users.profile;

import java.util.List;

import com.zfgc.model.BaseZfgcModel;

public class PersonalMessagingSettings extends BaseZfgcModel{

	private Integer personalMessagingSettingsId;
    private Integer usersId;
    private Integer displaySettingId;
    private Boolean recentAtTopFlag;
    private Integer receiveFromId;
    private Integer notifyFrequencyId;
    private Boolean saveToSentFlag;
	
    private List<Buddy> buddyList;
    private List<Buddy> ignoreList;
    
	public Integer getPersonalMessagingSettingsId() {
		return personalMessagingSettingsId;
	}

	public void setPersonalMessagingSettingsId(Integer personalMessagingSettingsId) {
		this.personalMessagingSettingsId = personalMessagingSettingsId;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public Integer getDisplaySettingId() {
		return displaySettingId;
	}

	public void setDisplaySettingId(Integer displaySettingId) {
		this.displaySettingId = displaySettingId;
	}

	public Boolean getRecentAtTopFlag() {
		return recentAtTopFlag;
	}

	public void setRecentAtTopFlag(Boolean recentAtTopFlag) {
		this.recentAtTopFlag = recentAtTopFlag;
	}

	public Integer getReceiveFromId() {
		return receiveFromId;
	}

	public void setReceiveFromId(Integer receiveFromId) {
		this.receiveFromId = receiveFromId;
	}

	public Integer getNotifyFrequencyId() {
		return notifyFrequencyId;
	}

	public void setNotifyFrequencyId(Integer notifyFrequencyId) {
		this.notifyFrequencyId = notifyFrequencyId;
	}

	public Boolean getSaveToSentFlag() {
		return saveToSentFlag;
	}

	public void setSaveToSentFlag(Boolean saveToSentFlag) {
		this.saveToSentFlag = saveToSentFlag;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Buddy> getIgnoreList() {
		return ignoreList;
	}

	public void setIgnoreList(List<Buddy> ignoreList) {
		this.ignoreList = ignoreList;
	}

	public List<Buddy> getBuddyList() {
		return buddyList;
	}

	public void setBuddyList(List<Buddy> buddyList) {
		this.buddyList = buddyList;
	}
	
}