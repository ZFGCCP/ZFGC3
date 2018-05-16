(function(){
	'use strict';
	
	function userSearch(){
		var directive = {};
		directive.restrict = 'E';
		directive.templateUrl = "scripts/directives/forms/user-search/user-search.directive.html";
		directive.scope = {
				classList:"@",
				ngModel:'='
		}

		directive.link = function ($scope, element, attrs) 
		{ 
			$scope.dropdownOpen = false;

		};;
		
		return directive;
	};
	
	angular
	       .module("zfgc.forum")
	       .directive("userSearch", userSearch);
})();