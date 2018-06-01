(function(){
	'use strict';
	
	function dateSelector(uibDateParser){
		var directive = {};
		directive.restrict = 'E';
		directive.templateUrl = "scripts/directives/forms/date-selector/date-selector.directive.html";
		directive.scope = {
				ngModel:'='
		}

		directive.link = function ($scope, element, attrs) 
		{ 
			$scope.isOpen = false;
			$scope.format = 'MM/dd/yyyy';
			$scope.internalDate = null;
			
			if($scope.ngModel && $scope.ngModel !== null && $scope.ngModel !== ''){
				$scope.internalDate = new Date($scope.ngModel);
			}
			
			$scope.open = function(){
				$scope.isOpen = !$scope.isOpen;
			};
			
			$scope.parseDate = function(){
			  var mm = $scope.internalDate.getMonth() + 1;
			  var dd = $scope.internalDate.getDate();

			  $scope.ngModel = [
			           (mm>9 ? '' : '0') + mm + "/",
			           (dd>9 ? '' : '0') + dd + "/",
			           $scope.internalDate.getFullYear()
			         ].join('');
			};
		}
		
		return directive;
	};
	
	angular
	       .module("zfgc.forum")
	       .directive("dateSelector", ['uibDateParser',dateSelector]);
})();