package com.zfgc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.NavTab;
import com.zfgc.model.users.profile.UserProfileView;
import com.zfgc.services.authentication.AuthenticationService;
import com.zfgc.services.subscription.SubscriptionService;
import com.zfgc.services.userprofile.UserProfileService;
import com.zfgc.services.users.UsersService;

@RestController
@RequestMapping("/users")
class UsersController extends BaseController{
	
	@Autowired
	UsersService usersService;

	@Autowired
	UserProfileService userProfileService;

	@RequestMapping(value="/loggedInUser", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseEntity getCurrentlyLoggedInUser(){
		Users user = usersService.getLoggedInUser(zfgcUser());
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@RequestMapping(value="/newuser", method=RequestMethod.POST, produces="application/json")	
	@ResponseBody
	public ResponseEntity createNewUser(@RequestBody Users user, HttpServletRequest request){
		
		user = usersService.createNewUser(user, request);
		
		if(user == null){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new String[]{"An unexpected error has occurred. Please contact a system administrator."});
		}
		else if(user.getErrors().hasErrors()){
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(user.getErrors());
		}
		return ResponseEntity.status(HttpStatus.OK).body(new String[]{"Created user successfully."});
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public ResponseEntity authenticateUser(@RequestBody Users user, HttpServletRequest request){
		try {
			user = usersService.authenticateUser(user, request.getRemoteAddr());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new String[]{"An unexpected error has occurred. Please contact a system administrator."});
		}
		
		if(user.getErrors().hasErrors()){
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(user.getErrors());
		}

		return ResponseEntity.status(HttpStatus.OK).body(new String[]{user.getAuthToken()});
	}
	
	@RequestMapping(value="/tokenauth", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public ResponseEntity authenticateUser(HttpServletRequest request){
		try{
			Users user = usersService.authenticateUserByToken(request.getHeader("authorization"));
			if(user == null){
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error has occurred. Please contact a system administrator.");
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}
		catch(ZfgcNotFoundException ex){
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You are not authorized to access this resource.");
		}
		catch(Exception ex){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error has occurred. Please contact a system administrator.");
		}
	}
	
	@RequestMapping(value="/profile/{userId}", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseEntity getUserProfile(@PathVariable("userId") Integer userId){
		try {
			Users user = userProfileService.getProfile(userId, zfgcUser());
			
			return ResponseEntity.status(HttpStatus.OK).body(user);
		} 
		catch(ZfgcNotFoundException ex){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The requested resource could not be found.");
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error has occurred. Please contact a system administrator.");
		}
	}
	
	@RequestMapping(value="/profile/account", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public ResponseEntity saveAccountSettings(@RequestBody Users accountSettings){
		try {
			userProfileService.saveAccountSettings(accountSettings,zfgcUser());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(accountSettings);
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public ResponseEntity saveForumProfile(@RequestBody Users forumProfile){
		try {
			userProfileService.saveForumProfile(forumProfile,zfgcUser());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(forumProfile);
	}
	
	@RequestMapping(value="/profile/notifications", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public ResponseEntity saveNotificationSettings(@RequestBody Users notificationSettings){
		try {
			userProfileService.saveNotificationSettings(notificationSettings,zfgcUser());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(notificationSettings);
	}
	
	@RequestMapping(value="/profile/pmSettings", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public ResponseEntity savePmSettings(@RequestBody Users pmSettings){
		try {
			userProfileService.savePmSettings(pmSettings,zfgcUser());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(pmSettings);
	}
	
	@RequestMapping(value="/profile/buddyList", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public ResponseEntity saveBuddyListSettings(@RequestBody Users buddyList){
		try {
			userProfileService.saveBuddyIgnoreList(buddyList,zfgcUser());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(buddyList);
	}
	
	@RequestMapping(value="/navigation", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseEntity getProfileNavigationTabs(@RequestParam Integer usersId){
		List<NavTab> navTabs = userProfileService.getProfileNavTabs(zfgcUser(), usersId);
		
		if(navTabs == null){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error has occurred. Please contact a system administrator.");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(navTabs);
	}
}
