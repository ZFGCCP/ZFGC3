(function(){
	'use strict';
	
	function UserService($resource){
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
			}
		});
		UserService.register = function(user){
		         return UserService.resource.newUser(user);                             
		                                      
		};
		UserService.loadProfile = function(userId,vm){
	         var profile = UserService.resource.userProfile({'userId':userId});   
	         profile.$promise.then(function(data){
	        	vm.profile = data.profileSummary; 
	        	
	        	UserService.resource.profileNavigation({"usersId":userId}).$promise.then(function(data){
					vm.navTabs = data;
					
					UserService.setTabActive(vm,data[0],data[0].subTabs[0]);
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
			//todo: write a back end service for this
			UserService.resource.profileNavigation().$promise.then(function(data){
				vm.navTabs = data;
			});
			/*vm.navTabs = [
			   {
				   "title":"Profile Info",
				   "active":true,
				   "subTabs":[
				              {
				            	  "title":"Summary"
				              }
				   ]
			   },
			   {
				   "title":"Modify Profile",
				   "active":false,
				   "subTabs":[
								{
									  "title":"Account Settings"
								}
				   ]
			   },
			   {
				   "title":"Messaging",
				   "active":false,
				   "subTabs":[
				   
				   ]
			   },
			   {
				   "title":"Track User",
				   "active":false,
				   "subTabs":[
				   
				   ]
			   }
			];*/
		};
		return UserService;
	}
	
	angular
		.module('zfgc.users')
		.service('UserService', ['$resource',UserService])
})();