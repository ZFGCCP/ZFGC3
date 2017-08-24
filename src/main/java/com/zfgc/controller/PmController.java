package com.zfgc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zfgc.model.pm.PersonalMessage;
import com.zfgc.model.pm.PmGenerator;
import com.zfgc.services.pm.PmService;

@Component
@RequestMapping("/pm")
public class PmController extends BaseController {

	@Autowired
	PmService pmService;
	
	@RequestMapping(value="/send", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity sendPm(@RequestBody PersonalMessage message){
		PersonalMessage savedMessage = pmService.sendMessage(message.getSenderId(), message.getReceiverId(), message);
		
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value="/key", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity createKeyPair(@RequestBody PmGenerator pmGenerator){
		pmService.createKeyPairs(pmGenerator.getUsersId(), pmGenerator.getPassPhrase());
		
		return ResponseEntity.ok().build();
	}
	
}
