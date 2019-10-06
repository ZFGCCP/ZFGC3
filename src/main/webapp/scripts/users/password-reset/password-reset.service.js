(function(){
	
	function PasswordResetService($resource) {
		var service = {};
		
		service.resource = $resource('/forum/users/requestPasswordReset', {});
		
		service.requestPasswordReset = function(vm){
			service.resource.save(vm.userName).$promise.then(function(data){
				
			});
		};
		
		return service;
	}
	
	angular.module('zfgc.users')
		   .service('PasswordResetService', ['$resource', PasswordResetService]);
	
})();