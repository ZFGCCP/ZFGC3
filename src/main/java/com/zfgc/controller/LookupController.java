package com.zfgc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zfgc.model.lookups.Lookup;
import com.zfgc.services.lookups.LookupService;

@Controller
@RequestMapping("/lookups")
public class LookupController{
	
	@Autowired
	LookupService lookupService;
	
	@RequestMapping(value="/{lkupName}", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseEntity getLookup(@PathVariable("lkupName") String lkupName){
		List<Lookup> lookup = lookupService.getLookups(lkupName);
		
		if(lookup == null){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to find the lookup " + lkupName);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(lookup);
	}
	
	@RequestMapping(value="/list", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public ResponseEntity getMultipleLookups(@RequestBody String lookupsList){
		Map<String, List<Lookup>> lookups = new HashMap<>();
		String[] lookupNames = lookupsList.split(",");
		
		for(String lk : lookupNames){
			List<Lookup> lkList = lookupService.getLookups(lk.trim());
			if(lkList != null){
				lookups.put(lk.trim(), lkList);
			}else{
				lookups.put(lk.trim() + "_FAILED_TO_LOAD", null);
			}
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(lookups);
		
	}
	
}