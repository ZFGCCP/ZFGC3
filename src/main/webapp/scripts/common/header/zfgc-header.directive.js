(function(){
	'use strict';
	
	function zfgcHeader(UserService, $q, $window) {
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
    			
    			scope.listener = $q.defer();
    			
    			scope.startListener = function() {
			      scope.socket.stomp.subscribe("/UserSocketC/Active", function(data) {
			        listener.notify({});
			      });
			      
			      scope.socket.stomp.send("/forum/UserSocketS/Init",{},{});
			    };
    			
    			scope.socket.client = new SockJS("/forum/ws", null, {transports:'websocket'});
    			scope.socket.stomp = Stomp.over(scope.socket.client);
    			scope.socket.stomp.connect({}, scope.startListener);
    			
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
	    .directive("zfgcHeader", ['UserService', '$q', '$window', zfgcHeader]);
})();