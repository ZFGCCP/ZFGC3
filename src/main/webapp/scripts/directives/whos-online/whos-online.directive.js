(function(){
	
	function whosOnline($rootScope, WhosOnlineService, WebsocketService){
		var directive = {};
		directive.restrict = 'E';
		directive.templateUrl = 'scripts/directives/whos-online/whos-online.directive.html';
		directive.scope = {
				
		};
		
		directive.link = function($scope,element,attrs){
			$scope.users = null;
			$scope.showDetails = false;
			
			$scope.updateWhosOnline = function(data){
				$scope.users = WhosOnlineService.updateWhosOnline(data);
				$scope.$apply();
			};
			
			$rootScope.$on("WebsocketConnected", function(data){
				WebsocketService.subscribe("/socket/whosonline", $scope.updateWhosOnline);
				WebsocketService.send("/forum/usersocket/init",{},{});
			});
			
			$scope.toggleDetails = function(){
				$scope.showDetails = !$scope.showDetails;
				
				$rootScope.$broadcast("WhosOnlineDetailsToggled", $scope.showDetails);
			};
		}
		
		return directive;
	}
	
	angular.module('zfgc.forum')
		   .directive('whosOnline',['$rootScope','WhosOnlineService','WebsocketService',whosOnline]);
	
})();