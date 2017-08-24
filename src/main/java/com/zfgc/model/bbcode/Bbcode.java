package com.zfgc.model.bbcode;

import java.util.List;
import java.util.Map;

import com.zfgc.model.BaseZfgcModel;

public class Bbcode extends BaseZfgcModel {
	private Integer contentStartPosition;
	private Integer contentEndPosition;
	private String bbcode;
	private Map<Integer,String> attributes;
	private String content;
	private List<Bbcode> children;
	public Integer getContentStartPosition() {
		return contentStartPosition;
	}
	public void setContentStartPosition(Integer contentStartPosition) {
		this.contentStartPosition = contentStartPosition;
	}
	public Integer getContentEndPosition() {
		return contentEndPosition;
	}
	public void setContentEndPosition(Integer contentEndPosition) {
		this.contentEndPosition = contentEndPosition;
	}
	public String getBbcode() {
		return bbcode;
	}
	public void setBbcode(String bbcode) {
		this.bbcode = bbcode;
	}
	public Map<Integer, String> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<Integer, String> attributes) {
		this.attributes = attributes;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Bbcode> getChildren() {
		return children;
	}
	public void setChildren(List<Bbcode> children) {
		this.children = children;
	}
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public BaseZfgcModel copy(BaseZfgcModel other) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
