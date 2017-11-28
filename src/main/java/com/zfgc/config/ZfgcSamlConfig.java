package com.zfgc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("zfgc.saml")
public class ZfgcSamlConfig {

	private String entityId;
	private String scheme;
	private String contextPath;
	private String serverName;
	private Integer serverPort;
	private String metadataUrl;
	private String defaultSuccessUrl;
	private	String defaultFailureUrl;
	private	String idpSelectionPageUrl;
	
	public String getDefaultSuccessUrl() {
		return defaultSuccessUrl;
	}

	public void setDefaultSuccessUrl(String defaultSuccessUrl) {
		this.defaultSuccessUrl = defaultSuccessUrl;
	}

	public String getDefaultFailureUrl() {
		return defaultFailureUrl;
	}

	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}

	public String getIdpSelectionPageUrl() {
		return idpSelectionPageUrl;
	}

	public void setIdpSelectionPageUrl(String idpSelectionPageUrl) {
		this.idpSelectionPageUrl = idpSelectionPageUrl;
	}
	
	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public Integer getServerPort() {
		return serverPort;
	}

	public void setServerPort(Integer serverPort) {
		this.serverPort = serverPort;
	}

	public String getMetadataUrl() {
		return metadataUrl;
	}

	public void setMetadataUrl(String metadataUrl) {
		this.metadataUrl = metadataUrl;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
	
	public String getEntityBaseUrl(){
		return scheme + "://" + serverName + ":" + serverPort + contextPath;
	}
}
