package com.zfgc.util.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

public class ZfgcTimeUtils extends DateUtils {
	public static SimpleDateFormat getZfgcSimpleDateFormat(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		return sdf;
	}
	
	public static SimpleDateFormat getZfgcSimpleDateFormat(String timezone){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone(timezone));
		
		return sdf;
	}
	
	public static Calendar getCalendar(){
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		return cal;
	}
	
	public static Date getToday(){
		Calendar cal = getCalendar();
		return cal.getTime();
	}
}
