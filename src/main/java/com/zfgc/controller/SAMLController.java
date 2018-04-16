package com.zfgc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.ulisesbocchio.spring.boot.security.saml.annotation.SAMLUser;
import com.github.ulisesbocchio.spring.boot.security.saml.user.SAMLUserDetails;

@RestController
@RequestMapping("/saml")
public class SAMLController extends BaseController{
	
	@RequestMapping(value="/SSO", method=RequestMethod.POST,produces="application/json")
	public ResponseEntity sso(@SAMLUser SAMLUserDetails user){
		return null;
	}
	
	@RequestMapping(value="home", method=RequestMethod.GET,produces="application/json")
	public ResponseEntity home(){
		return null;
	}
}