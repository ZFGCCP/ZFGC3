(function(){
	'use strict';
	
	function UserService($resource){
		var UserService = {};
		
		UserService.resource = $resource('/forum/users/newuser', {},
		{
			newUser:{
			         url: '/forum/users/newuser',
			         method: 'POST'
			}
		});
		UserService.register = function(user){
		         return UserService.resource.newUser(user);                             
		                                      
		};
		return UserService;
	}
	
	angular
		.module('zfgc.users')
		.service('UserService', ['$resource',UserService])
})();