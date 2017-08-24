package com.zfgc.model.users.profile;

import java.util.ArrayList;
import java.util.List;

import com.zfgc.model.BaseZfgcModel;

public class NavTab extends BaseZfgcModel {

	private Integer navTabId;
	private Integer navSectionId;
	private String title;
	private Boolean active;
	private Boolean allowSelfFlag;
	
	private List<NavTab> subTabs = new ArrayList<>();
	
	
	public Integer getNavTabId() {
		return navTabId;
	}


	public void setNavTabId(Integer navTabId) {
		this.navTabId = navTabId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}


	public List<NavTab> getSubTabs() {
		return subTabs;
	}


	public void setSubTabs(List<NavTab> subTabs) {
		this.subTabs = subTabs;
	}


	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public Boolean getAllowSelfFlag() {
		return allowSelfFlag;
	}


	public void setAllowSelfFlag(Boolean allowSelfFlag) {
		this.allowSelfFlag = allowSelfFlag;
	}


	public Integer getNavSectionId() {
		return navSectionId;
	}


	public void setNavSectionId(Integer navSectionId) {
		this.navSectionId = navSectionId;
	}


	@Override
	public BaseZfgcModel copy(BaseZfgcModel other) {
		// TODO Auto-generated method stub
		return null;
	}

}
