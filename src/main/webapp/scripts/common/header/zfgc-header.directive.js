(function(){
	'use strict';
	
	function zfgcHeader(UserService, $q, $window, WebsocketService) {
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
    			  WebsocketService.subscribe("/socket/whosonline", function(data) {
			        console.log(data);
			      });
    			  WebsocketService.send("/forum/usersocket/init",{},{});
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
	    .directive("zfgcHeader", ['UserService', '$q', '$window', 'WebsocketService', zfgcHeader]);
})();