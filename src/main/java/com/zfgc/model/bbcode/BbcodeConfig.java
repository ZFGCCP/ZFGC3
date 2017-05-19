package com.zfgc.model.bbcode;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class BbcodeConfig{
	private String code;
	private String startTag;
	private String endTag;
	private Boolean processContentFlag = true;
	private String allAttributeNamesAsString;

	private Map<String,BbCodeAttributeMode> attributeConfig;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStartTag() {
		return startTag;
	}
	public void setStartTag(String startTag) {
		this.startTag = startTag;
	}
	public String getEndTag() {
		return endTag;
	}
	public void setEndTag(String endTag) {
		this.endTag = endTag;
	}
	public Boolean getProcessContentFlag() {
		return processContentFlag;
	}
	public void setProcessContentFlag(Boolean processContentFlag) {
		this.processContentFlag = processContentFlag;
	}
	public Map<String, BbCodeAttributeMode> getAttributeConfig() {
		return attributeConfig;
	}

	public void setAttributeConfig(Map<String, BbCodeAttributeMode> attributeConfig) {
		this.attributeConfig = attributeConfig;
	}
	public String getAllAttributeNamesAsString() {
		return allAttributeNamesAsString;
	}
	public void setAllAttributeNamesAsString(String allAttributeNamesAsString) {
		this.allAttributeNamesAsString = allAttributeNamesAsString;
	}
}