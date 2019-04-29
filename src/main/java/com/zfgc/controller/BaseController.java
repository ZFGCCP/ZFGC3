package com.zfgc.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;

import com.zfgc.model.users.Users;

public abstract class BaseController {
	@Autowired
	HttpServletRequest request;
	
	protected Users zfgcUser(){
		Principal userPrincipal = request.getUserPrincipal();
		return zfgcUser(userPrincipal);
	}
	
	protected Users zfgcUser(Principal principal){
		if(principal == null){
			Users guest = new Users();
			guest.setUsersId(-1);
			guest.setDisplayName("Guest");
			
			return guest;
		}
		
		return (Users) ((Authentication) principal).getPrincipal();
	}
}
