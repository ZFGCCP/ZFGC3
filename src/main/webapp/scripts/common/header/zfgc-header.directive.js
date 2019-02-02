(function(){
	'use strict';
	
	function zfgcHeader($rootScope, UserService, $q, $window, WebsocketService, WhosOnlineService) {
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

    			scope.startListener = function() {
    				$rootScope.$broadcast("WebsocketConnected");
			    };
    			
			    WebsocketService.openWebsocket("/forum/ws", scope.startListener);
    			
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
	    .directive("zfgcHeader", ['$rootScope','UserService', '$q', '$window', 'WebsocketService', 'WhosOnlineService', zfgcHeader]);
})();