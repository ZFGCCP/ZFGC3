package com.zfgc.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import com.zfgc.model.users.Users;

public abstract class BaseController {
	@Autowired
	HttpServletRequest request;
	
	protected Users zfgcUser(){
		return (Users) ((Authentication) request.getUserPrincipal()).getPrincipal();
	}
	
	protected Users zfgcUser(Principal principal){
		return (Users) ((Authentication) principal).getPrincipal();
	}
}
