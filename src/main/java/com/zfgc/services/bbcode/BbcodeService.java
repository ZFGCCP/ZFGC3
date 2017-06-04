package com.zfgc.services.bbcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.zfgc.dao.LookupDao;
import com.zfgc.model.bbcode.BbCodeAttribute;
import com.zfgc.model.bbcode.BbCodeAttributeMode;
import com.zfgc.model.bbcode.Bbcode;
import com.zfgc.model.bbcode.BbcodeConfig;
import com.zfgc.services.AbstractService;
import com.zfgc.util.ZfgcStringUtils;

@Component
public class BbcodeService{

	public Map<String,BbcodeConfig> validBbCodes = new HashMap<>();
	public Map<String,Integer> bbCodeCounts= new HashMap<>();
	private Boolean outputContent = true;
	Logger LOGGER = Logger.getLogger(BbcodeService.class);
	
	public String parseText(String input) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		
		final char[] inputChar = ZfgcStringUtils.getUnderlyingStringArray(input);
		final int length = input.length();
		final MutableInt NEG = new MutableInt(-1);
		final MutableInt ZERO = new MutableInt(0);
		StringBuilder output = new StringBuilder();
		StringBuilder currentBuffer = new StringBuilder();
		StringBuilder sideBuffer = new StringBuilder();
		String currentState = null;
		String currentCode = null;
		int lastKnownFreshPosition = 0;
		int i = 0;
		int openBracePos = -1;
		int closeBracePos = -1;
		int attributeBeginPos = -1;
		Stack<String> states = new Stack<>();
		Stack<String> codes = new Stack<>();
		MutableInt contentAttPos = new MutableInt(-1);
		
		
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
				}while((inputChar[i] >= 'a' && inputChar[i] <= 'z') && (inputChar[i] != ' ' && inputChar[i] != '='));

				//check if this matches a valid bbcode. If so, find the next ]
				//edge cases: we hit the end of the string, or we hit another [
				//or we're already in a close brace
				if(bbCodeCounts.keySet().contains(bbCodetest)){
					attributeBeginPos = i;
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
							
							if(states.size() == 0 || (!currentCode.equals(bbCodetest) && validBbCodes.get(currentCode).getProcessContentFlag()) ){//we've got a stray closing tag
								output.append(inputChar,lastKnownFreshPosition, i - lastKnownFreshPosition + 1);
								lastKnownFreshPosition = i + 1;
								
								//revert to the previous state if one exists
								
								if(states.size() > 0){
									output.append(validBbCodes.get(bbCodetest).getEndTag());
									bbCodeCounts.replace(bbCodetest, bbCodeCounts.get(bbCodetest) - 1);
									states.pop();
									codes.pop();
									if(states.size() == 0){
										currentState = "";
										currentCode = "";
									}
									else{
										currentState = states.peek();
										currentCode = codes.peek();
									}
								}
							}
							else if(currentCode.equals(bbCodetest)){//this is a matched closing tag
								//revert to previous state
								
								if(validBbCodes.get(currentCode).getProcessContentFlag() || (currentCode + "0").equals(states.peek())){
									
									if(contentAttPos.compareTo(NEG) > 0){
										sideBuffer.append(inputChar,lastKnownFreshPosition,closeBracePos - lastKnownFreshPosition);
										output.replace(contentAttPos.getValue(), contentAttPos.getValue() + 5, sideBuffer.toString());
										contentAttPos.setValue(-1);
										sideBuffer.delete(0, sideBuffer.length());
									}

									if(outputContent){
										output.append(inputChar,lastKnownFreshPosition,closeBracePos - lastKnownFreshPosition);
									}
									output.append(validBbCodes.get(bbCodetest).getEndTag());
									lastKnownFreshPosition = i + 1;
									outputContent = true;
								}
								
								bbCodeCounts.replace(bbCodetest, bbCodeCounts.get(bbCodetest) - 1);
								states.pop();
								codes.pop();
								if(states.size() == 0){
									currentState = "";
									currentCode = "";
								}
								else{
									currentState = states.peek();
									currentCode = codes.peek();
								}
							}
						}
						else{
							//just doing this lazy for now...
							if(currentCode == null || currentCode.equals("") || validBbCodes.get(currentCode).getProcessContentFlag()){
								char[] attributes = new char[i - attributeBeginPos];
								for(int j = 0; j < i - attributeBeginPos; j++){
									attributes[j] = inputChar[attributeBeginPos + j];
								}
								
								String parsedTag = processAttributes(validBbCodes.get(bbCodetest),attributes,contentAttPos);
								if(contentAttPos.compareTo(ZERO) >= 0){
									contentAttPos.add(output.length());
								}
								//state change
								//record whatever we found up to this point
								//replace the bbcode with its html opening
								if(states.size() == 0 || validBbCodes.get(currentCode).getProcessContentFlag()){
									if(lastKnownFreshPosition != openBracePos){
										output.append(inputChar,lastKnownFreshPosition,openBracePos -  lastKnownFreshPosition);
									}
									output.append(parsedTag);
									
									//if(states.size() == 0  || !validBbCodes.get(currentCode).getProcessContentFlag()){
										currentCode = bbCodetest;
									//}
									lastKnownFreshPosition = i + 1;
								}	
								
								currentState = bbCodetest + bbCodeCounts.get(bbCodetest);
								states.push(currentState);
								codes.push(bbCodetest);
								bbCodeCounts.replace(bbCodetest, bbCodeCounts.get(bbCodetest) + 1);
							}
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
		output.append(inputChar,lastKnownFreshPosition,length - lastKnownFreshPosition);

		//if we have any unfinished states, close them out
		while(!codes.isEmpty()){
			output.append(validBbCodes.get(codes.pop()).getEndTag());
			states.pop();
			
		}

		resetCounts();
		
		return output.toString();
	}
	
	public String processAttributes(BbcodeConfig bbCode, char[] attributes, MutableInt contentAttPos){
		String[] allAttributeNames = bbCode.getAllAttributeNamesAsString().split(",");
		Map<String,String> attributeValues = new TreeMap<>();
		StringBuilder atts = new StringBuilder();
		atts.append(attributes);
		StringBuilder attFormat = new StringBuilder();
		
		int nextAttPos = -1;
		for(int i = 0; i < allAttributeNames.length; i++){
			String attName = allAttributeNames[i];
			
			int attPos = 0;
			
			if(attName.equals("=") && attFormat.length() > 0){
				continue;
			}
			else{
				if(nextAttPos > -1 && nextAttPos != atts.length() + 1){
					attPos = nextAttPos;
				}
				else{
					attPos = atts.indexOf(attName);
				}
			}
			
			if(i + 1< allAttributeNames.length && !allAttributeNames[i + 1].equals("=")){
				nextAttPos = atts.indexOf(allAttributeNames[i + 1]);
			}
			else{
				nextAttPos = atts.length() + 1;
			}
			
			if(nextAttPos == -1){
				nextAttPos = atts.length() + 1;
			}
			
			
			//if the attribute isn't found, then fuck it, abort!
			if(attPos == -1 || nextAttPos - 1 <= attPos){
				continue;
			}
			
			//find the value
			String value = atts.substring(attPos + attName.length(), nextAttPos - 1);
			attributeValues.put(attName, value);
			attFormat.append(attName);
		}
		
		if(!bbCode.getAttributeConfig().containsKey(attFormat.toString())){
			return atts.toString();
		}
		
		BbCodeAttributeMode attMode = bbCode.getAttributeConfig().get(attFormat.toString());
		StringBuilder result = new StringBuilder();
		result.append(attMode.getOpenTag());
		String output = result.toString();
		for(int i = 0; i < attMode.getAttributes().size(); i++){
			BbCodeAttribute attribute = attMode.getAttributes().get(i);
			String attName = attribute.getName();
			String value = attribute.transformValue(attributeValues.get(attName));
			output = StringUtils.replace(output, attribute.getAttributeIndex(), value);
		
		}
		
		if(attMode.getContentIsAttribute()){
			contentAttPos.setValue(output.indexOf("{{c}}"));
			
			if(!attMode.getOutputContent()){
				outputContent = false;
			}
		}
		
		return output.toString();
	}
	
	private void resetCounts(){
		for(String x : bbCodeCounts.keySet()){
			bbCodeCounts.put(x, 0);
		}
	}
	
	@PostConstruct
	public void loadBbCodeConfig(){
		LOGGER.info("Loading Bbcode config...");
		
		LOGGER.info("Finished loading Bbcode config.");
	}
}