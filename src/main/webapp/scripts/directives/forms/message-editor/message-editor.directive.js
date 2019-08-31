(function(){
	'use strict';
	
	function MessageEditor($window,PmService, ForumPostService, UserService){
		var directive = {};
		directive.restrict = 'E';
		directive.templateUrl = "scripts/directives/forms/message-editor/message-editor.directive.html";
		directive.scope = {
				showReplyBox:'=',
				conversation:'=',
				getTemplate:'@?'
		}

		directive.link = function ($scope, element, attrs) {
			$scope.template = {
				pmConversationId : $scope.conversation.pmConversationId,
				receivers : $scope.conversation.participants,
				subject : $scope.conversation.subject
			};
			
			$scope.$watch('conversation.subject', function(){
				$scope.personalMessage.subject = $scope.conversation.subject;
			});
			
			$scope.conversation.$promise.then(function(data){
				if(!$scope.getTemplate || $scope.getTemplate === null || $scope.getTemplate === false){
					$scope.personalMessage = $scope.conversation.messages[0];
				}
				else{
					var template = {};
					template.pmConversationId = $scope.conversation.pmConversationId;
					template.subject = !$scope.conversation.subject || $scope.conversation.subject === null ? "" : $scope.conversation.subject;
					template.receivers = $scope.conversation.participants;
					$scope.personalMessage = PmService.getTemplate(template);
				}
			});
			
			
			$scope.getLastCursorPos = function(){
				PmService.getLastCursorPos(vm);
			};
			
			$scope.insertShortcut = function(shortcut){
				PmService.insertShortcut(vm,shortcut);
			};
			
			$scope.toggleReplyBox = function(){
				if($scope.conversation.pmConversationId !== null){
					ForumPostService.toggleMessageReply($scope);
				}
				else{
					$window.history.back();
				}
			};
			
			$scope.reply = function(){
				$scope.personalMessage.receivers = $scope.conversation.participants;
				PmService.sendPm($scope.personalMessage);
			};
		}
		
		return directive;
	}
	
	angular.module("zfgc.forum")
		   .directive("messageEditor", ['$window','PmService','ForumPostService','UserService', MessageEditor]);
	
})();