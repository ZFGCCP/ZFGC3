(function(){
	
	function PasswordResetRequestCtrl($scope, PasswordResetService){
		var vm = this;
		
		vm.submitRequest = function(){
			PasswordResetService.requestPasswordReset(vm);
		};
	}
	
	angular.module('zfgc.users')
		   .controller('PasswordResetRequestCtrl', ['$scope', 'PasswordResetService', PasswordResetRequestCtrl]);
	
})();