package com.zfgc.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.ulisesbocchio.spring.boot.security.saml.annotation.SAMLUser;
import com.github.ulisesbocchio.spring.boot.security.saml.user.SAMLUserDetails;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.forum.Forum;
import com.zfgc.model.forum.ForumIndex;
import com.zfgc.model.forum.Thread;
import com.zfgc.model.users.Users;
import com.zfgc.services.bbcode.BbcodeService;
import com.zfgc.services.forum.ForumService;
import com.zfgc.services.forum.ThreadService;

@RestController
@RequestMapping("/forum")
public class ForumController extends BaseController {

	@Autowired
	ForumService forumService;
	
	@Autowired
	BbcodeService bbCodeService;
	
	@Autowired
	ThreadService threadService;
	
	/*@RequestMapping(value="/zfgc-sp/saml/saml/SSO", method=RequestMethod.GET,produces="application/json")
	public ResponseEntity home(@SAMLUser SAMLUserDetails user){
		return null;
	}*/
	
	@RequestMapping(value="/index", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity getForumIndex(){
		ForumIndex forumIndex = forumService.getForumIndex(zfgcUser());
		if(forumIndex == null){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new String[]{"An unexpected error has occurred. Please contact a system administrator."});
		}
		return ResponseEntity.ok(forumIndex);
	}
	
	@RequestMapping(value="/{forumId}", method=RequestMethod.GET,produces="application/json")
	public ResponseEntity getForum(@PathVariable("forumId") Short forumId, 
			                       @RequestParam("itemsPerPage") Integer itemsPerPage, 
			                       @RequestParam("pageNo") Integer pageNo){
		Forum forum = forumService.getForum(forumId, itemsPerPage, pageNo,zfgcUser());
		
		if(forum == null){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new String[]{"An unexpected error has occurred. Please contact a system administrator."});
		}
		
		return ResponseEntity.ok(forum);
	}
	
	@RequestMapping(value="/{forumId}/thread/template", method=RequestMethod.GET,produces="application/json")
	@PreAuthorize("hasRole('ZFGC_THREAD_CREATOR')")
	public ResponseEntity getNewThreadTemplate(@PathVariable("forumId") Integer forumId) {
		Thread thread = threadService.getThreadTemplate(forumId, zfgcUser());
		return ResponseEntity.ok(thread);
	}
	
	@RequestMapping(value="/{forumId}/thread/preview", method=RequestMethod.POST, produces="application/json")
	@PreAuthorize("hasRole('ZFGC_THREAD_CREATOR')")
	public ResponseEntity previewThread(@PathVariable("forumId") Integer forumId, @RequestBody Thread thread) {
		return ResponseEntity.ok(threadService.previewThread(thread, zfgcUser()));
	}
	
	@RequestMapping(value="/{forumId}/thread", method=RequestMethod.POST, produces="application/json")
	@PreAuthorize("hasRole('ZFGC_THREAD_CREATOR')")
	public ResponseEntity saveThread(@PathVariable("forumId") Integer forumId, @RequestBody Thread thread) {
		return ResponseEntity.ok(threadService.saveNewThread(thread, zfgcUser()));
	}
}
