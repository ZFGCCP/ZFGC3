package com.zfgc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.subscriptions.ThreadSubscription;
import com.zfgc.model.subscriptions.ThreadSubscriptionWrapper;
import com.zfgc.services.subscription.SubscriptionService;

@Controller
@RequestMapping("/subscriptions")
public class SubscriptionController extends BaseController{
	
	@Autowired
	SubscriptionService subscriptionService;
	
	@RequestMapping(value="/threads/{userId}", method=RequestMethod.GET)
	@PreAuthorize("hasRole('ZFGC_USER')")
	public ResponseEntity getUserSubscriptions(@PathVariable("userId") Integer userId, 
									           @RequestParam("itemsPerPage") Integer itemsPerPage, 
									           @RequestParam("pageNo") Integer pageNo){
		ThreadSubscriptionWrapper subs = null;
		subs = subscriptionService.getThreadSubscriptions(userId, pageNo, itemsPerPage, zfgcUser());
		
		return ResponseEntity.status(HttpStatus.OK).body(subs);
	}
	
}