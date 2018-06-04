(function(){
	
	function PmTwoFactorCtrl($rootScope,$state,PmService){
		var vm = this;
		
		vm.authKey = "";
		
		vm.authorize = function(){
			PmService.setAuthorization(vm.authKey);
			
			$state.go($rootScope.previousState, $rootScope.previousStateParams);
		};
	}
	
	angular.module('zfgc.pm')
		   .controller('PmTwoFactorCtrl',['$rootScope','$state','PmService',PmTwoFactorCtrl]);
	
})();