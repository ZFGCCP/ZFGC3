package com.zfgc.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zfgc.model.online.WhosOnlineList;
import com.zfgc.services.users.UsersService;
import com.zfgc.services.whosOnline.WhosOnlineService;

@Controller
public class WebSocketController extends BaseController{
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	WhosOnlineService whosOnlineService;
	
	@RequestMapping (method= RequestMethod.POST, value = "/userSocketS/init")
	@MessageMapping("/usersocket/init")
	@SendTo("/socket/whosonline")
	public ResponseEntity createUserSession(Principal auth) {
		try {
			usersService.setUserOnline(zfgcUser(auth));
			WhosOnlineList online = whosOnlineService.getWhosOnline();
			
			return ResponseEntity.ok(online);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There was an error with the user handshake.");
		}
	}
	
}