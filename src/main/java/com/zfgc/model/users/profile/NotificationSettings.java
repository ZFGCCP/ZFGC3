package com.zfgc.model.users.profile;

import com.zfgc.model.BaseZfgcModel;

public class NotificationSettings extends BaseZfgcModel{

	private Integer notificationSettingsId;
    private Boolean karmaEmailFlag;
    private Boolean karmaPmFlag;
    private Boolean taggedEmailFlag;
    private Boolean taggedPmFlag;
    private Integer frequencyId;
    private Integer usersId;
	
	public Integer getNotificationSettingsId() {
		return notificationSettingsId;
	}

	public void setNotificationSettingsId(Integer notificationSettingsId) {
		this.notificationSettingsId = notificationSettingsId;
	}

	public Boolean getKarmaEmailFlag() {
		return karmaEmailFlag;
	}

	public void setKarmaEmailFlag(Boolean karmaEmailFlag) {
		this.karmaEmailFlag = karmaEmailFlag;
	}

	public Boolean getKarmaPmFlag() {
		return karmaPmFlag;
	}

	public void setKarmaPmFlag(Boolean karmaPmFlag) {
		this.karmaPmFlag = karmaPmFlag;
	}

	public Boolean getTaggedEmailFlag() {
		return taggedEmailFlag;
	}

	public void setTaggedEmailFlag(Boolean taggedEmailFlag) {
		this.taggedEmailFlag = taggedEmailFlag;
	}

	public Boolean getTaggedPmFlag() {
		return taggedPmFlag;
	}

	public void setTaggedPmFlag(Boolean taggedPmFlag) {
		this.taggedPmFlag = taggedPmFlag;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getFrequencyId() {
		return frequencyId;
	}

	public void setFrequencyId(Integer frequencyId) {
		this.frequencyId = frequencyId;
	}

	@Override
	public BaseZfgcModel copy(BaseZfgcModel other) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}
	
}