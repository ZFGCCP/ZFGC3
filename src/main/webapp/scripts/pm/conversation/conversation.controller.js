(function(){
	
	function conversationCtrl($rootScope, $scope, $state, $location, PmService){
		var vm = this;
		
		vm.openConversation = function(conversationId){
			vm.conversation = PmService.openConvo(vm,conversationId);
		};
		
		vm.getConvoTitle = function(){
			return PmService.getConvoTitle(vm);
		};
		
		vm.leaveConvo = function(){
			PmService.leaveConversation(vm,vm.conversation.pmConversationId);
		};
		
		vm.closeConversation = function(){
			if($rootScope.previousState){
				$state.go($rootScope.previousState,$rootScope.previousStateParams)
			}
			else{
				$location.url("/");
			}
		};
		
		if($location.search().conversationId && $location.search().conversationId !== null){
			vm.openConversation($location.search().conversationId);
		}
	}
	
	angular.module('zfgc.pm')
		   .controller('ConversationCtrl',['$rootScope','$scope','$state','$location','PmService',conversationCtrl]);
	
})();