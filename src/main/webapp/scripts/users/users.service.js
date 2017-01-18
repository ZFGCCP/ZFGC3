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
		return UserService;
	}
	
	angular
		.module('zfgc.users')
		.service('UserService', ['$resource',UserService])
})();