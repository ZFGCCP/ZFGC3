(function(){
	'use strict';
	
	function UserService($rootScope, $resource, $window, $state, $timeout, NotificationsService, vcRecaptchaService){
		var UserService = {};
		
		UserService.resource = $resource('/forum/users/newuser', {'userId' : '@userId', 'activationCode' : '@activationCode'},
		{
			newUser:{
			         url: '/forum/users/newuser',
			         method: 'POST',
			         isArray: true
			},
			newUserTemplate: {
				url : '/forum/users/newuser/template',
				method : 'GET'
			},
			userProfile:{
			         url: '/forum/users/profile/:userId',
			         method: 'GET'
			},
			loggedInUser:{
				url: '/forum/users/loggedInUser',
				method: 'GET'
			},
			profileNavigation:{
				url: '/forum/users/navigation',
				method: 'GET',
				isArray: true
			},
			saveAccountSettings:{
				url: '/forum/users/profile/account',
				method: 'POST'
			},
			saveForumProfile:{
				url: '/forum/users/profile',
				method: 'POST'
			},
			saveNotificationSettings:{
				url:'/forum/users/profile/notifications',
				method:'POST'
			},
			savePmSettings:{
				url:'/forum/users/profile/pmSettings',
				method:'POST'
			},
			saveBuddyList:{
				url:'/forum/users/profile/buddyList',
				method:'POST'
			},
			getUserDisplayName : {
				url : '/forum/users/displayName/:userId',
				method : 'GET'
			},
			getMemberListing : {
				url : '/forum/users/member-list',
				method : 'GET'
			},
			getBuddyTemplate : {
				url : '/forum/users/buddy',
				method : 'GET'
			},
			adminUserActivate : {
				url : '/forum/users/:userId/activation',
				method : 'POST'
			},
			activate : {
				url : '/forum/users/newuser/activation?activationCode=:activationCode',
				method : 'POST'
			}
		});
		
		UserService.adminUserActivate = function(userId){
			UserService.resource.adminUserActivate({userId : userId}).$promise.then(function(data){
				$state.reload();
			});
		}
		
		UserService.getNewUserTemplate = function(){
			return UserService.resource.newUserTemplate();
		};
		
		//returns true if all required registration fields are complete
		UserService.registrationFieldsComplete = function(vm, user){
			return vm.user.loginName !== null && vm.user.loginName !== "" && 
				   vm.user.displayName !== null && vm.user.displayName !== "" &&
				   vm.user.userSecurityInfo.newPassword !== null && vm.user.userSecurityInfo.newPassword !== "" &&
				   vm.user.userContactInfo.email.emailAddress !== null && vm.user.userContactInfo.email.emailAddress !== "" &&
				   vm.user.personalInfo.birthDateAsString !== null && vm.user.personalInfo.birthDateAsString !== "" &&
				   vm.user.timeOffset !== null &&
				   vm.user.agreeToTermsFlag !== false &&
				   vcRecaptchaService.getResponse() !== "";
		};
		
		UserService.register = function(user){
			if(vcRecaptchaService.getResponse() === ""){ //if string is empty
                return null;
            }else {
            	user.gResponseToken = vcRecaptchaService.getResponse();
            	return UserService.resource.newUser(user);
            }
		                                      
		};
		UserService.loadProfile = function(userId,vm){
	         var profile = UserService.resource.userProfile({'userId':userId});   
	         profile.$promise.then(function(data){
	        	vm.profile = data;
	        	
	        	UserService.resource.profileNavigation({"usersId":userId}).$promise.then(function(data){
					vm.navTabs = data;
					var activeTab = UserService.activeTab && UserService.activeTab !== null ? UserService.activeTab : data[0];
					var activeSubTab = UserService.activeSubTab && UserService.activeSubTab !== null ? UserService.activeSubTab : data[0].subTabs[0];
					
					UserService.setTabActive(vm,activeTab,activeSubTab);
					
					UserService.activeTab = null;
					UserService.activeSubTab = null;
				});
	        	
	        	NotificationsService.getThreadSubs(userId,1,10).$promise.then(function(data){
	        		vm.threadSubs = data;
	        	});
	         });
	         	                                      
		};
		UserService.setTabActive = function(vm,tab, subTab){
			if(vm.navTabs && vm.navTabs !== null && Array.isArray(vm.navTabs) && tab && tab !== null){
				for(var i = 0; i < vm.navTabs.length; i++){
					vm.navTabs[i].active = false;
				}
			}
			
			tab.active = true;
			vm.activeTabSectionId = subTab.navSectionId;
			vm.activeTabNameId = subTab.title;
			vm.activeParentName = tab.title;
			vm.activeTab = tab;
			vm.activeSubTab = subTab;
		};
		
		UserService.getProfileNavigationTabs = function(vm){
			UserService.resource.profileNavigation().$promise.then(function(data){
				vm.navTabs = data;
			});
		};

		UserService.postProfileSaveActions = function(vm){
			UserService.activeTab = vm.activeTab;
			UserService.activeSubTab = vm.activeSubTab;
			
			$timeout(function(){
				$state.reload();
			},1000);
		};
		
		UserService.saveAccountSettings = function(vm){
			UserService.resource.saveAccountSettings(vm.profile).$promise.then(function(data){
				$rootScope.$broadcast('alertAdded',NotificationsService.createAlert('Account Settings successfully saved.','success'));
				UserService.postProfileSaveActions(vm);
			});
		};
		
		UserService.saveForumProfile = function(vm){
			UserService.resource.saveForumProfile(vm.profile).$promise.then(function(data){
				$rootScope.$broadcast('alertAdded',NotificationsService.createAlert('Forum Profile successfully saved.','success'));
				UserService.postProfileSaveActions(vm);
			});
		};
		
		UserService.saveNotificationSettings = function(vm){
			UserService.resource.saveNotificationSettings(vm.profile);
			$rootScope.$broadcast('alertAdded',NotificationsService.createAlert('Notification Settings successfully saved.','success'));
			UserService.postProfileSaveActions(vm);
		};
		
		UserService.savePmSettings = function(vm){
			UserService.resource.savePmSettings(vm.profile);
			$rootScope.$broadcast('alertAdded',NotificationsService.createAlert('PM Settings successfully saved.','success'));
			UserService.postProfileSaveActions(vm);
		};
		
		UserService.saveBuddyList = function(vm){
			UserService.resource.saveBuddyList(vm.profile);
			$rootScope.$broadcast('alertAdded',NotificationsService.createAlert('Buddy/Ignore List successfully saved.','success'));
			UserService.postProfileSaveActions(vm);
		};
		
		UserService.isUserAdmin = function(user){
			return user.administrationStaff === true;
		};
		
		UserService.isUserModerator = function(user){
			return user.moderationStaff === true;
		};
		
		UserService.isCurrentUser = function(vm,user){
			return vm.profile.usersId === user.getUsersId;
		};
		
		UserService.getAvatarUrl = function(avatar){
			if(avatar && avatar !== null && avatar.avatarTypeId && avatar.avatarTypeId !== null){
			
				switch(avatar.avatarTypeId){
					case 1:
					case 2:
					case 4:
						return "http://localhost:8080/forum/contentstream/avatar/" + avatar.avatarId;
						break;
						
					case 3:
						return avatar.avatarUrl;
						break;
				}
			}
			
			return null;
		};
		
		UserService.getMemberListing = function(vm, pageNumber, range){
			vm.memberList = UserService.resource.getMemberListing({'pageNo' : pageNumber, 'usersPerPage' : range});
		};
		
		UserService.canEditRestrictedProfileField = function(userProfileId){
			if(UserService.loggedInUser && UserService.loggedInUser.usersId !== null && UserService.loggedInUser.usersId === userProfileId){
				return true;
			}
			
			return false;
		};
		
		UserService.deleteBuddy = function(vm, index){
			vm.profile.buddyList.splice(index,1);
		};
		
		UserService.addBuddy = function(vm,buddy){
			var newBuddy = UserService.resource.getBuddyTemplate({userAId : vm.profile.usersId, userBId : buddy.usersId});
			
			newBuddy.$promise.then(function(data){
				vm.profile.buddyList.push(data);
			});
		};
		
		UserService.isUserOnBuddyList = function(vm){
			if(vm.profile && vm.profile !== null){
				for(var i = 0; i < vm.profile.buddyList.length; i++){
					if(vm.profile.buddyList[i].userBId === vm.profile.usersId){
						return true;
					}
				}
			}
			
			return false;
		}
		
		UserService.canSendPmToUser = function(vm){
			if(vm.profile && vm.profile !== null && UserService.loggedInUser && UserService.loggedInUser !== null){
				var pmSettings = vm.profile.personalMessagingSettings.receiveFromId;
				var loggedInUser = UserService.loggedInUser;
				
				if(loggedInUser.usersId !== vm.profile.usersId && loggedInUser.member){
					switch(pmSettings){
						case 2:
							//todo: implement ignore list
							return true;
							break;
							
						case 3:
							return loggedInUser.staffMember || UserService.isUserOnBuddyList(vm);
							break;
							
						case 4:
							return loggedInUser.staffMember;
							break;
							
						default:
							return true;
						break;
					}
					
				}
			}
			return false;
		}
		
		return UserService;
	}
	
	angular
		.module('zfgc.users')
		.service('UserService', ['$rootScope','$resource','$window','$state','$timeout','NotificationsService','vcRecaptchaService',UserService])
})();