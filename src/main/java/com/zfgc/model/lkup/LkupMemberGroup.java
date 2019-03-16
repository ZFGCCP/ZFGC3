package com.zfgc.model.lkup;

import com.zfgc.model.BaseZfgcModel;

public class LkupMemberGroup extends BaseZfgcModel {
	private Integer memberGroupId;
    private String groupName;
    private String desc;
    private Integer minPosts;
    private String starsSprite;
    private Boolean hiddenFlag;
    private Integer parentGroup;
	public Integer getMemberGroupId() {
		return memberGroupId;
	}
	public void setMemberGroupId(Integer memberGroupId) {
		this.memberGroupId = memberGroupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getMinPosts() {
		return minPosts;
	}
	public void setMinPosts(Integer minPosts) {
		this.minPosts = minPosts;
	}
	public String getStarsSprite() {
		return starsSprite;
	}
	public void setStarsSprite(String starsSprite) {
		this.starsSprite = starsSprite;
	}
	public Boolean getHiddenFlag() {
		return hiddenFlag;
	}
	public void setHiddenFlag(Boolean hiddenFlag) {
		this.hiddenFlag = hiddenFlag;
	}
	public Integer getParentGroup() {
		return parentGroup;
	}
	public void setParentGroup(Integer parentGroup) {
		this.parentGroup = parentGroup;
	}
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
	