package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.UpcomingCalendarDao;
import com.zfgc.dbobj.UpcomingCalendarViewDbObj;
import com.zfgc.dbobj.UpcomingCalendarViewDbObjExample;
import com.zfgc.model.calendar.UpcomingCalendar;

@Component
public class CalendarDataProvider extends AbstractDataProvider{
	
	@Autowired
	private UpcomingCalendarDao upcomingCalendarDao;
	
	public List<UpcomingCalendar> getUpcomingEvents(Date startDt, Integer range) {
		return getUpcoming(startDt, range, false);
	}
	
	public List<UpcomingCalendar> getUpcomingBirthdays(Date startDt, Integer range){
		return getUpcoming(startDt, range, true);
	}
	
	private List<UpcomingCalendar> getUpcoming(Date startDt, Integer range, Boolean birthDay){
		Date endDt = DateUtils.addDays(startDt, range);
		UpcomingCalendarViewDbObjExample ex = upcomingCalendarDao.getExample();
		ex.createCriteria().andEventDtBetween(startDt, endDt).andBirthdateFlagEqualTo(birthDay);
		
		List<UpcomingCalendarViewDbObj> dbObj = upcomingCalendarDao.get(ex);
		List<UpcomingCalendar> obj = new ArrayList<>();
		if(dbObj != null){
			for(UpcomingCalendarViewDbObj db : dbObj){
				UpcomingCalendar calendar = mapper.map(db, UpcomingCalendar.class);
				obj.add(calendar);
			}
		}
		
		return obj;
	}
	
	public List<UpcomingCalendar> getEventsForMonth(Calendar cal){
		Integer lastDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		Calendar internalCal = Calendar.getInstance();
		internalCal.setTime(cal.getTime());
		internalCal.set(Calendar.DAY_OF_MONTH, 1);
		
		Date firstDate = internalCal.getTime();
		
		internalCal.set(Calendar.DAY_OF_MONTH, lastDayOfMonth);
		
		Date lastDate = internalCal.getTime();
		
		UpcomingCalendarViewDbObjExample ex = upcomingCalendarDao.getExample();
		ex.createCriteria().andEventDtBetween(firstDate, lastDate);
		
		List<UpcomingCalendarViewDbObj> dbObj = upcomingCalendarDao.get(ex);
		List<UpcomingCalendar> obj = new ArrayList<>();
		if(dbObj != null){
			for(UpcomingCalendarViewDbObj db : dbObj){
				UpcomingCalendar calendar = mapper.map(db, UpcomingCalendar.class);
				obj.add(calendar);
			}
		}
		
		return obj;
	}
}