package com.zfgc.util;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;

public class ZfgcStringUtils extends StringUtils{
	
	public static char[] getUnderlyingStringArray(String input) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		final Field field = String.class.getDeclaredField("value");
		field.setAccessible(true);
		final char[] chars = (char[]) field.get(input);
		
		return chars;
	}
}