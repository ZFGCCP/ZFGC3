package com.zfgc.model.bbcode;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.zfgc.model.BaseZfgcModel;
import com.zfgc.util.time.ZfgcTimeUtils;

public class BbCodeAttribute extends BaseZfgcModel{
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
	
	public String createDate(String value){
		return ZfgcTimeUtils.createDateAsString(value, super.getUserTimeZone());
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

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}