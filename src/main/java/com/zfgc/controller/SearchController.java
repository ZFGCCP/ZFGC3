package com.zfgc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zfgc.model.search.UserSearch;
import com.zfgc.services.search.SearchService;

@Component
@RequestMapping("/search")
public class SearchController extends BaseController{

	@Autowired
	SearchService searchService;
	
	@RequestMapping(value="/simpleUserSearch", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseEntity doSimpleUserSearch(@RequestParam("query") String queryString){
		List<UserSearch> results = searchService.simpleUserSearch(queryString);
		
		if(results == null){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new String[]{"An unexpected error has occurred. Please contact a system administrator."});
		}
		
		return ResponseEntity.ok(results);
	}
	
}
