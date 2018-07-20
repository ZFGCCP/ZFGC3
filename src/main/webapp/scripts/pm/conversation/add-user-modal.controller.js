(function(){
	
	function AddUserModalCtrl(PmService, UserService, params){
		var vm = this;
		
		vm.usersToAdd = [];
		
		vm.addUser = function(user){
			vm.usersToAdd.push(user);
		};
		
		vm.removeUser = function(index){
			vm.usersToAdd.splice(index,1);
		};
		
		vm.getAvatar = function(avatar){
			return UserService.getAvatarUrl(avatar);
		};
	}
	
	angular.module('zfgc.pm')
		   .controller('AddUserModalCtrl',['PmService','UserService','params',AddUserModalCtrl]);
	
})();