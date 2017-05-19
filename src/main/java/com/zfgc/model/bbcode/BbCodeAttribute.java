package com.zfgc.model.bbcode;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.zfgc.util.time.ZfgcTimeUtils;

public class BbCodeAttribute{
	private AttributeDataType dataType;
	private String attributeIndex;
	private String name;

	public AttributeDataType getDataType() {
		return dataType;
	}

	public void setDataType(AttributeDataType dataType) {
		this.dataType = dataType;
	}

	public String transformValue(String value){
		String result = "";
		
		switch(dataType){
		case TIMESTAMP:
			result = createDate(value);
			break;
			
		case TEXT:
			result = value;
			break;
		}

		return result;
	}
	
	private String createDate(String value){
		return ZfgcTimeUtils.createDateAsString(value);
	}

	public String getAttributeIndex() {
		return attributeIndex;
	}

	public void setAttributeIndex(String attributeIndex) {
		this.attributeIndex = attributeIndex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}