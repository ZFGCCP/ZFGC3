package com.zfgc.util.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

public class ZfgcTimeUtils extends DateUtils {
	public static final long MILIS_PER_YEAR = 31540000000L;
	
	public static String createDateAsString(String timeInMs){
		Long result = Long.parseLong(timeInMs);
		SimpleDateFormat sdf = ZfgcTimeUtils.getZfgcSimpleDateTimeFormat();
		
		return sdf.format(new Date(result));
	}
	
	public static SimpleDateFormat getZfgcSimpleDateTimeFormat(){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		return sdf;
	}
	
	public static SimpleDateFormat getZfgcSimpleDateTimeFormat(String timezone){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone(timezone));
		
		return sdf;
	}
	
	public static SimpleDateFormat getZfgcSimpleDateFormat(){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		return sdf;
	}
	
	public static SimpleDateFormat getZfgcSimpleDateFormat(String timezone){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone(timezone));
		
		return sdf;
	}
	
	public static Calendar getCalendar(){
		return getCalendar("GMT");
	}
	
	public static Calendar getCalendar(String timezone){
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone(timezone));
		
		return cal;
	}
	
	public static Date getToday(){
		Calendar cal = getCalendar();
		return cal.getTime();
	}
	
	public static Date getToday(String timezone){
		return getCalendar(timezone).getTime();
	}
	
	public static long getMsBetween(Date startDate, Date endDate){
		Calendar cal = getCalendar();
		cal.setTime(startDate);
		long startMs = cal.getTimeInMillis();
		cal.setTime(endDate);
		long endMs = cal.getTimeInMillis();
		
		return endMs - startMs;
	}
	
	public static long getDaysBetween(Date startDate, Date endDate){
		long msBetween = getMsBetween(startDate, endDate);
		return miliSecondsToDays(msBetween);
	}
	
	public static long getYearsBetween(Date startDate, Date endDate){
		long msBetween = getMsBetween(startDate, endDate);
		return miliSecondsToYears(msBetween);
	}
	
	public static long miliSecondsToSeconds(long ms){
		return ms / MILLIS_PER_SECOND;
	}
	
	public static long miliSecondsToMinutes(long ms){
		return ms / MILLIS_PER_MINUTE;
	}
	
	public static long miliSecondsToHours(long ms){
		return ms / MILLIS_PER_HOUR;
	}
	
	public static long miliSecondsToDays(long ms){
		return ms / MILLIS_PER_DAY;
	}
	
	public static long miliSecondsToYears(long ms){
		return ms / MILIS_PER_YEAR;
	}
}
