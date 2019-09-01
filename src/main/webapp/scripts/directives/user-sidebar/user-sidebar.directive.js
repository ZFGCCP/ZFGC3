(function(){
	'use strict';
	
	function userSidebar(UserService){
		var directive = {};
		directive.restrict = 'E';
		directive.transclude = true;
		directive.templateUrl = "scripts/directives/user-sidebar/user-sidebar.directive.html";
		directive.scope = {
				profile : '=',
				navTabs : '=?',
				mode : '@?'
		}

		directive.link = function ($scope, element, attrs) 
		{ 
			$scope.getAvatarUrl = function(){
				if($scope.profile && $scope.profile !== null){
					return UserService.getAvatarUrl($scope.profile.personalInfo.avatar);
				}
			};
		};
		
		return directive;
	};
	
	angular
	       .module("zfgc.forum")
	       .directive("userSidebar", ['UserService', userSidebar]);
})();