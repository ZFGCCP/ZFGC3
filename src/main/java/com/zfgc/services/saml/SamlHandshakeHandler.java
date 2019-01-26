package com.zfgc.services.saml;

import java.security.Principal;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;
import org.springframework.security.core.Authentication;

import com.zfgc.model.users.Users;

@Component
public class SamlHandshakeHandler extends DefaultHandshakeHandler{
	@Override 
	protected java.security.Principal determineUser(ServerHttpRequest request,
            WebSocketHandler wsHandler,
            java.util.Map<java.lang.String,java.lang.Object> attributes){
		if(request.getPrincipal() == null){
			Users user = new Users();
			user.setUsersId(-1);
			user.setDisplayName("Guest");
			
			
		}
		
		return request.getPrincipal();
	}
}