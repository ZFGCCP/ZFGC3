package com.zfgc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.exception.security.ZfgcInvalidAesKeyException;
import com.zfgc.model.pm.PersonalMessage;
import com.zfgc.model.pm.PmBox;
import com.zfgc.model.pm.PmConversation;
import com.zfgc.model.pm.PmConversationView;
import com.zfgc.model.pm.PmConvoBox;
import com.zfgc.model.pm.PmGenerator;
import com.zfgc.model.pm.TwoFactorKey;
import com.zfgc.services.authentication.AuthenticationService;
import com.zfgc.services.pm.PmService;

@Component
@RequestMapping("/pm")
public class PmController extends BaseController {

	@Autowired
	PmService pmService;
	
	@Autowired
	AuthenticationService authenticationService;
	
	
	@RequestMapping(value="/template", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseEntity getPmTemplate(){
		return ResponseEntity.status(HttpStatus.OK).body(pmService.getPmTemplate());
	}
	
	@RequestMapping(value="/send", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity sendPm(@RequestBody PersonalMessage message){
		
		try{
			pmService.sendMessageInConversation(zfgcUser(), message.getReceivers(), message);
		}
		catch(ZfgcNotFoundException ex){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
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
		catch (ZfgcInvalidAesKeyException e){
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@RequestMapping(value="/auth", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity authenticatePmKey(@RequestBody TwoFactorKey aes){
		if (aes.getKey() == null){
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		
		try {
			Boolean result = authenticationService.isValidAesKey(aes);
			
			if(result == false){
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		} catch (ZfgcInvalidAesKeyException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@RequestMapping(value="/outbox", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity viewOutbox(@RequestBody TwoFactorKey aesKey){
		try {
			PmBox outbox = pmService.getOutbox(aesKey, zfgcUser());
			
			if(outbox == null){
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
			return ResponseEntity.ok(outbox);
		} catch (ZfgcInvalidAesKeyException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@RequestMapping(value="/inbox", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity viewInbox(@RequestBody TwoFactorKey aesKey){
		try {
			PmBox inbox = pmService.getInbox(aesKey, zfgcUser());
			
			if(inbox == null){
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
			return ResponseEntity.ok(inbox);
		} catch (ZfgcInvalidAesKeyException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@RequestMapping(value="/convobox", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity viewConvoBox(@RequestBody TwoFactorKey aesKey){
		try{
			PmConvoBox convos = pmService.getConversationBox(aesKey, zfgcUser());
			
			if(convos == null){
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
			return ResponseEntity.ok(convos);
		}
	    catch (ZfgcInvalidAesKeyException e) {
	    	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	    }
	}
	
	@RequestMapping(value="/conversation/{conversationId}", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity viewConversation(@RequestBody TwoFactorKey aesKey,@PathVariable("conversationId") Integer convoId) {
		try {
			PmConversation convo = pmService.getConversation(convoId, aesKey, zfgcUser());
			
			if(convo == null) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
			return ResponseEntity.ok(convo);
		}
		catch (ZfgcInvalidAesKeyException e) {
	    	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	    }
	}
}
