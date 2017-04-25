package com.zfgc.model.bbcode;

public class BbcodeConfig{
	private String code;
	private String startTag;
	private String endTag;
	private Boolean processContentFlag = true;
	
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
	

	
}