(function(){
	
	function PmSendCtrl($scope, UserSearchService){
		var vm =  {};
		
		vm.currentIndex = 0;
		vm.length = 10;
		
		vm.searchForUsers = function(query, start, length){
			if(query === null || query === '' || length === 0){
				return;
			}
			
			var results = UserSearchService.performSearch(query, start, length);
			vm.populateUserList(results);
		};
		
		vm.init = function(){
			
		};
		
		vm.send = function(){
			
		};
		
		vm.populateUserList = function(results){
			if(!vm.users || vm.users === null){
				vm.clearUserList();
			}
			
			vm.users.push(results);
			vm.currentIndex += vm.length;
		};
		
		vm.clearUserList = function(){
			vm.users = [];
			vm.currentIndex = 0;
		}
	}
	
	angular.module('zfgc.pm')
		   .controller('PmSendCtrl',['$scope','UserSearchService',PmSendCtrl]);
	
})();