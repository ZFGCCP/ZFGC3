package com.zfgc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zfgc.model.users.Users;
import com.zfgc.services.users.UsersService;

@RestController
@RequestMapping("/users")
class UsersController{
	
	@Autowired
	UsersService usersService;
	
	@RequestMapping(value="/new-user", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public ResponseEntity createNewUser(@RequestBody Users user, HttpServletRequest request){
		
		user = usersService.createNewUser(user, request);
		
		if(user == null){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error has occurred. Please contact a system administrator.");
		}
		else if(user.getErrors().hasErrors()){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(user.getErrors());
		}
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
}