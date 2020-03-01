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
			
			$scope.updateRecentMember = function(data){
				$scope.mostRecent = JSON.parse(data.body);
				$scope.$apply();
			};
			
			$rootScope.$on("WebsocketConnected", function(data){
				WebsocketService.subscribe("/socket/whosonline", $scope.updateWhosOnline);
				WebsocketService.subscribe("/socket/members/recentMember", $scope.updateRecentMember);
				WebsocketService.send("/usersocket/init",{},{});
			});
			
			$scope.toggleDetails = function(){
				$scope.showDetails = !$scope.showDetails;
				
				$rootScope.$broadcast("WhosOnlineDetailsToggled", $scope.showDetails);
			};
			
			$scope.createBrowserType = function(browserType, iconHtml, type){
				$scope.browserTypes[browserType] = {iconHtml : iconHtml, type : type};
			};
			
			$scope.osTypes = [];
			$scope.browserTypes = [];
			
			$scope.osTypes['Windows'] = '<i class="fab fa-windows"></i>';
			$scope.osTypes['Linux'] = '<i class="fab fa-redhat"></i>';
			$scope.osTypes['Mac'] = '<i class="fab fa-apple"></i>';
			$scope.osTypes['Mac Os X'] = '<i class="fab fa-apple"></i>';
			$scope.osTypes['Ios'] = '<i class="fab fa-apple"></i>';
			$scope.osTypes['ChromeOS'] = '<i class="fab fa-google"></i>';
			$scope.osTypes['Android'] = '<i class="fab fa-android"></i>';
			
			$scope.createBrowserType('Chrome', '<i class="fab fa-chrome"></i>', 'Web Browser');
			$scope.createBrowserType('Chromium', '<i class="fab fa-chrome"></i>', 'Web Browser');
			$scope.createBrowserType('Firefox', '<i class="fab fa-firefox"></i>', 'Web Browser');
			$scope.createBrowserType('Safari', '<i class="fab fa-safari"></i>', 'Web Browser');
			$scope.createBrowserType('Internet Explorer', '<i class="fab fa-internet-explorer"></i>', 'Web Browser');
			$scope.createBrowserType('Opera', '<i class="fab fa-opera"></i>', 'Web Browser');
			$scope.createBrowserType('Outlook', '<i class="fas fa-at"></i>', 'Web Browser');
			$scope.createBrowserType('Thunderbird', '<i class="fab fa-firefox"></i>', 'Web Browser');
			$scope.createBrowserType('Vivaldi', '<i class="fas fa-globe"></i>', 'Web Browser');
			$scope.createBrowserType('Nintendo Browser', '<i class="fas fa-gamepad"></i>', 'Game Device');
			$scope.createBrowserType('Nintendo Dsi Browser', '<i class="fas fa-gamepad"></i>', 'Game Device');
			$scope.createBrowserType('Samsung Browser', '<i class="fab fa-android"></i>', 'Mobile');
			$scope.createBrowserType('Uc Browser', '<i class="fas fa-globe"></i>', 'Mobile');
			
			
			
		}
		
		return directive;
	}
	
	angular.module('zfgc.forum')
		   .directive('whosOnline',['$rootScope','WhosOnlineService','WebsocketService',whosOnline]);
	
})();