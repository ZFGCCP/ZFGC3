(function(){
	'use strict';
	
	function MessageEditor(PmService, ForumPostService){
		var directive = {};
		directive.restrict = 'E';
		directive.templateUrl = "scripts/directives/forms/message-editor/message-editor.directive.html";
		directive.scope = {
				ngModel:'=',
				showReplyBox:'='
		}

		directive.link = function ($scope, element, attrs) {
			$scope.getLastCursorPos = function(){
				PmService.getLastCursorPos(vm);
			};
			
			$scope.insertShortcut = function(shortcut){
				PmService.insertShortcut(vm,shortcut);
			};
			
			$scope.toggleReplyBox = function(){
				ForumPostService.toggleMessageReply($scope);
				
				if($scope.showReplyBox){
					vm.personalMessage = PmService.getTemplate({receivers : vm.participants, pmConversationId : vm.conversation.pmConversationId});
				}
			};
		}
	}
	
	angular.module("zfgc.forum")
		   .directive("messageEditor", ['PmService','ForumPostService',MessageEditor]);
	
})();