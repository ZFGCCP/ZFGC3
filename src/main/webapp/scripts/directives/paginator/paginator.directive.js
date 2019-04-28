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
			$scope.service = $resource($scope.loadUrl,{},{isArray: false, method : 'GET'});
			
			$scope.reloadData = function(){
				$scope.resultsModel = $scope.service.get({pageNo : $scope.pageNumber, usersPerPage : $scope.resultsPerPage});
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
			
			$scope.resultsModel.$promise.then(function(data){
				$scope.totalPages = Math.ceil(data.totalCount / $scope.resultsPerPage);
			});
		}
		
		return directive;
	}
	
	angular.module('zfgc.forum')
		   .directive('paginator',['$resource','$q',paginator]);
	
})();