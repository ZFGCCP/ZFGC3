package com.zfgc.model.users.profile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.avatar.Avatar;
import com.zfgc.util.time.ZfgcTimeUtils;

public class PersonalInfo extends BaseZfgcModel {

	@JsonIgnore
	private Date birthDate;
	private String customTitle;
	private String personalText;
	private Integer genderId;
	private String location;
	private String websiteTitle;
	private String websiteUrl;
	private String signature;
	private String signaturePreview;
	private Integer userPersonalInfoId;
	private Integer usersId;
	private Integer avatarId;
	
	private Avatar avatar;

	public Long getAge(){
		if(birthDate == null){
			return null;
		}
		
		Long age = ZfgcTimeUtils.getYearsBetween(birthDate, ZfgcTimeUtils.getToday());
		
		return age;
	}
	
	public Integer getAvatarId(){
		return this.avatarId;
	}
	
	public void setAvatarId(Integer avatarId) {
		this.avatarId = avatarId;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCustomTitle() {
		return customTitle;
	}

	public void setCustomTitle(String customTitle) {
		this.customTitle = customTitle;
	}

	public String getPersonalText() {
		return personalText;
	}

	public void setPersonalText(String personalText) {
		this.personalText = personalText;
	}

	public Integer getGenderId() {
		return genderId;
	}

	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getWebsiteTitle() {
		return websiteTitle;
	}

	public void setWebsiteTitle(String websiteTitle) {
		this.websiteTitle = websiteTitle;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public String getBirthDateAsString() {
		if(birthDate == null){
			return "";
		}
		
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat();
		return sdf.format(birthDate);
	}
	
	public void setBirthDateAsString(String birthDateAsString){
		if(StringUtils.isEmpty(birthDateAsString)){
			birthDate = null;
		}
		
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat();
		try {
			birthDate = sdf.parse(birthDateAsString);
		} catch (ParseException e) {
			birthDate = null;
			e.printStackTrace();
		}
	}
	
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getSignaturePreview() {
		return signaturePreview;
	}

	public void setSignaturePreview(String signaturePreview) {
		this.signaturePreview = signaturePreview;
	}

	public Integer getUserPersonalInfoId() {
		return userPersonalInfoId;
	}

	public void setUserPersonalInfoId(Integer userPersonalInfoId) {
		this.userPersonalInfoId = userPersonalInfoId;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}
	
}