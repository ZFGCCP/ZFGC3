(function(){
	
	function ActivationCtrl($scope, $location, UserService){
		var vm = this;
		
		$scope.ACTIVATION_PENDING = 0;
		$scope.ACTIVATION_APPROVED = 1;
		$scope.ACTIVATION_DENIED = 2;
		
		vm.status = $scope.ACTIVATION_PENDING;
		
		vm.attemptActivation = function(){
			if(!$location.search().activationCode || $location.search().activationCode === null || $location.search().activationCode === ''){
				vm.status = $scope.ACTIVATION_DENIED;
				return;
			}
			
			UserService.resource.activate({activationCode : $location.search().activationCode}).$promise.then(function(data){
				vm.status = $scope.ACTIVATION_APPROVED;
			});
		};
		
		vm.attemptActivation();
	}
	
	angular.module('zfgc.users')
		   .controller('ActivationCtrl',['$scope','$location','UserService',ActivationCtrl]);
	
})();