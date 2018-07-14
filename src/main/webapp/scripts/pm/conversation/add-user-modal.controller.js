(function(){
	
	function AddUserModalCtrl(PmService, params){
		var vm = {};
		
		vm.usersToAdd = [];
		
		vm.addUser = function(user){
			vm.usersToAdd.push(user);
		};
	}
	
	angular.module('zfgc.pm')
		   .controller('AddUserModalCtrl',['PmService','params',AddUserModalCtrl]);
	
})();