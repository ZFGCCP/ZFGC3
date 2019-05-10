package com.zfgc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dbobj.UpcomingCalendarViewDbObj;
import com.zfgc.dbobj.UpcomingCalendarViewDbObjExample;
import com.zfgc.mappers.UpcomingCalendarViewDbObjMapper;
import com.zfgc.model.calendar.UpcomingCalendar;

@Component
public class UpcomingCalendarDao extends AbstractDao<UpcomingCalendarViewDbObjExample, UpcomingCalendarViewDbObj, UpcomingCalendar>{

	@Autowired
	private UpcomingCalendarViewDbObjMapper upcomingCalendarViewDbObjMapper;
	
	@Override
	public List<UpcomingCalendarViewDbObj> get(
			UpcomingCalendarViewDbObjExample ex) throws RuntimeException {
		return upcomingCalendarViewDbObjMapper.selectByExample(ex);
	}

	@Override
	public void hardDelete(UpcomingCalendar obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrInsert(UpcomingCalendar obj) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByExample(UpcomingCalendar obj,
			UpcomingCalendarViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteByExample(UpcomingCalendar obj,
			UpcomingCalendarViewDbObjExample ex) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByExample(UpcomingCalendar obj,
			UpcomingCalendarViewDbObjExample ex) throws RuntimeException {
		return (long)upcomingCalendarViewDbObjMapper.countByExample(ex);
	}


	
}