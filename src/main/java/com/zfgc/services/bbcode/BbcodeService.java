package com.zfgc.services.bbcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.zfgc.model.bbcode.Bbcode;
import com.zfgc.model.bbcode.BbcodeConfig;
import com.zfgc.services.AbstractService;
import com.zfgc.util.ZfgcStringUtils;

@Component
public class BbcodeService extends AbstractService{

	private List<String> validBbCodes = new ArrayList<>();
	
	public void parseText(String input) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		final char[] inputChar = ZfgcStringUtils.getUnderlyingStringArray(input);
		final int length = input.length();
		StringBuilder output = new StringBuilder();
		StringBuilder currentBuffer = new StringBuilder();
		String currentState = null;
		int lastKnownFreshPosition = 0;
		int i = 0;
		int openBracePos = 0;
		for(i = 0; i < length; i++){
			
			//did we find a bbcode? maybe..
			if(inputChar[i] == '['){
				String bbCodetest = "";
				i++;
				openBracePos = i;
				//get the alphabetical characters immediately following the brace
				//edge case: we hit the end of the string
				do{
					if(i > length){
						currentBuffer.append(inputChar,lastKnownFreshPosition,--i);
						break;
					}
					
					bbCodetest += inputChar[i];
					i++;
				}while(inputChar[i] >= 'a' && inputChar[i] <= 'z');
				
				//check if this matches a valid bbcode. If so, find the next ]
				//edge cases: we hit the end of the string, or we hit another [
				if(validBbCodes.contains(bbCodetest)){
					i++;
					do{
						if(i > length || inputChar[i] == '['){
							currentBuffer.append(inputChar,lastKnownFreshPosition,--i);
							break;
						}
						i++;
						
					}while(inputChar[i] != ']');
				}
			}
			
			
		}
		
	}
	
}