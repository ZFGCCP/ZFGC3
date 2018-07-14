(function(){
	
	function userNameIcon(PmService){
		var directive = {};
		
		directive.templateUrl = 'scripts/directives/user-name-icon/user-name-icon.directive.html';
		directive.scope = {
				usersId : '=',
				displayName : '='
		};
		
		directive.link = function($scope,element,attrs){
			$scope.removeUserFromConversation = function(){
				
			}
		};
		
		return directive;
	}
	
	angular.module('zfgc.users')
		   .directive('userNameIcon',['PmService',userNameIcon]);
	
})();