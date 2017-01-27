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
			}
		});
		UserService.register = function(user){
		         return UserService.resource.newUser(user);                             
		                                      
		};
		UserService.loadProfile = function(userId,vm){
	         var profile = UserService.resource.userProfile({'userId':userId});   
	         profile.$promise.then(function(data){
	        	vm.profile = data.profileSummary; 
	         });
	         	                                      
		};
		UserService.setTabActive = function(vm,tab){
			if(vm.navTabs && vm.navTabs !== null && Array.isArray(vm.navTabs) && tab && tab !== null){
				for(var i = 0; i < vm.navTabs.length; i++){
					vm.navTabs[i].active = false;
				}
			}
			
			tab.active = true;
		};
		UserService.getProfileNavigationTabs = function(vm){
			//todo: write a back end service for this
			vm.navTabs = [
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
			];
		};
		return UserService;
	}
	
	angular
		.module('zfgc.users')
		.service('UserService', ['$resource',UserService])
})();