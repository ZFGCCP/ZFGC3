(function(){
	
	function PasswordResetRequestCtrl($scope, PasswordResetService){
		var vm = this;
		
		vm.responseReceived = false;
		
		vm.submitRequest = function(){
			PasswordResetService.requestPasswordReset(vm);
		};
	}
	
	angular.module('zfgc.users')
		   .controller('PasswordResetRequestCtrl', ['$scope', 'PasswordResetService', PasswordResetRequestCtrl]);
	
})();