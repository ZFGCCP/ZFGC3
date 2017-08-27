package com.zfgc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.pm.PersonalMessage;
import com.zfgc.model.pm.PmGenerator;
import com.zfgc.model.pm.TwoFactorKey;
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
	
	@RequestMapping(value="/read/{pmId}", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity readPm(@RequestBody TwoFactorKey aes, @PathVariable("pmId") Integer pmId){
		try {
			PersonalMessage message = pmService.openMessage(pmId, aes.getUsersId(), aes);
			
			return ResponseEntity.ok(message);
		} catch (ZfgcNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
