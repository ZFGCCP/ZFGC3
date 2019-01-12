(function(){
	'use strict';
	
	function zfgcHeader(UserService) {
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
    			
    			scope.socket.client = new SockJS("/forum/UserSocketS/init");
    			scope.socket.stomp = Stomp.over(socket.client);
    			
    			scope.user = UserService.resource.loggedInUser();
    			UserService.loggedInUser = scope.user;
    		}
    	}
    }
	
	angular
	    .module("zfgc.forum")
	    .directive("zfgcHeader", ['UserService', zfgcHeader]);
})();