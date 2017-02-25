(function(){
	'use strict';
	
	function UserService($resource, $window, NotificationsService){
		var UserService = {};
		
		UserService.resource = $resource('/forum/users/newuser', {'userId' : '@userId'},
		{
			newUser:{
			         url: '/forum/users/newuser',
			         method: 'POST'
			},
			userProfile:{
			         url: '/forum/users/profile/:userId',
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
			}
		});
		UserService.register = function(user){
		         return UserService.resource.newUser(user);                             
		                                      
		};
		UserService.loadProfile = function(userId,vm){
	         var profile = UserService.resource.userProfile({'userId':userId});   
	         profile.$promise.then(function(data){
	        	vm.profile = data;
	        	
	        	UserService.resource.profileNavigation({"usersId":userId}).$promise.then(function(data){
					vm.navTabs = data;
					
					UserService.setTabActive(vm,data[0],data[0].subTabs[0]);
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
		};
		
		UserService.getProfileNavigationTabs = function(vm){
			UserService.resource.profileNavigation().$promise.then(function(data){
				vm.navTabs = data;
			});
		};

		UserService.saveAccountSettings = function(vm){
			UserService.resource.saveAccountSettings(vm.profile);
		};
		
		UserService.saveForumProfile = function(vm){
			UserService.resource.saveForumProfile(vm.profile);
		};
		
		UserService.saveNotificationSettings = function(vm){
			UsersService.resource.saveNotificationSettings(vm.profile);
		};
		
		UserService.isUserAdmin = function(user){
			return user.getPrimaryMemberGroupId === 2;
		};
		
		UserService.isCurrentUser = function(vm,user){
			return vm.profile.usersId === user.getUsersId;
		};
		
		UserService.getAvatarUrl = function(avatar){
			switch(avatar.avatarTypeId){
				case 2:
				case 4:
					return "http://localhost:8080/forum/contentstream/avatar/" + avatar.avatarId;
					break;
					
				case 3:
					return avatar.fileName;
					break;
			}
		};
		
		return UserService;
	}
	
	angular
		.module('zfgc.users')
		.service('UserService', ['$resource','$window','NotificationsService',UserService])
})();