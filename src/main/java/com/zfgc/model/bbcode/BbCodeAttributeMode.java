package com.zfgc.model.bbcode;

import java.util.List;

public class BbCodeAttributeMode {
	private List<BbCodeAttribute> attributes;
	private String openTag;
	private String closeTag;
	
	public List<BbCodeAttribute> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<BbCodeAttribute> attributes) {
		this.attributes = attributes;
	}
	public String getOpenTag() {
		return openTag;
	}
	public void setOpenTag(String openTag) {
		this.openTag = openTag;
	}
	public String getCloseTag() {
		return closeTag;
	}
	public void setCloseTag(String closeTag) {
		this.closeTag = closeTag;
	}
	
}
