package com.zfgc.model.users;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.util.time.ZfgcTimeUtils;

public class AuthToken extends BaseZfgcModel {
	private Integer authTokenId;
	private Integer usersId;
	private String token;
	private Date ttl;
	private Date createTimestamp;
	public Integer getAuthTokenId() {
		return authTokenId;
	}
	public void setAuthTokenId(Integer authTokenId) {
		this.authTokenId = authTokenId;
	}
	public Integer getUsersId() {
		return usersId;
	}
	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getTtl() {
		return ttl;
	}
	public void setTtl(Date ttl) {
		this.ttl = ttl;
	}
	public Date getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	
	public String getCreateTimestampAsString(){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat();
		
		if(createTimestamp == null){
			return "";
		}
		
		return sdf.format(createTimestamp);
	}
	
	public void setCreateTimestampAsString(String createTimestampAsString){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat();
		
		try{
			createTimestamp = sdf.parse(createTimestampAsString);
		}
		catch(ParseException ex){
			createTimestamp = null;
		}
	}
	
	public String getTtlAsString(){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat();
		
		if(ttl == null){
			return "";
		}
		
		return sdf.format(ttl);
	}
	
	public void setTtlAsString(String ttlAsString){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat();
		
		try{
			ttl = sdf.parse(ttlAsString);
		}
		catch(ParseException ex){
			ttl = null;
		}
	}
	@Override
	public String getHMAC() {
		// TODO Auto-generated method stub
		return null;
	}
}
