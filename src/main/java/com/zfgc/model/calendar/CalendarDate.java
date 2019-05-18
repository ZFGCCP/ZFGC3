package com.zfgc.model.calendar;

import com.zfgc.model.BaseZfgcModel;

public class CalendarDate extends BaseZfgcModel {

	private Integer date;
	
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
	
}