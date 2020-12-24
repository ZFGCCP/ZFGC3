(function(){
	'use strict';
	
	function dropDownMenu($timeout){
		var directive = {};
		directive.restrict = 'E';
		directive.transclude = true;
		directive.templateUrl = "scripts/directives/dropdown/drop-down-menu.directive.html";
		directive.scope = {
				defaultLabel: "@",
				infoType: "@",
				ngDisabled: '='
		}

		directive.link = function ($scope, element, attrs) 
		{ 
			$scope.isOpen = false;
			$scope.iconType = null;
			
			$scope.toggleDropDown = function(){

				
			};
			
			if(angular.isUndefined($scope.ngDisabled)){
				$scope.ngDisabled = false;
			}
			
			if($scope.infoType === 'moderation'){
				$scope.iconType = "fas fa-hammer";
			}
			else if($scope.infoType && $scope.infoType !== null){
				$scope.iconType = "fas fa-plus";
			}
			
			
			$timeout(function(){
				var elm = element[0].getElementsByClassName("btn-dropdown");
				$scope.width = elm[0].offsetWidth;
				
				var elmCaret = element[0].getElementsByClassName("btn-dropdown-toggle");
				$scope.width += elmCaret[0].offsetWidth;
				
				var elmDdm = element.find("ul");
				$scope.elmDdm = elmDdm;
				
				angular.element(elmDdm[0]).css('width', $scope.width);
			}, 0);
			
		};
		
		return directive;
	};
	
	angular
	       .module("zfgc.forum")
	       .directive("dropDownMenu", ['$timeout', dropDownMenu]);
})();