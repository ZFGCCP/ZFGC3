package com.zfgc.controller;

import java.security.Principal;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;

import com.zfgc.config.ZfgcSamlConfig;
import com.zfgc.model.users.Permissions;
import com.zfgc.model.users.Users;

public abstract class BaseController {
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	ZfgcSamlConfig zfgcSamlConfig;
	
	protected Users zfgcUser(){
		Principal userPrincipal = request.getUserPrincipal();
		return zfgcUser(userPrincipal);
	}
	
	protected Users zfgcUser(Principal principal){
		if(principal == null){
			Users guest = new Users();
			guest.setUsersId(null);
			guest.setDisplayName("Guest");
			guest.setPrimaryMemberGroupId(0);
			
			guest.setPermissions(new ArrayList<>());
			Permissions perm = new Permissions();
			perm.setPermissionsId(15);
			guest.getPermissions().add(perm);
			
			return guest;
		}
		
		return (Users) ((Authentication) principal).getPrincipal();
	}
}
