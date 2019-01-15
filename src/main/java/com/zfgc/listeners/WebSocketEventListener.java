package com.zfgc.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.zfgc.model.users.Users;
import com.zfgc.services.users.UsersService;

@Component
public class WebSocketEventListener {
	
	@Autowired
	UsersService usersService;
	
	@EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
		Users user = (Users) ((Authentication) event.getUser()).getPrincipal();
		
		try {
			usersService.setUserOnline(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	@EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		Users user = (Users) ((Authentication) event.getUser()).getPrincipal();
		
		try {
			usersService.setUserOffline(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
