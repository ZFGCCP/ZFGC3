(function(){
	'use strict';
	angular
	    .module("zfgc.forum")
	    .directive("zfgcHeader", function() {
	    	return {
	    		restrict: 'E',
	    		transclude: true,
	    		templateUrl: 'scripts/common/header/zfgc-header.html',
	    		scope: {
	    			//
	    		},
	    		link: function(scope, element, attrs) {
	    			//
	    		}
	    	}
	    });
})();