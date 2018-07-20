(function(){
	
	function userNameIcon(PmService){
		var directive = {};
		
		directive.templateUrl = 'scripts/directives/user-name-icon/user-name-icon.directive.html';
		directive.scope = {
				usersId : '=',
				displayName : '=',
				vm :'='
		};
		
		directive.link = function($scope,element,attrs){
			$scope.removeUserFromConversation = function(){
				PmService.removeUser($scope.vm.conversation.pmConversationId,$scope.usersId,$scope.vm);
			};
		};
		
		return directive;
	}
	
	angular.module('zfgc.users')
		   .directive('userNameIcon',['PmService',userNameIcon]);
	
})();