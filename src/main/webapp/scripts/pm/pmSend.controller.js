(function(){
	
	function PmSendCtrl($scope, UserSearchService,UserService){
		var vm =  this;
		
		vm.currentIndex = 0;
		vm.length = 10;
		
		vm.searchForUsers = function(query, start, length){
			if(!query || query === null || query === '' || length === 0 || query.length < 3){
				vm.clearUserList();
				return;
			}
			
			var results = UserSearchService.performSearch(query, start, length);
			
			results.$promise.then(function(data){
				vm.populateUserList(data);
			});
		};
		
		vm.init = function(){
			
		};
		
		vm.send = function(){
			
		};
		
		vm.populateUserList = function(results){
			if(!vm.users || vm.users === null){
				vm.clearUserList();
			}
			
			if(results.length > 0){
				Array.prototype.push.apply(vm.users,results);
				vm.currentIndex = results.length >= 10 ? vm.users.length + 10 : vm.users.length;
			}
		};
		
		vm.clearUserList = function(){
			vm.users = [];
			vm.currentIndex = 0;
		};
		
		vm.getAvatarUrl = function(user){
			return UserService.getAvatarUrl(user.avatar);
		};
	}
	
	angular.module('zfgc.pm')
		   .controller('PmSendCtrl',['$scope','UserSearchService','UserService',PmSendCtrl]);
	
})();