package com.zfgc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("zfgc.generalConfig")
public class ZfgcGeneralConfig {
	private String recaptchaV2Key;

	public String getRecaptchaV2Key() {
		return recaptchaV2Key;
	}

	public void setRecaptchaV2Key(String recaptchaV2Key) {
		this.recaptchaV2Key = recaptchaV2Key;
	}
	
}