package com.zfgc.services.calendar;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.CalendarDataProvider;
import com.zfgc.model.calendar.UpcomingCalendar;
import com.zfgc.model.users.Users;
import com.zfgc.services.AbstractService;
import com.zfgc.util.time.ZfgcTimeUtils;

@Component
public class CalendarService extends AbstractService{
	
	@Autowired
	private CalendarDataProvider calendarDataProvider;
	
	public List<UpcomingCalendar> getUpcomingCalendarEvents(Boolean birthDay, Users user){
		List<UpcomingCalendar> result = null;
		
		if(birthDay){
			result = calendarDataProvider.getUpcomingBirthdays(ZfgcTimeUtils.getToday(), 5);
		}
		else{
			result = calendarDataProvider.getUpcomingEvents(ZfgcTimeUtils.getToday(), 5);
		}
		
		return result;
	}
	
}
