(function(){
	
	function RemoveUserModalCtrl(PmService, UserService, params){
		var vm = this;
		
		vm.conversation = params.conversation;
		
		vm.removeUser = function(index){
			var result = PmService.removeUser(vm.conversation.pmConversationId, vm.conversation.participants[index].usersId);
			
			result.$promise.then(function(data){
				vm.conversation.participants.splice(index,1);
			});
		};
		
		vm.getAvatar = function(avatar){
			return UserService.getAvatarUrl(avatar);
		};
	}
	
	angular.module('zfgc.pm')
		   .controller('RemoveUserModalCtrl',['PmService','UserService','params',RemoveUserModalCtrl]);
	
})();