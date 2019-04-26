package com.zfgc.model.users.profile;

import java.util.List;

import com.zfgc.model.BaseZfgcModel;

public class PersonalMessagingSettings extends BaseZfgcModel{

	private Integer personalMessagingSettingsId;
    private Integer usersId;
    private Integer receiveFromId = 1;
    private Integer notifyFrequencyId = 1;
	
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
	@Override
	public BaseZfgcModel copy(BaseZfgcModel other) {
		// TODO Auto-generated method stub
		return null;
	}
	
}