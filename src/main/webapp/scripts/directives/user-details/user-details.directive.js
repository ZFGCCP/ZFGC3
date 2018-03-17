(function(){
	function userDetails(UserService){
		var directive = {};
		
		directive.templateUrl = 'scripts/directives/user-details/user-details.directive.html';
		directive.scope = {
				userId : '@'
		};
		
		directive.link = function($scope,element,attrs){
			$scope.user = UserService.resource.getUserDetailsById($scope.userId);
		};
		
		return directive;
	}
	
	angular.module('zfgc-users')
		   .directive('user-details',['UserService',userDetails]);
})();