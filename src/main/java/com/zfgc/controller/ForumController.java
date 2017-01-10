package com.zfgc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.forum.Forum;
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
	
	@RequestMapping(value="/{forumId}", method=RequestMethod.GET,produces="application/json")
	public ResponseEntity getForum(@PathVariable("forumId") Short forumId, 
			                       @RequestParam("itemsPerPage") Integer itemsPerPage, 
			                       @RequestParam("pageNo") Integer pageNo){
		try {
			Forum forum = forumService.getForum(forumId, itemsPerPage, pageNo,ZfgcUser);
			
			if(forum == null){
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new String[]{"An unexpected error has occurred. Please contact a system administrator."});
			}
			
			return ResponseEntity.ok(forum);
		} catch (ZfgcNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new String[]{"The requested resource could not be found"});
		}
	}
	
}