(function(){
	function userDetails(UserService){
		var directive = {};
		
		directive.templateUrl = 'scripts/directives/user-details/user-details.directive.html';
		directive.scope = {
				userId : '@'
		};
		
		directive.link = function($scope,element,attrs){
			$scope.user = UserService.resource.userProfile({'userId':$scope.userId});
			
			$scope.getAvatarUrl = function(){
				return UserService.getAvatarUrl($scope.user.avatar);
			};
		};
		
		return directive;
	}
	
	angular.module('zfgc.users')
		   .directive('userDetails',['UserService',userDetails]);
})();