package com.zfgc.constants.CalendarConstants;

public final class CalendarConstants {
	public enum ViewType{
		MONTH(0),
		WEEK(1),
		DAY(2);
		
		private final int VALUE;
		private ViewType(int value) {
			VALUE = value;
		}
		
		public int getValue() {
			return VALUE;
		}
	}
}
