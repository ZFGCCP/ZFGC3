(function(){
	
	function PmService($timeout,$resource,UserSearchService, ConvoBoxService, UserService){
		var pmService = {};
		
		pmService.resource = $resource('/forum/pm/template',{},{
			template : {
				url : '/forum/pm/template',
				method : 'GET'
			},
			send : {
				url : '/forum/pm/send',
				method : 'POST'
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
		
		pmService.getUserDisplayName = function(usersId){
			return UserService.resource.getUserDisplayName({'userId' : usersId});
		};
		
		pmService.appendToSenderList = function(vm,user){
			if(!vm.personalMessage.receivers || vm.personalMessage.receivers === null){
				vm.personalMessage.receivers = [];
			}
			
			vm.personalMessage.receivers.push({'usersId' : user.usersId, 'displayName' : user.displayName});
		};
		
		pmService.getTemplate = function(){
			return pmService.resource.template();
		};
		
		pmService.checkIfUserInList = function(vm,usersId){
			if(!vm || vm === null || !usersId || usersId === null){
				return null;
			}
			
			for(var i = 0; i < vm.sendersList.length; i++){
				if(vm.personalMessage.receivers[i].userId === usersId){
					return true;
				}
			}
			
			return false;
		};
		
		pmService.removeUserFromList = function(vm,index){
			if(!vm || vm === null){
				return null;
			}
			
			vm.personalMessage.receivers.splice(index,1);
		};
		
		pmService.sendPm = function(vm){
			var result = pmService.resource.send(vm.personalMessage);
			
			result.$promise.then(function(data){
				//go to conversation
			});
		};
		
		pmService.getConvoBox = function(){
			return ConvoBoxService.getConvoBox();
		};
		
		pmService.getConvoBox();
		
		return pmService;
	}
	
	angular.module('zfgc.pm')
		   .service('PmService',['$timeout','$resource','UserSearchService','ConvoBoxService','UserService',PmService]);
	
})();