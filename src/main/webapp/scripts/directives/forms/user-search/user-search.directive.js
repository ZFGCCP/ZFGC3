(function(){
	'use strict';
	
	function userSearch(UserSearchService){
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
			$scope.currentIndex = 0;
			
			$scope.termChanged = function(val){
				if(val.length > 3){
					$scope.results = UserSearchService.performSearch(val,0,10);
					
					$scope.results.$promise.then(function(data){
						$scope.dropdownOpen = true;
						return data;
					});
				}
			}
		}
		
		return directive;
	};
	
	angular
	       .module("zfgc.forum")
	       .directive("userSearch", ['UserSearchService',userSearch]);
})();