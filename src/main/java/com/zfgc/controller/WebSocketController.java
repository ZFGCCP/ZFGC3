package com.zfgc.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.websocket.server.HandshakeRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zfgc.model.online.WhosOnlineList;
import com.zfgc.model.users.UserAction;
import com.zfgc.model.users.Users;
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
	public ResponseEntity createUserSession(Principal auth, SimpMessageHeaderAccessor headerAccessor) {
		String sessionId = headerAccessor.getSessionId();
		WhosOnlineList online = whosOnlineService.getWhosOnlineDetailed();
		
		return ResponseEntity.ok(online);
	}
	
	@MessageMapping("/usersocket/updateUserAction")
	public ResponseEntity updateUserAction(Principal auth, SimpMessageHeaderAccessor headerAccessor, UserAction action) {
		Users user = zfgcUser(auth);
		String sessionId = headerAccessor.getSessionId();
		usersService.updateUserActions(sessionId, action.getCurrentActionId(), user);
		return ResponseEntity.ok().build();
	}
	
}