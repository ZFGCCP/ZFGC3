package com.zfgc.model.bbcode;

import java.util.regex.Pattern;

public class BbcodeConfig{
	private String code;
	private String startTag;
	private String endTag;
	private Boolean processContentFlag = true;
	private String attributeFormat = "^(?![\\s\\S])";
	private Pattern attributePattern;
	
	public void compileAttributePattern(){
		attributePattern = Pattern.compile(attributeFormat);
	}
	
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
	public String getAttributeFormat() {
		return attributeFormat;
	}
	public void setAttributeFormat(String attributeFormat) {
		this.attributeFormat = attributeFormat;
	}
	public Pattern getAttributePattern() {
		return attributePattern;
	}
	public void setAttributePattern(Pattern attributePattern) {
		this.attributePattern = attributePattern;
	}
}