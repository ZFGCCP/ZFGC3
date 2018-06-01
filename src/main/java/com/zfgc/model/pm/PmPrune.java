package com.zfgc.model.pm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.util.time.ZfgcTimeUtils;

public class PmPrune extends BaseZfgcModel {

	private Boolean pruneFlag = true;
	private Date olderThanDt = null;
	private Date inactiveForDt = null;
	private Integer deleteStartedUserId;
	private Integer deleteContainingUserId;
	private Boolean startedByMeFlag = false;
	private TwoFactorKey tfa;
	
	public Integer getDeleteStartedUserId() {
		return deleteStartedUserId;
	}

	public void setDeleteStartedUserId(Integer deleteStartedUserId) {
		this.deleteStartedUserId = deleteStartedUserId;
	}

	public Integer getDeleteContainingUserId() {
		return deleteContainingUserId;
	}

	public void setDeleteContainingUserId(Integer deleteContainingUserId) {
		this.deleteContainingUserId = deleteContainingUserId;
	}

	public Boolean getStartedByMeFlag() {
		return startedByMeFlag;
	}

	public void setStartedByMeFlag(Boolean startedByMeFlag) {
		this.startedByMeFlag = startedByMeFlag;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public TwoFactorKey getTfa() {
		return tfa;
	}

	public void setTfa(TwoFactorKey tfa) {
		this.tfa = tfa;
	}

	public Date getInactiveForDt() {
		return inactiveForDt;
	}

	public void setInactiveForDt(Date inactiveForDt) {
		this.inactiveForDt = inactiveForDt;
	}

	public Date getOlderThanDt() {
		return olderThanDt;
	}

	public void setOlderThanDt(Date olderThanDt) {
		this.olderThanDt = olderThanDt;
	}

	public String getOlderThanDtAsString(){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat(super.getUserTimeZone());
		
		if(olderThanDt == null){
			return "";
		}
		
		return sdf.format(olderThanDt);
	}
	
	public void setOlderThanDtAsString(String olderThanDtAsString){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat(super.getUserTimeZone());
		
		try {
			olderThanDt = sdf.parse(olderThanDtAsString);
		} catch (ParseException e) {
			olderThanDt = null;
		}
	}
	
	public String getInactiveDtAsString(){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat(super.getUserTimeZone());
		
		if(olderThanDt == null){
			return "";
		}
		
		return sdf.format(olderThanDt);
	}
	
	public void setInactiveForDtAsString(String inactiveForDtAsString){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat(super.getUserTimeZone());
		
		try {
			inactiveForDt = sdf.parse(inactiveForDtAsString);
		} catch (ParseException e) {
			inactiveForDt = null;
		}
	}
	
	public Boolean getPruneFlag() {
		return pruneFlag;
	}

	public void setPruneFlag(Boolean pruneFlag) {
		this.pruneFlag = pruneFlag;
	}
	
}