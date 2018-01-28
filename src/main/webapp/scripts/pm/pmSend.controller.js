(function(){
	
	function PmSendCtrl($scope, $timeout,$location, UserSearchService,UserService,PmService,LookupsService){
		var vm =  this;
		
		vm.personalMessage = {"message":""};
		vm.currentIndex = 0;
		vm.length = 10;
		vm.currentCursorPos = 0;
		
		vm.textArea = angular.element("textarea");
		
		vm.lookups = LookupsService.getLookupsList("BBCODE");
		
		vm.getLastCursorPos = function(){
			PmService.getLastCursorPos(vm);
		};
		
		vm.insertShortcut = function(shortcut){
			PmService.insertShortcut(vm,shortcut);
		};
		
		vm.searchForUsers = function(query, start, length){
			PmService.searchForUsers(vm,query,start,length);
		};
		
		vm.getConstants = function(){
			return PmService.pmConstants;
		};
		
		vm.send = function(){
			
		};
		
		vm.populateUserList = function(results){
			PmService.populateUserList(vm,results);
		};
		
		vm.clearUserList = function(){
			vm.users = [];
			vm.currentIndex = 0;
		};
		
		vm.getAvatarUrl = function(user){
			return UserService.getAvatarUrl(user.avatar);
		};
		
		vm.getUserDisplayName = function(usersId){
			var user = PmService.getUserDisplayName(usersId);
			
			user.$promise.then(function(data){
				PmService.appendToSenderList(vm,data);
			});
		}
		
		vm.init = function(){
			if($location.search().senderId){
				vm.getUserDisplayName($location.search().senderId);
			}
		};
		
		vm.init();
	}
	
	angular.module('zfgc.pm')
		   .controller('PmSendCtrl',['$scope','$timeout','$location','UserSearchService','UserService','PmService','LookupsService',PmSendCtrl]);
	
})();