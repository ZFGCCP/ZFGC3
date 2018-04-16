package com.zfgc.model.pm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.util.time.ZfgcTimeUtils;

public class BrPmConversationArchive extends BaseZfgcModel{

	private Integer pmConversationId;
	private Integer usersId;
	private Date archiveDt;
	
	public Integer getPmConversationId() {
		return pmConversationId;
	}

	public void setPmConversationId(Integer pmConversationId) {
		this.pmConversationId = pmConversationId;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public Date getArchiveDt() {
		return archiveDt;
	}

	public void setArchiveDt(Date archiveDt) {
		this.archiveDt = archiveDt;
	}

	public String getArchiveDtAsString(){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateFormat(getUserTimeZone());
		
		if(archiveDt == null){
			return "";
		}
		
		return sdf.format(archiveDt);
	}
	
	public void setArchiveDtAsString(String archiveDtAsString){
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcTimeZoneDateFormat(getUserTimeZone());
		
		if(archiveDtAsString.equals("")){
			archiveDt = null;
		}
		
		try {
			archiveDt = sdf.parse(archiveDtAsString);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}