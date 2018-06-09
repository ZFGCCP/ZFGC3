(function(){
	
	function conversationCtrl($scope, $location, PmService, ForumPostService, ModalService){
		var vm = this;
		vm.showReplyBox = false;
		
		vm.participants = [];
		
		vm.openConversation = function(conversationId){
			vm.conversation = PmService.openConvo(vm,conversationId);
		};
		
		vm.getConvoTitle = function(){
			return PmService.getConvoTitle(vm);
		};
		
		vm.leaveConvo = function(){
			PmService.leaveConversation(vm,vm.conversation.pmConversationId);
		};
		
		vm.toggleReplyBox = function(){
			ForumPostService.toggleMessageReply(vm);
			
			if(vm.showReplyBox){
				vm.personalMessage = PmService.getTemplate({receivers : vm.participants, pmConversationId : vm.conversation.pmConversationId});
			}
		};
		
		if($location.search().conversationId && $location.search().conversationId !== null){
			vm.openConversation($location.search().conversationId);
		}
	}
	
	angular.module('zfgc.pm')
		   .controller('ConversationCtrl',['$scope','$location','PmService','ForumPostService','ModalService',conversationCtrl]);
	
})();