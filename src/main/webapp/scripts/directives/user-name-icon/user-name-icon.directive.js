(function(){
	
	function userNameIcon(PmService,UserService,NotificationsService){
		var directive = {};
		
		directive.templateUrl = 'scripts/directives/user-name-icon/user-name-icon.directive.html';
		directive.scope = {
				usersId : '=',
				displayName : '=',
				vm :'='
		};
		
		directive.link = function($scope,element,attrs){
			$scope.removeUserFromConversation = function(){
				PmService.removeUser($scope.vm.conversation.pmConversationId,$scope.usersId,$scope.vm).$promise.then(function(data){
					NotificationsService.addAlert("User Successfully Removed","success");
					
					//we can't do this in one line unfortunately due to some issue with gulp-angular-filesort
					var userIndex = $scope.vm.conversation.participants.map(function(e) { return e.usersId; }).indexOf('$scope.usersId');
					$scope.vm.conversation.participants.splice(userIndex,1);
				});
			};
			
			$scope.isLoggedInUser = function(){
				return $scope.usersId === UserService.loggedInUser.usersId;
			};
		};
		
		return directive;
	}
	
	angular.module('zfgc.users')
		   .directive('userNameIcon',['PmService','UserService','NotificationsService',userNameIcon]);
	
})();