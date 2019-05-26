package com.zfgc.services.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	Logger LOGGER = LogManager.getLogger(CalendarService.class);
	
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
		int selectedDate = cal.get(Calendar.DATE);
		
		//get all events
		List<UpcomingCalendar> events = calendarDataProvider.getEventsForMonth(cal);
		Map<Integer, List<UpcomingCalendar>> mappedEvents = mapEventsToDate(events);
		
		CalendarMonth result = new CalendarMonth();
		int dateLoop = 1;
		for(int i = 0; i < numWeeks; i++) {
			cal.set(Calendar.DATE, dateLoop);
			CalendarWeek week = getWeekView(cal, mappedEvents);
			
			result.getWeeks().add(week);
			
			if(week.getDaysOfWeek().get(week.getDaysOfWeek().size() - 1).getDate() != null) {
				dateLoop = week.getDaysOfWeek().get(week.getDaysOfWeek().size() - 1).getDate() + 1;
			}
		}
		
		//get the date object of the selected date
		for(CalendarWeek week : result.getWeeks()) {
			for(CalendarDate date : week.getDaysOfWeek()) {
				if(date.getDate() != null && date.getDate().equals(selectedDate)) {
					result.setSelectedDate(date);
					date.setIsSelected(true);
					break;
				}
			}
		}
		
		return result;
	}
	
	private Map<Integer, List<UpcomingCalendar>> mapEventsToDate(List<UpcomingCalendar> events){
		Map<Integer, List<UpcomingCalendar>> mapped = new HashMap<>();
		
		if(events != null) {
			for(UpcomingCalendar event : events) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(event.getEventDt());
				
				if(!mapped.containsKey(cal.get(Calendar.DAY_OF_MONTH))) {
					mapped.put(cal.get(Calendar.DAY_OF_MONTH), new ArrayList<>());
				}
				mapped.get(cal.get(Calendar.DAY_OF_MONTH)).add(event);
			}
		}
		
		return mapped;
	}
	
	public CalendarWeek getWeekView(Calendar cal, Map<Integer, List<UpcomingCalendar>> mappedEvents) {
		Integer dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		Integer daysToStart = dayOfWeek - Calendar.SUNDAY;
		Integer daysToEnd = Calendar.SATURDAY - dayOfWeek;
		Integer firstDayOfWeek = cal.get(Calendar.DATE) - daysToStart;
		Integer lastDayOfWeek = cal.get(Calendar.DATE) + daysToEnd;
		
		CalendarWeek week = new CalendarWeek();
		
		Calendar internalCal = Calendar.getInstance();
		internalCal.setTime(cal.getTime());
		
		LOGGER.info(internalCal.get(Calendar.MONTH));
		
		for(int i = firstDayOfWeek; i <= lastDayOfWeek; i++) {
			
			
			CalendarDate date = new CalendarDate();
			
			if(i >= 1 && i <= internalCal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
				internalCal.set(Calendar.DAY_OF_MONTH, i);
				
				date.setDate(i);
				date.setEvents(mappedEvents.get(i));
			}
			LOGGER.info(internalCal.get(Calendar.MONTH));
			date.setDayOfWeek(internalCal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US));
			date.setDateStamp(internalCal.getTime());
			
			week.getDaysOfWeek().add(date);
		}
		
		return week;
		
	}
	
}
