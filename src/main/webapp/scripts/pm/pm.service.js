(function(){
	
	function PmService($rootScope,$timeout,$resource,$state,UserSearchService, ConvoBoxService, localStorageService, UserService, ModalService,PmComparatorService,NotificationsService){
		var pmService = {};
		
		pmService.resource = $resource('/forum/pm/template',{'conversationId' : '@conversationId'},{
			template : {
				url : '/forum/pm/template',
				method : 'POST'
			},
			send : {
				url : '/forum/pm/send',
				method : 'POST'
			},
			open : {
				url : '/forum/pm/conversation/:conversationId',
				method : 'POST'
			},
			convoTemplate : {
				url : '/forum/pm/conversation/template',
				method : 'GET'
			},
			leave : {
				url : '/forum/pm/conversation/:conversationId/delete',
				method : 'POST'
			},
			removeUser : {
				url : '/forum/pm/conversation/:conversationId/delete/:usersId',
				method : 'POST'
			},
			newSubject : {
				url : '/forum/pm/conversation/:conversationId/subject',
				method : 'PUT'
			},
			pruneTemplate : {
				url : '/forum/pm/convobox/prune/template',
				method : 'GET'
			},
			prune : {
				url : '/forum/pm/convobox/prune',
				method : 'POST'
			},
			invite : {
				url : '/forum/pm/conversation/:conversationId/inviteUsers',
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
		
		pmService.leaveConversation = function(vm,convoId){
			var params = {convoId : convoId};
			params.modal = ModalService.createConfirmDialog("Are you sure you want to leave?",
											 "You will not be able to rejoin the conversation unless someone adds you.",
											 pmService.leaveConversationConfirm,
											 params);
		};
		
		pmService.leaveConversationConfirm = function(params){
			var result = pmService.resource.leave({'key' : localStorageService.get('pmKey'), 'conversationId' : params.convoId});
			
			result.$promise.then(function(data){
				params.modal.close();
				$rootScope.$broadcast('alertAdded',NotificationsService.createAlert('You have left the conversation','success'));
				$state.go('convoBox',{reload:true});
			});
		};
		
		pmService.removeUser = function(conversationId, usersId,vm){
			return pmService.resource.removeUser({conversationId : conversationId, usersId : usersId},{'key' : localStorageService.get('pmKey')});
		};
		
		pmService.openConvo = function(vm,convoId){
			var convo = pmService.resource.open({'key' : localStorageService.get('pmKey'), 'conversationId' : convoId});
			
			convo.$promise.then(function(data){
				for(var i = 0; i < data.messages.length; i++){
					//vm.participants.push(data.messages[0].receivers[i]);
					
					//get the user from the participants
					var profileContainer = {};
					UserService.loadProfile(data.participants.filter(function(item){
																		return item === data.messages[i].senderId;
																	})[0], profileContainer);
					vm.participants.push(profileContainer.profile);
				}
			});
			
			return convo;
		};
		
		pmService.getParticipant = function(vm, userId){
			if(vm.participants !== null){
				return vm.participants.filter(function(item){
					return item.usersId === userId;
				})[0];
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
		
		pmService.appendToReceiverList = function(vm, user){
			vm.conversation.participants.push({'usersId' : user.usersId, 'displayName' : user.displayName});
		};
		
		pmService.getTemplate = function(templateConfig){
			if(templateConfig && templateConfig !== null){
				return pmService.resource.template(templateConfig);
			}
			else{
				return pmService.resource.template();
			}
		};
		
		pmService.checkIfUserInList = function(vm,usersId){
			if(!vm || vm === null || !usersId || usersId === null){
				return null;
			}
			
			for(var i = 0; i < vm.personalMessage.receivers.length; i++){
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
		
		pmService.sendPm = function(message){
			var result = pmService.resource.send(message);
			
			result.$promise.then(function(data){
				$state.go('convo',{conversationId : data.pmConversationId},{reload : true});
				$rootScope.$broadcast('alertAdded',NotificationsService.createAlert('PM Successfully Sent','success'));
			});
		};
		
		pmService.getConvoBox = function(){
			return ConvoBoxService.getConvoBox();
		};
		
		pmService.getConvoTitle = function(vm){
			var lastMessage = vm.conversation.messages.length - 1;
			
			return vm.conversation.messages[lastMessage].subject;
		};
		
		pmService.openPruneDialog = function(vm){
			ModalService.createTemplatedPopup('PruneConvoCtrl','scripts/modal/templates/modalConvoPrune.html','prune-modal');
		};
		
		pmService.pruneConversations = function(vm){
			vm.prune.tfa = {'key' : localStorageService.get('pmKey')};
			var result = pmService.resource.prune(vm.prune);
			
			return result;
		};
		
		pmService.setAuthorization = function(key){
			localStorageService.set('pmKey', key);
		};
		
		pmService.sortMessages = function(vm){
			switch(vm.filters.sortBy){
			case 0:
				vm.convoBox.conversations.sort(PmComparatorService.compareByLastSentTime);
				break;
				
			case 1:
				vm.convoBox.conversations.sort(PmComparatorService.compareByStartedDt);
				break;
				
			case 2:
				vm.convoBox.conversations.sort(PmComparatorService.compareByStartingUser);
				break;
				
			case 3:
				vm.convoBox.conversations.sort(PmComparatorService.compareByLastSentUser);
				break;
				
			case 4:
				vm.convoBox.conversations.sort(PmComparatorService.compareBySubject);
				break;
			}
		};
		
		pmService.openAddUserModal = function(vm){
			ModalService.createTemplatedPopup('AddUserModalCtrl','scripts/modal/templates/modalAddUserToConvo.html','add-user-modal',{conversation : vm.conversation, conversationId : vm.conversation.pmConversationId});
		};
		
		pmService.openParticipantsModal = function(vm){
			ModalService.createTemplatedPopup('RemoveUserModalCtrl','scripts/modal/templates/modalRemoveUserFromConvo.html','remove-user-modal',{conversation : vm.conversation});
		}
		
		pmService.inviteUsers = function(conversationId, users){
			var usersToInvite = {'aesKey' : {'key' : localStorageService.get('pmKey')}, users : users};
			var result = pmService.resource.invite({conversationId : conversationId},usersToInvite);
			return result;
		};
		
		pmService.updateConversationSubject = function(vm, conversation){
			pmService.resource.newSubject({conversationId : conversation.pmConversationId}, conversation.subject).$promise.then(function(){
				vm.editingSubject = false;
				$rootScope.$broadcast('alertAdded',NotificationsService.createAlert('Subject updated successfully.','success'));
			});
		};

		return pmService;
	}
	
	angular.module('zfgc.pm')
		   .service('PmService',['$rootScope','$timeout','$resource','$state','UserSearchService','ConvoBoxService','localStorageService','UserService','ModalService','PmComparatorService','NotificationsService',PmService]);
	
})();