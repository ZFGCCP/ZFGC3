package com.zfgc.services.bbcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.zfgc.model.bbcode.Bbcode;
import com.zfgc.model.bbcode.BbcodeConfig;
import com.zfgc.services.AbstractService;
import com.zfgc.util.ZfgcStringUtils;

@Component
public class BbcodeService extends AbstractService{

	private Map<String,BbcodeConfig> validBbCodes = new HashMap<>();
	private Map<String,Integer> bbCodeCounts= new HashMap<>();
	
	public void parseText(String input) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		BbcodeConfig b = new BbcodeConfig();
		b.setCode("b");
		b.setEndTag("</span>");
		b.setStartTag("<span class='bbCode-b'>");
		b.setProcessContentFlag(false);
		validBbCodes.put("b", b);
		bbCodeCounts.put("b", 0);
		
		BbcodeConfig il = new BbcodeConfig();
		il.setCode("i");
		il.setEndTag("</span>");
		il.setStartTag("<span class='bbCode-i'>");
		validBbCodes.put("i", il);
		bbCodeCounts.put("i", 0);
		
		final char[] inputChar = ZfgcStringUtils.getUnderlyingStringArray(input);
		final int length = input.length();
		StringBuilder output = new StringBuilder();
		StringBuilder currentBuffer = new StringBuilder();
		String currentState = null;
		String currentCode = null;
		int lastKnownFreshPosition = 0;
		int i = 0;
		int openBracePos = -1;
		int closeBracePos = -1;
		Stack<String> states = new Stack<>();
		
		for(i = 0; i < length; i++){
			boolean isClosingBrace = false;
			//did we find a bbcode? maybe..
			if(inputChar[i] == '['){
				String bbCodetest = "";
				i++;
				
				//hold the phone, this might be a closing brace
				if(inputChar[i] == '/'){
					isClosingBrace = true;
					closeBracePos = i - 1;
					i++;
				}
				else{
					openBracePos = i - 1;
				}

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
				//or we're already in a close brace
				if(bbCodeCounts.keySet().contains(bbCodetest)){
					boolean foundBbCode = true;
					while(inputChar[i] != ']'){
						if(i > length || inputChar[i] == '['){
							currentBuffer.append(inputChar,lastKnownFreshPosition,(--i) - lastKnownFreshPosition);
							foundBbCode = false;
							break;
						}
						i++;
					}
					
					if(foundBbCode){
						if(isClosingBrace){
							
							if(states.size() == 0){//we've got a stray closing tag
								output.append(inputChar,lastKnownFreshPosition, i - lastKnownFreshPosition + 1);
								lastKnownFreshPosition = i + 1;
							}
							else{//this is a matched closing tag
								//revert to previous state
								
								if(validBbCodes.get(currentCode).getProcessContentFlag() || (currentCode + "0").equals(states.peek())){
									output.append(inputChar,lastKnownFreshPosition,closeBracePos - lastKnownFreshPosition);
									output.append(validBbCodes.get(currentCode).getEndTag());
									lastKnownFreshPosition = i + 1;
								}
								
								bbCodeCounts.replace(bbCodetest, bbCodeCounts.get(bbCodetest) - 1);
								states.pop();
								if(states.size() == 0){
									currentState = "";
								}
								else{
									currentState = states.peek();
								}
								
								if(validBbCodes.get(currentCode).getProcessContentFlag()){
									currentCode = currentState;
								}
							}
						}
						else{
							//state change
							//record whatever we found up to this point
							//replace the bbcode with its html opening
							if(currentCode == null || currentCode.equals("") || validBbCodes.get(currentCode).getProcessContentFlag()){
								if(lastKnownFreshPosition != openBracePos){
									output.append(inputChar,lastKnownFreshPosition,openBracePos -  lastKnownFreshPosition);
								}
								output.append(validBbCodes.get(bbCodetest).getStartTag());
								currentCode = bbCodetest;
								lastKnownFreshPosition = i + 1;
							}	
							
							currentState = bbCodetest + bbCodeCounts.get(bbCodetest);
							states.push(currentState);
							bbCodeCounts.replace(bbCodetest, bbCodeCounts.get(bbCodetest) + 1);
							
						}
						
					}
				}
				else{ //it wasn't actually a bbcode..output what we found up to this point
					int start = isClosingBrace ? closeBracePos : openBracePos;
					output.append(inputChar,start, i - start);
					lastKnownFreshPosition = i;
				}
			}
		}
		
		//if we reach the end, but we're not in a bbcode state
		//append the remaining junk
		if(states.size() == 0){
			output.append(inputChar,lastKnownFreshPosition,length - lastKnownFreshPosition);
		}
	}
}