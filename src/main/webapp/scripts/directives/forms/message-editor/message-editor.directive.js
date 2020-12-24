(function(){
	'use strict';
	
	function MessageEditor($window, $timeout, PmService, ForumPostService, ForumService, UserService, MessageEditorService){
		var directive = {};
		directive.restrict = 'E';
		directive.templateUrl = "scripts/directives/forms/message-editor/message-editor.directive.html";
		directive.scope = {
				showReplyBox:'=',
				vm:'=?',
				ngModel: '=',
				onSubmit: '&'
		}

		directive.link = function ($scope, element, attrs) {
			$scope.getLastCursorPos = function(){
				$timeout(function(){
					$scope.currentCursorPos = angular.element(element[0]).find('textarea')[0].selectionStart;
				},100);
			};
			
			$scope.insertShortcut = function(shortcut){
				$scope.ngModel = MessageEditorService.insertShortcut($scope.currentCursorPos, $scope.ngModel, shortcut);
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
				$scope.onSubmit();
			};
		}
		
		return directive;
	}
	
	angular.module("zfgc.forum")
		   .directive("messageEditor", ['$window','$timeout', 'PmService','ForumPostService', 'ForumService', 'UserService', 'MessageEditorService', MessageEditor]);
	
})();