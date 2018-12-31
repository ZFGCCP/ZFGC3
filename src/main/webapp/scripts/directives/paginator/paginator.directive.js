(function(){
	
	function paginator($resource,$q){
		var directive = {};
		directive.restrict = 'E';
		directive.templateUrl = "scripts/directives/paginator/paginator.html";
		directive.scope = {
				loadUrl : '@',
				resultsModel : '='
		}
		
		directive.link = function ($scope, element, attrs) { 
			$scope.pageNumber = 1;
			$scope.resultsPerPage = 10;
			$scope.service = $resource($scope.loadUrl,{},{isArray : true, method : 'GET'});
			
			$scope.reloadData = function(){
				$scope.resultsModel = $scope.service.query({pageNo : $scope.pageNumber, usersPerPage : $scope.resultsPerPage});
			}
			
			$scope.forward = function(){
				//todo add bounds checking
				$scope.pageNumber += 1;
				$scope.reloadData();
			}
			
			$scope.back = function(){
				if($scope.pageNumber > 1){
					$scope.pageNumber -=1 ;
					$scope.reloadData();
				}
			}
			
			$scope.reloadData();
		}
		
		return directive;
	}
	
	angular.module('zfgc.forum')
		   .directive('paginator',['$resource','$q',paginator]);
	
})();