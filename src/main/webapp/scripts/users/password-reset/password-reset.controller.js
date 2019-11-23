(function(){
	
	function PasswordResetCtrl($scope, $location, PasswordResetService){
		var vm = this;
		
		vm.responseReceived = false;
		
		vm.submitRequest = function(){
			PasswordResetService.resetPassword(vm);
		};
		
		vm.getKey = function(){
			PasswordResetService.getPasswordReset(vm, $location.search().resetCode);
		};
		
		vm.key = vm.getKey();
	}
	
	angular.module('zfgc.users')
		   .controller('PasswordResetCtrl', ['$scope', '$location', 'PasswordResetService', PasswordResetCtrl]);
	
})();