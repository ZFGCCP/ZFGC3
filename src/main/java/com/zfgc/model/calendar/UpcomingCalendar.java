package com.zfgc.model.calendar;

import java.util.Date;

import com.zfgc.model.BaseZfgcModel;

public class UpcomingCalendar extends BaseZfgcModel {

	private Integer eventId;
    private String eventName;
    private Date eventDt;
    private Boolean birthdateFlag;
	
    public String getFullEventName(){
    	String result = eventName;
    	
    	if(birthdateFlag){
    		eventName += "'s birthday";
    	}
    	
    	return result;
    }
    
	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEventDt() {
		return eventDt;
	}

	public void setEventDt(Date eventDt) {
		this.eventDt = eventDt;
	}

	public Boolean getBirthdateFlag() {
		return birthdateFlag;
	}

	public void setBirthdateFlag(Boolean birthdateFlag) {
		this.birthdateFlag = birthdateFlag;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
