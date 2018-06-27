(function(){
	'use strict';
	
	function MessageEditor(PmService, ForumPostService){
		var directive = {};
		directive.restrict = 'E';
		directive.templateUrl = "scripts/directives/forms/message-editor/message-editor.directive.html";
		directive.scope = {
				showReplyBox:'=',
				conversation:'='
		}

		directive.link = function ($scope, element, attrs) {
			$scope.template = {
				pmConversationId : $scope.conversation.pmConversationId,
				receivers : $scope.conversation.participants,
				subject : ""
			};
			$scope.personalMessage = PmService.getTemplate($scope.template);
			
			$scope.getLastCursorPos = function(){
				PmService.getLastCursorPos(vm);
			};
			
			$scope.insertShortcut = function(shortcut){
				PmService.insertShortcut(vm,shortcut);
			};
			
			$scope.toggleReplyBox = function(){
				ForumPostService.toggleMessageReply($scope);
			};
			
			$scope.reply = function(){
				PmService.sendPm($scope.personalMessage);
			};
		}
		
		return directive;
	}
	
	angular.module("zfgc.forum")
		   .directive("messageEditor", ['PmService','ForumPostService',MessageEditor]);
	
})();