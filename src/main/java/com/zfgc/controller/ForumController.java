package com.zfgc.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.zfgc.model.users.Users;
import com.zfgc.services.bbcode.BbcodeService;
import com.zfgc.services.forum.ForumService;

@RestController
@RequestMapping("/forum")
public class ForumController extends BaseController {

	@Autowired
	ForumService forumService;
	
	@Autowired
	BbcodeService bbCodeService;
	
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
	
	//test for bbcodes
	@RequestMapping(value="/bbcode", method=RequestMethod.GET,produces="application/json")
	public ResponseEntity getForum(){
		try {
			bbCodeService.parseText("test test test[b]this [b][i]is[/i][/b] a test[/b][bmore test[/b]");
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		
		return (ResponseEntity) ResponseEntity.ok();
	}
}
