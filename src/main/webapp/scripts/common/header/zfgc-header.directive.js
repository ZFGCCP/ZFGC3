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
    			scope.user = UserService.resource.loggedInUser();
    			UserService.loggedInUser = scope.user;
    		}
    	}
    }
	
	angular
	    .module("zfgc.forum")
	    .directive("zfgcHeader", ['UserService', zfgcHeader]);
})();