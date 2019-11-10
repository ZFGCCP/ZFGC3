package com.zfgc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("zfgc.general")
public class ZfgcGeneralConfig {
	private String recaptchaV2Key;
	private String uiUrl;
	private String userStackApiKey;
	private String avatarDirectory;

	public String getRecaptchaV2Key() {
		return recaptchaV2Key;
	}

	public void setRecaptchaV2Key(String recaptchaV2Key) {
		this.recaptchaV2Key = recaptchaV2Key;
	}

	public String getUiUrl() {
		return uiUrl;
	}

	public void setUiUrl(String uiUrl) {
		this.uiUrl = uiUrl;
	}

	public String getUserStackApiKey() {
		return userStackApiKey;
	}

	public void setUserStackApiKey(String userStackApiKey) {
		this.userStackApiKey = userStackApiKey;
	}

	public String getAvatarDirectory() {
		return avatarDirectory;
	}

	public void setAvatarDirectory(String avatarDirectory) {
		this.avatarDirectory = avatarDirectory;
	}
	
}