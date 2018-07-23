(function(){
	
	function AddUserModalCtrl(PmService, UserService, params){
		var vm = this;
		
		vm.usersToAdd = [];
		vm.conversationId = params.conversationId;
		vm.modal = params.modal;
		
		vm.addUser = function(user){
			vm.usersToAdd.push(user);
		};
		
		vm.removeUser = function(index){
			vm.usersToAdd.splice(index,1);
		};
		
		vm.getAvatar = function(avatar){
			return UserService.getAvatarUrl(avatar);
		};
		
		vm.inviteUsers = function(){
			PmService.inviteUsers(vm.conversationId,vm.usersToAdd).$promise.then(function(data){
				vm.modal.close();
			});
		};
	}
	
	angular.module('zfgc.pm')
		   .controller('AddUserModalCtrl',['PmService','UserService','params',AddUserModalCtrl]);
	
})();