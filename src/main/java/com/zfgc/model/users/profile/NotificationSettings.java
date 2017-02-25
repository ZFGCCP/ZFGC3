package com.zfgc.model.users.profile;

import com.zfgc.model.BaseZfgcModel;

public class NotificationSettings extends BaseZfgcModel{

	private Integer notificationSettingsId;
    private Boolean autoSubscribeFlag;
    private Boolean sendPostInEmailFlag;
    private Boolean instantFlag;
    private Boolean onlyFirstFlag;
    private Boolean repliesFlag;
    private Boolean moderationFlag;
    private Boolean onlyMeFlag;
    private Boolean karmaEmailFlag;
    private Boolean karmaPmFlag;
    private Boolean taggedEmailFlag;
    private Boolean taggedPmFlag;
    private Boolean pmEmailFlag;
    private Integer frequencyId;
	
	public Integer getNotificationSettingsId() {
		return notificationSettingsId;
	}

	public void setNotificationSettingsId(Integer notificationSettingsId) {
		this.notificationSettingsId = notificationSettingsId;
	}

	public Boolean getAutoSubscribeFlag() {
		return autoSubscribeFlag;
	}

	public void setAutoSubscribeFlag(Boolean autoSubscribeFlag) {
		this.autoSubscribeFlag = autoSubscribeFlag;
	}

	public Boolean getSendPostInEmailFlag() {
		return sendPostInEmailFlag;
	}

	public void setSendPostInEmailFlag(Boolean sendPostInEmailFlag) {
		this.sendPostInEmailFlag = sendPostInEmailFlag;
	}

	public Boolean getInstantFlag() {
		return instantFlag;
	}

	public void setInstantFlag(Boolean instantFlag) {
		this.instantFlag = instantFlag;
	}

	public Boolean getOnlyFirstFlag() {
		return onlyFirstFlag;
	}

	public void setOnlyFirstFlag(Boolean onlyFirstFlag) {
		this.onlyFirstFlag = onlyFirstFlag;
	}

	public Boolean getRepliesFlag() {
		return repliesFlag;
	}

	public void setRepliesFlag(Boolean repliesFlag) {
		this.repliesFlag = repliesFlag;
	}

	public Boolean getModerationFlag() {
		return moderationFlag;
	}

	public void setModerationFlag(Boolean moderationFlag) {
		this.moderationFlag = moderationFlag;
	}

	public Boolean getOnlyMeFlag() {
		return onlyMeFlag;
	}

	public void setOnlyMeFlag(Boolean onlyMeFlag) {
		this.onlyMeFlag = onlyMeFlag;
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

	public Boolean getPmEmailFlag() {
		return pmEmailFlag;
	}

	public void setPmEmailFlag(Boolean pmEmailFlag) {
		this.pmEmailFlag = pmEmailFlag;
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
	
}