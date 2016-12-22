package com.zfgc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zfgc.model.forum.ForumIndex;
import com.zfgc.services.forum.ForumService;

@RestController
@RequestMapping("/forum")
public class ForumController extends BaseController {

	@Autowired
	ForumService forumService;
	
	@RequestMapping(value="/index", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity getForumIndex(){
		ForumIndex forumIndex = forumService.getForumIndex(ZfgcUser);
		
		if(forumIndex == null){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new String[]{"An unexpected error has occurred. Please contact a system administrator."});
		}
		return ResponseEntity.ok(forumIndex);
	}
	
}
