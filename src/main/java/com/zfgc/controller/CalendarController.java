package com.zfgc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		try{
			List<UpcomingCalendar> events = calendarService.getUpcomingCalendarEvents(false, zfgcUser());
			return ResponseEntity.ok(events);
		}
		catch(RuntimeException ex){
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(value="/birthday", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseEntity getUpcomingBirthdays(){
		try{
			List<UpcomingCalendar> events = calendarService.getUpcomingCalendarEvents(true, zfgcUser());
			return ResponseEntity.ok(events);
		}
		catch(RuntimeException ex){
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}