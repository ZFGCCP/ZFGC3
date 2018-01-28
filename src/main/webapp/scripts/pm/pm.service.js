(function(){
	
	function PmService($timeout,$resource,UserSearchService){
		var pmService = {};
		
		pmService.resource = $resource("forum/pm",{usersId : '@usersId'},
		{
			getUserDisplayName : {
				url : '/forum/users/displayName/:usersId',
				method : 'GET'
			}
		});
		
		pmService.pmConstants = {
			bbCodes : {
				bold : 1,
				italic : 2,
				underline : 3,
				strikethrough : 4
			}	
		};
		
		pmService.populateUserList = function(vm,results){
			if(!vm.users || vm.users === null){
				vm.clearUserList();
			}
			
			if(results.length > 0){
				Array.prototype.push.apply(vm.users,results);
				vm.currentIndex = results.length >= 10 ? vm.users.length + 10 : vm.users.length;
			}
		};
		
		pmService.getLastCursorPos = function(vm){
			$timeout(function(){
				vm.currentCursorPos = vm.textArea[0].selectionStart;
			},100);
		};
		
		pmService.insertShortcut = function(vm,shortcut){
			vm.personalMessage.message = vm.personalMessage.message.slice(0,vm.currentCursorPos) + pmService.getBbCodeFromLkup(vm.lookups.BBCODE,shortcut) + vm.personalMessage.message.slice(vm.currentCursorPos);
		};
		
		pmService.getBbCodeFromLkup = function(lookups,code){
			for(var i = 0; i < lookups.length;i++){
				if(lookups[i].id === code){
					return lookups[i].value;
				}
			}
			
			return null;
		};
		
		pmService.searchForUsers = function(vm,query, start, length){
			if(!query || query === null || query === '' || length === 0 || query.length < 3){
				vm.clearUserList();
				return;
			}
			
			var results = UserSearchService.performSearch(query, start, length);
			
			results.$promise.then(function(data){
				vm.populateUserList(data);
			});
		};
		
		pmService.getUserDisplayName = function(vm,usersId){
			return pmService.resource.getUserDisplayName({'usersId' : usersId});
		};
		
		pmService.appendToSenderList = function(vm,user){
			if(!vm.sendersList || vm.sendersList === null){
				vm.sendersList = [];
			}
			
			vm.sendersList.push(user);
		};
		
		return pmService;
	}
	
	angular.module('zfgc.pm')
		   .service('PmService',['$timeout','$resource','UserSearchService',PmService]);
	
})();