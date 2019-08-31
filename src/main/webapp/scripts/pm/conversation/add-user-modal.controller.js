(function(){
	
	function AddUserModalCtrl($rootScope,PmService, UserService, params,NotificationsService){
		var vm = this;
		
		vm.usersToAdd = [];
		vm.conversationId = params.conversationId;
		vm.conversation = params.conversation;
		vm.modal = params.modal;
		vm.vm = params.vm;
		
		vm.addUser = function(user){
			vm.usersToAdd.push(user);
		};
		
		vm.removeUser = function(index){
			vm.usersToAdd.splice(index,1);
		};
		
		vm.getAvatar = function(avatar){
			return UserService.getAvatarUrl(avatar);
		};
		
		vm.addUsers = function(){
			var mappedUserIds = vm.usersToAdd.map(function(item){return item.usersId;});
			vm.conversation.participants = vm.conversation.participants.concat(mappedUserIds);
			
			for(var i = 0; i < mappedUserIds.length; i++){
				//get the user from the participants
				var profileContainer = {};
				UserService.loadProfile(mappedUserIds[i], profileContainer);
				vm.vm.participants.push(profileContainer.profile);
			}
			
			if(vm.conversation.pmConversationId === null){
				vm.conversation.messages[0].receivers = vm.conversation.participants;
			}
			vm.modal.close();
		};
		
		vm.inviteUsers = function(){
			PmService.inviteUsers(vm.conversationId,vm.usersToAdd).$promise.then(function(data){
				vm.modal.close();
				$rootScope.$broadcast('alertAdded',NotificationsService.createAlert('Users Invited Successfully','Success'));
			});
		};
	}
	
	angular.module('zfgc.pm')
		   .controller('AddUserModalCtrl',['$rootScope','PmService','UserService','params','NotificationsService',AddUserModalCtrl]);
	
})();