package com.zfgc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.exception.security.ZfgcUnauthorizedException;
import com.zfgc.model.users.AuthCredentials;
import com.zfgc.model.users.MemberListingView;
import com.zfgc.model.users.MembersView;
import com.zfgc.model.users.NewPassword;
import com.zfgc.model.users.PasswordResetCode;
import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.NavTab;
import com.zfgc.model.users.profile.UserProfileView;
import com.zfgc.services.authentication.AuthenticationService;
import com.zfgc.services.authentication.PasswordResetCodeService;
import com.zfgc.services.buddies.BuddyService;
import com.zfgc.services.subscription.SubscriptionService;
import com.zfgc.services.userprofile.UserProfileService;
import com.zfgc.services.users.UsersService;

@RestController
@RequestMapping("/users")
class UsersController extends BaseController{
	
	private Logger logger = LogManager.getLogger(UsersController.class);	
	@Autowired
	UsersService usersService;

	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	BuddyService buddyService;
	
	@Autowired
	private PasswordResetCodeService passwordResetCodeService;

	@RequestMapping(value="/auth/login", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public ResponseEntity login(@RequestBody AuthCredentials credentials) {
		String result = usersService.getLoginToken(credentials);
		return ResponseEntity.status(HttpStatus.OK).body(result);
		
	}
	
	@RequestMapping(value="/loggedInUser", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseEntity getCurrentlyLoggedInUser(){
		Users user = null;
		user = usersService.getLoggedInUser(zfgcUser());
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@RequestMapping(value="/newuser", method=RequestMethod.POST, produces="application/json")	
	@ResponseBody
	public ResponseEntity createNewUser(@RequestBody Users user, HttpServletRequest request){
		user = usersService.createNewUser(user, request);
		
		return ResponseEntity.status(HttpStatus.OK).body(new String[]{"Created user successfully."});
	}
	
	@RequestMapping(value="/newuser/template", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseEntity getNewUserTemplate() {
		return ResponseEntity.status(HttpStatus.OK).body(usersService.getNewUserTemplate());
	}
	
	@RequestMapping(value="/newuser/activation", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public ResponseEntity activateUser(@RequestParam("activationCode") String activationCode) {
		usersService.activateUserAccount(activationCode);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	//admin only endpoint
	@RequestMapping(value="/{usersId}/activation", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	@PreAuthorize("hasAnyRole('ROLE_ZFGC_ACCOUNT_ACTIVATOR')")
	public ResponseEntity activateExistingUser(@PathVariable("usersId") Integer usersId) {
		usersService.activateUserAccount(usersId, zfgcUser());
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@RequestMapping(value="/profile/{userId}", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	@PreAuthorize("hasAnyRole('ROLE_ZFGC_USER')")
	public ResponseEntity getUserProfile(@PathVariable("userId") Integer userId){
		UserProfileView user = userProfileService.getProfile(userId, zfgcUser());
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@RequestMapping(value="/profile/account", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	@PreAuthorize("hasAnyRole('ROLE_ZFGC_USER')")
	public ResponseEntity saveAccountSettings(@RequestBody UserProfileView accountSettings){
		userProfileService.saveAccountSettings(accountSettings,zfgcUser());
		
		return ResponseEntity.status(HttpStatus.OK).body(accountSettings);
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	@PreAuthorize("hasAnyRole('ROLE_ZFGC_USER')")
	public ResponseEntity saveForumProfile(@RequestBody UserProfileView forumProfile){
		userProfileService.saveForumProfile(forumProfile,zfgcUser());
		
		return ResponseEntity.status(HttpStatus.OK).body(forumProfile);
	}
	
	@RequestMapping(value="/profile/notifications", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	@PreAuthorize("hasAnyRole('ROLE_ZFGC_USER')")
	public ResponseEntity saveNotificationSettings(@RequestBody UserProfileView notificationSettings){
		userProfileService.saveNotificationSettings(notificationSettings,zfgcUser());
		
		return ResponseEntity.status(HttpStatus.OK).body(notificationSettings);
	}
	
	@RequestMapping(value="/profile/pmSettings", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	@PreAuthorize("hasAnyRole('ROLE_ZFGC_USER')")
	public ResponseEntity savePmSettings(@RequestBody UserProfileView pmSettings){
		userProfileService.savePmSettings(pmSettings,zfgcUser());
		
		return ResponseEntity.status(HttpStatus.OK).body(pmSettings);
	}
	
	@RequestMapping(value="/profile/buddyList", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	@PreAuthorize("hasAnyRole('ROLE_ZFGC_USER')")
	public ResponseEntity saveBuddyListSettings(@RequestBody UserProfileView buddyList){
		userProfileService.saveBuddyIgnoreList(buddyList,zfgcUser());
		return ResponseEntity.status(HttpStatus.OK).body(buddyList);
	}
	
	@RequestMapping(value="/profile/{userId}/navigation", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	@PreAuthorize("hasAnyRole('ROLE_ZFGC_USER')")
	public ResponseEntity getProfileNavigationTabs(@PathVariable("userId") Integer usersId){
		List<NavTab> navTabs = userProfileService.getProfileNavTabs(zfgcUser(), usersId);
		
		return ResponseEntity.status(HttpStatus.OK).body(navTabs);
	}
	
	@RequestMapping(value="/member-list", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_ZFGC_USER')")
	public ResponseEntity getMemberList(@RequestParam("pageNo") Integer pageNo, @RequestParam("usersPerPage") Integer usersPerPage, @RequestParam("sortBy") String sortBy, @RequestParam("sortOrder") String sortOrder) {
		MembersView userList = null;
		userList = usersService.getMemberListingView(zfgcUser(), pageNo, usersPerPage, sortBy, sortOrder);
		
		return ResponseEntity.ok(userList);
	}
	
	@RequestMapping(value="/buddy", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseEntity getBuddyTemplate(@RequestParam Integer userAId, @RequestParam Integer userBId){
		return ResponseEntity.status(HttpStatus.OK).body(buddyService.getBuddyTemplate(userAId, userBId, zfgcUser()));
	}
	
	@RequestMapping(value="/ignore", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseEntity getIgnoreTemplate(@RequestParam Integer userAId, @RequestParam Integer userBId){
		return ResponseEntity.status(HttpStatus.OK).body(buddyService.getIgnoreTemplate(userAId, userBId, zfgcUser()));
	}
	
	@RequestMapping(value="/requestPasswordReset", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public ResponseEntity requestPasswordReset(@RequestBody String userName){
		passwordResetCodeService.createNewResetCode(userName, zfgcUser());
		
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value="/requestPasswordReset", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseEntity getPasswordReset(@RequestParam String key) {
		NewPassword code = passwordResetCodeService.getNewPasswordModel(key, zfgcUser());
		if(code == null) {
			throw new ZfgcNotFoundException();
		}
		
		return ResponseEntity.ok(code);
	}
	
	@RequestMapping(value="/resetPassword", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public ResponseEntity resetPassword(@RequestBody NewPassword newPassword){
		passwordResetCodeService.resetUserPassword(newPassword, zfgcUser());
		
		return ResponseEntity.ok().build();
	}
}
