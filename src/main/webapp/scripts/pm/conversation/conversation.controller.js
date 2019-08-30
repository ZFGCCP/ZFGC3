(function(){
	
	function conversationCtrl($rootScope, $scope, $state, $location, PmService, ForumPostService, ModalService){
		var vm = this;
		vm.showReplyBox = false;
		vm.editingSubject = false;
		
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
		
		vm.getConvoTemplate = function(){
			return PmService.resource.convoTemplate();
		};
		
		vm.closeConversation = function(){
			if($rootScope.previousState){
				$state.go($rootScope.previousState,$rootScope.previousStateParams)
			}
			else{
				$location.url("/");
			}
		};
		
		vm.toggleReplyBox = function(){
			ForumPostService.toggleMessageReply(vm);
			
			if(vm.showReplyBox){
				vm.personalMessage = PmService.getTemplate({receivers : vm.conversation.participants, pmConversationId : vm.conversation.pmConversationId});
			}
		};
		
		vm.openAddUserModal = function(){
			PmService.openAddUserModal(vm);
		};
		
		vm.removeUser = function(userId,conversationId){
			var result = PmService.removeUser(conversationId,userId,vm);
			
			result.$promise.then(function(data){
				$state.reload();
			});
		};
		
		vm.openParticipantsModal = function(){
			PmService.openParticipantsModal(vm);
		};
		
		vm.getUserDisplayName = function(usersId){
			var user = PmService.getUserDisplayName(usersId);
			
			user.$promise.then(function(data){
				PmService.appendToReceiverList(vm, user);
			});
		};
		
		vm.editSubject = function(){
			vm.editingSubject = true;
		};
		
		vm.changeSubject = function(){
			PmService.updateConversationSubject(vm, vm.conversation);
		};
		
		vm.getParticipant = function(userId){
			return PmService.getParticipant(vm, userId);
		};
		
		if($location.search().conversationId && $location.search().conversationId !== null){
			vm.openConversation($location.search().conversationId);
		}
		else{
			vm.conversation = vm.getConvoTemplate();
			
			vm.conversation.$promise.then(function(data){
				if($location.search().senderId){
					vm.getUserDisplayName($location.search().senderId);
				}
			});
			
		}
	}
	
	angular.module('zfgc.pm')
		   .controller('ConversationCtrl',['$rootScope','$scope','$state','$location','PmService','ForumPostService','ModalService',conversationCtrl]);
	
})();