package com.zfgc.services.calendar;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.CalendarDataProvider;
import com.zfgc.model.calendar.CalendarDate;
import com.zfgc.model.calendar.CalendarMonth;
import com.zfgc.model.calendar.CalendarWeek;
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
	
	public CalendarMonth getMonthView(Calendar cal) throws RuntimeException{
		Integer month = cal.get(Calendar.MONTH);
		Integer year = cal.get(Calendar.YEAR);
		
		Integer numWeeks = ZfgcTimeUtils.weeksInMonth(month, year);
		
		CalendarMonth result = new CalendarMonth();
		int dateLoop = 1;
		for(int i = 0; i < numWeeks; i++) {
			cal.set(Calendar.DATE, dateLoop);
			CalendarWeek week = getWeekView(cal);
			
			result.getWeeks().add(week);
			dateLoop = week.getDaysOfWeek().get(week.getDaysOfWeek().size() - 1).getDate() + 1;
		}
		
		return result;
	}
	
	public CalendarWeek getWeekView(Calendar cal) {
		Integer dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		Integer daysToStart = dayOfWeek - Calendar.SUNDAY;
		Integer daysToEnd = Calendar.SATURDAY - dayOfWeek;
		Integer firstDayOfWeek = cal.get(Calendar.DATE) - daysToStart;
		Integer lastDayOfWeek = cal.get(Calendar.DATE) + daysToEnd;
		
		CalendarWeek week = new CalendarWeek();
		
		for(int i = firstDayOfWeek; i <= lastDayOfWeek; i++) {
			CalendarDate date = new CalendarDate();
			date.setDate(i);
			week.getDaysOfWeek().add(date);
		}
		
		return week;
		
	}
	
}
