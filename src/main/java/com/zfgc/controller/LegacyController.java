package com.zfgc.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zfgc.services.app.LegacyRedirectService;

@Controller
@RequestMapping("/index.php")
public class LegacyController extends BaseController{
	
	private Logger LOGGER = LogManager.getLogger(LegacyController.class);	
	
	@Autowired
	LegacyRedirectService legacyRedirectService;
	
	@RequestMapping(value="", method=RequestMethod.GET)	
	public ResponseEntity legacyRedirect(@RequestParam(name="action", required=false) String action, @RequestParam(name="u", required=false) Integer userId){
		try{
			String redirectUrl = legacyRedirectService.getRedirectLocation(action, userId, zfgcUser());
			URI redirect = new URI(redirectUrl);
		    HttpHeaders httpHeaders = new HttpHeaders();
		    httpHeaders.setLocation(redirect);
		    return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
		}
		catch (URISyntaxException ex){
			ex.printStackTrace();
			LOGGER.error(ExceptionUtils.getStackTrace(ex));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		catch(RuntimeException ex){
			ex.printStackTrace();
			LOGGER.error(ExceptionUtils.getStackTrace(ex));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
}