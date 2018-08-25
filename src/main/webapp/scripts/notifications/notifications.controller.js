(function(){
	
	function NotificationsCtrl($rootScope, $scope,NotificationsService){
		var vm = this;
		
		vm.alerts = [];
		
		vm.closeAlert = function(index){
			vm.alerts.splice(index,1);
		};
		
		$rootScope.$on('alertAdded',function(event,alert){
			vm.alerts.push(alert);
		});
	}
	
	angular.module('zfgc.notifications')
		   .controller('NotificationsCtrl',['$rootScope','$scope','NotificationsService',NotificationsCtrl]);
	
})();