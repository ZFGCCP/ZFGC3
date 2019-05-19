package com.zfgc.model.calendar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.util.time.ZfgcTimeUtils;

public class CalendarDate extends BaseZfgcModel {

	private Integer date;
	private String dayOfWeek;
	private Date dateStamp;
	private List<UpcomingCalendar> events;
	
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Date getDateStamp() {
		return dateStamp;
	}

	public void setDateStamp(Date dateStamp) {
		this.dateStamp = dateStamp;
	}
	
	public String getDateStampAsString() {
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcFullDateFormat();
		
		return sdf.format(dateStamp);
	}

	public List<UpcomingCalendar> getEvents() {
		return events;
	}

	public void setEvents(List<UpcomingCalendar> events) {
		this.events = events;
	}
}