package com.zfgc.model.calendar;

import java.util.ArrayList;
import java.util.List;

import com.zfgc.model.BaseZfgcModel;

public class CalendarWeek extends BaseZfgcModel {

	private List<CalendarDate> daysOfWeek = new ArrayList<>();
	
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CalendarDate> getDaysOfWeek() {
		return daysOfWeek;
	}

	public void setDaysOfWeek(List<CalendarDate> daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}

}
