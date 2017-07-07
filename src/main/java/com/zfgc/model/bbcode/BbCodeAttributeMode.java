package com.zfgc.model.bbcode;

import java.util.ArrayList;
import java.util.List;

public class BbCodeAttributeMode {
	private List<BbCodeAttribute> attributes = new ArrayList<>();
	private String openTag;
	private String closeTag;
	private Boolean contentIsAttribute = false;
	private Boolean outputContent = true;
	private Integer bbCodeAttributeModeId;
	
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
	public Boolean getContentIsAttribute() {
		return contentIsAttribute;
	}
	public void setContentIsAttribute(Boolean contentIsAttribute) {
		this.contentIsAttribute = contentIsAttribute;
	}
	public Boolean getOutputContent() {
		return outputContent;
	}
	public void setOutputContent(Boolean outputContent) {
		this.outputContent = outputContent;
	}
	public Integer getBbCodeAttributeModeId() {
		return bbCodeAttributeModeId;
	}
	public void setBbCodeAttributeModeId(Integer bbCodeAttributeModeId) {
		this.bbCodeAttributeModeId = bbCodeAttributeModeId;
	}
	
}
