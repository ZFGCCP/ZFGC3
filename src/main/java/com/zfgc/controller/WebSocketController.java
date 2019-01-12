package com.zfgc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WebSocketController extends BaseController{
	
	@MessageMapping("UserSocketS/Init")
	@SendTo("/UserSocketC/Active")
	public ResponseEntity createUserSession() {
		return ResponseEntity.ok().body("Ok");
	}
	
}