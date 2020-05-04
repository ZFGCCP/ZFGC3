(function(){
	'use strict';
	
	function zfgcHeader($rootScope, UserService, $q, $window, $location, $resource, $state, $timeout, ServerConfigService, WebsocketService, WhosOnlineService, NotificationsService) {
    	return {
    		restrict: 'E',
    		transclude: true,
    		templateUrl: 'scripts/common/header/zfgc-header.html',
    		scope: {
    			//
    		},
    		link: function(scope, element, attrs) {
    			scope.socket = {
    					client: null,
    					stomp: null
    			};

    			scope.logOutLocal = function(){
    				var result = $resource("/forum/saml/logout?local=true",{}).get();
    				result.$promise.then(function(data){
    					$state.go('forum');
    					$timeout(function(){
    						$window.location.reload();
    					},0);
    					
    				});
    				
    			};
    			
    			scope.goToIdp = function(){
    				var returnTo = $location.absUrl();
    				$window.location = "http://devidp.zfgc.com/saml2/idp/SSOService.php?spentityid=" + ServerConfigService.config.idpEntityId + "&target=" + returnTo;
    			};
    			
    			scope.startListener = function() {
    				$rootScope.$broadcast("WebsocketConnected");
			    };
    			
			    WebsocketService.openWebsocket("/forum/ws", scope.startListener);
    			
			    $rootScope.$on("WebsocketConnected", function(data){
					WebsocketService.subscribe("/user/socket/pmNotif", scope.pmNotifReceived);
					$state.reload();
				});
			    
			    scope.pmNotifReceived = function(data){
			    	console.log("pmNotif received");
			    	scope.user.unreadPmCount = data.body * 1;
			    	NotificationsService.addInfoAlert("Received a new personal message");
			    	
			    	scope.$apply();
			    };
			    
    			scope.user = UserService.resource.loggedInUser();
    			UserService.loggedInUser = scope.user;
    			
    			scope.onExit = function() {
    			     scope.socket.stomp.close();
    			};
    			$window.onbeforeunload =  scope.onExit;
    		}
    	}
    }
	
	angular
	    .module("zfgc.forum")
	    .directive("zfgcHeader", ['$rootScope','UserService', '$q', '$window', '$location', '$resource', '$state', '$timeout', 'ServerConfigService', 'WebsocketService', 'WhosOnlineService', 'NotificationsService', zfgcHeader]);
})();