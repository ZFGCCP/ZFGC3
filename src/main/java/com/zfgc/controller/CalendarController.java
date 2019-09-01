package com.zfgc.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zfgc.constants.CalendarConstants.CalendarConstants;
import com.zfgc.model.calendar.CalendarMonth;
import com.zfgc.model.calendar.CalendarWeek;
import com.zfgc.model.calendar.UpcomingCalendar;
import com.zfgc.services.calendar.CalendarService;

@Controller
@RequestMapping(value="/calendar")
public class CalendarController extends BaseController{
	
	@Autowired
	private CalendarService calendarService;
	
	@RequestMapping(value="/upcoming", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseEntity getUpcomingEvents(){
		List<UpcomingCalendar> events = calendarService.getUpcomingCalendarEvents(false, zfgcUser());
		return ResponseEntity.ok(events);
	}
	
	@RequestMapping(value="/birthday", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseEntity getUpcomingBirthdays(){
		List<UpcomingCalendar> events = calendarService.getUpcomingCalendarEvents(true, zfgcUser());
		return ResponseEntity.ok(events);
	}
	
	@RequestMapping(value="", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity getCalendarView(@RequestParam("viewTypeId") Integer viewTypeId, @RequestParam("startingDt") Date startingDt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startingDt);
		
		if(viewTypeId == CalendarConstants.ViewType.MONTH.getValue()) {
			CalendarMonth month = calendarService.getMonthView(cal);
			return ResponseEntity.ok(month);
		}
		/*else if(viewTypeId == CalendarConstants.ViewType.WEEK.getValue()) {
			CalendarWeek week = calendarService.getWeekView(cal, );
			return ResponseEntity.ok(week);
		}*/
		
		throw new RuntimeException();
	}
	
}