package com.zfgc.util;

import org.apache.commons.lang3.ArrayUtils;

public class ZfgcCollectionUtils extends ArrayUtils {
	
	public static <T> Boolean CoalesceEquals(T compare, T ... values) {
		if(compare != null) {
			
			for(T value : values) {
				if(value != null) {
					if (compare.equals(value)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
}