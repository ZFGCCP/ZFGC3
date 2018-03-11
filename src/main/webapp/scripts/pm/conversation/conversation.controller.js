(function(){
	
	function conversationCtrl($scope, $location, PmService){
		var vm = this;
		
		vm.openConversation = function(conversationId){
			vm.conversation = PmService.openConvo(vm,conversationId);
		};
		
		if($location.search().conversationId && $location.search().conversationId !== null){
			vm.openConversation($location.search().conversationId);
		}
	}
	
	angular.module('zfgc.pm')
		   .controller('ConversationCtrl',['$scope','$location','PmService',conversationCtrl]);
	
})();