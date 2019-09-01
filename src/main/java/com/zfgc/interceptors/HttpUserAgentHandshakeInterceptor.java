package com.zfgc.interceptors;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import com.google.common.net.HttpHeaders;

public class HttpUserAgentHandshakeInterceptor extends HttpSessionHandshakeInterceptor {
	
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String,Object> attributes) throws Exception{
		String userAgent = request.getHeaders().getFirst(HttpHeaders.USER_AGENT);
		attributes.put(HttpHeaders.USER_AGENT, userAgent);
		
		return super.beforeHandshake(request, response, wsHandler, attributes);
	}
}
