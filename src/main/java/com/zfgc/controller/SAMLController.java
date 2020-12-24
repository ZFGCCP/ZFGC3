package com.zfgc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/saml")
public class SAMLController extends BaseController{
	

	
	@RequestMapping(value="home", method=RequestMethod.GET,produces="application/json")
	public ResponseEntity home(){
		return null;
	}
}