(function(){
	
	function PasswordResetService($resource) {
		var service = {};
		
		service.resource = $resource('/forum/users/requestPasswordReset', {resetKey : '@resetKey'},
			{
				resetPassword : {
					url : '/forum/users/resetPassword',
					method : 'POST'
				}
			});
		
		service.requestPasswordReset = function(vm){
			vm.savedUserName = vm.userName;
			service.resource.save(vm.userName).$promise.then(function(data){
				vm.responseReceived = true;
				 
			});
		};
		
		service.getPasswordReset = function(vm, key){
			service.resource.get({key : key}).$promise.then(function(data){
				vm.key = data;
			})
			.catch(function(error){
				vm.errorReceived = true;
			});
		};
		
		service.resetPassword = function(vm){
			service.resource.resetPassword(vm.key).$promise.then(function(data){
				vm.responseReceived = true;
			});
		}
		
		return service;
	}
	
	angular.module('zfgc.users')
		   .service('PasswordResetService', ['$resource', PasswordResetService]);
	
})();