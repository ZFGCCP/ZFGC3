package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.BbcodeDao;
import com.zfgc.dbobj.BbCodeAttributeDbObj;
import com.zfgc.dbobj.BbCodeAttributeModeDbObj;
import com.zfgc.dbobj.BbCodeConfigDbObj;
import com.zfgc.dbobj.IpAddressDbObj;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.bbcode.AttributeDataType;
import com.zfgc.model.bbcode.BbCodeAttribute;
import com.zfgc.model.bbcode.BbCodeAttributeMode;
import com.zfgc.model.bbcode.BbcodeConfig;
import com.zfgc.services.bbcode.BbcodeService;

@Component
public class BbCodeDataProvider extends AbstractDataProvider{
	@Autowired
	BbcodeDao bbCodeDao;
	
	Logger LOGGER = Logger.getLogger(BbCodeDataProvider.class);
	
	public Map<String,BbcodeConfig> getBbCodeConfig(){
		Map<String,BbcodeConfig> result = new HashMap<>();
		try {
			List<BbCodeConfigDbObj> bbCodes = bbCodeDao.getValidBbCodes();
			StringBuilder attString = null;
			for(BbCodeConfigDbObj bbCode : bbCodes){
				BbcodeConfig config = mapper.map(bbCode, BbcodeConfig.class);
				attString = new StringBuilder();
				LOGGER.info("Loading Config for " + config.getCode() + "...");
				List<BbCodeAttributeModeDbObj> modesDb = bbCodeDao.getAttributeModesByBbCode(config.getBbCodeConfigId());
				List<BbCodeAttributeMode> modes = new ArrayList<>();
				for(BbCodeAttributeModeDbObj attributeMode : modesDb){
					BbCodeAttributeMode mode = mapper.map(attributeMode, BbCodeAttributeMode.class);
					modes.add(mode);
					StringBuilder modeString = new StringBuilder();
					List<BbCodeAttributeDbObj> attributeDb = bbCodeDao.getAttributesByMode(attributeMode.getBbCodeAttributeModeId());
					List<BbCodeAttribute> attributes = new ArrayList<>();
					
					for(BbCodeAttributeDbObj attribute : attributeDb){
						BbCodeAttribute bbCodeAttribute = mapper.map(attribute, BbCodeAttribute.class);
						bbCodeAttribute.setDataType(AttributeDataType.values()[attribute.getAttributeDataType()]);
						bbCodeAttribute.setAttributeIndex("{{" + attribute.getAttributeIndex().intValue() + "}}");
						bbCodeAttribute.setName(attribute.getName().equals("NAMELESS") ? "=" : attribute.getName() + "=");
						attributes.add(bbCodeAttribute);
						modeString.append(attribute.getName().equals("NAMELESS") ? "=" : attribute.getName() + "=");
						
						if(attString.indexOf(attribute.getName()) > -1 || attString.length() == 0){
							if(attString.length() > 0){
								attString.append(",");
							}
							
							attString.append(attribute.getName().equals("NAMELESS") ? "=" : attribute.getName() + "=");
						}
					}
					
					mode.setAttributes(attributes);
					config.getAttributeConfig().put(modeString.toString(), mode);
				}
				config.setAllAttributeNamesAsString(attString.toString());
				result.put(config.getCode(), config);
			}
		} catch (ZfgcNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}