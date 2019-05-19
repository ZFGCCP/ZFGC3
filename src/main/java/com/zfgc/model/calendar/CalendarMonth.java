package com.zfgc.model.calendar;

import java.util.ArrayList;
import java.util.List;

import com.zfgc.model.BaseZfgcModel;

public class CalendarMonth extends BaseZfgcModel {

	private List<CalendarWeek> weeks = new ArrayList<>();
	private Integer currentWeekIndex = 0;
	private List<UpcomingCalendar> events;
	
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CalendarWeek> getWeeks() {
		return weeks;
	}

	public void setWeeks(List<CalendarWeek> weeks) {
		this.weeks = weeks;
	}

	public Integer getCurrentWeekIndex() {
		return currentWeekIndex;
	}

	public void setCurrentWeekIndex(Integer currentWeekIndex) {
		this.currentWeekIndex = currentWeekIndex;
	}

	public List<UpcomingCalendar> getEvents() {
		return events;
	}

	public void setEvents(List<UpcomingCalendar> events) {
		this.events = events;
	}

}
