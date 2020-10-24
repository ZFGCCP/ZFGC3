package com.zfgc.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;

import com.zfgc.config.ZfgcSamlConfig;
import com.zfgc.model.lkup.LkupMemberGroup;
import com.zfgc.model.users.Permissions;
import com.zfgc.model.users.Users;
import com.zfgc.services.users.PermissionsService;
import com.zfgc.services.users.UsersService;

public abstract class BaseController {
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private PermissionsService permissionsService;
	
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
