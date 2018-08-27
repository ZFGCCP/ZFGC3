(function(){
	
	function ConvoBoxService($resource, $state, NotificationsService,localStorageService, ModalService){
		var service = {};
		
		service.resource = $resource('/forum/pm/convobox',{'filterType' : '@filterType'},{
			convoBox : {
				url : '/forum/pm/convobox',
				method : 'POST'
			},
			archive : {
				url : '/forum/pm/conversation/archive',
				method : 'POST'
			},
			leave : {
				url : '/forum/pm/conversation/delete',
				method : 'POST'
			}
		});
		
		//testing purposes only
		//localStorageService.set('pmKey', 'butts');
		
		service.getConvoBox = function(vm){
			return service.resource.convoBox({'filterType' : vm.filters.filterBy, 'key' : localStorageService.get('pmKey')});
		};
		
		service.deleteConversations = function(vm){
			var params = vm;
			params.modal = ModalService.createConfirmDialog("Are you sure you want to leave?",
											 "You will not be able to rejoin these conversations unless someone adds you.",
											 service.deleteConversationsConfirm,
											 params);
		};
		
		service.deleteConversationsConfirm = function(vm){
			var convos = [];
			for(var i = 0; i < vm.convoBox.conversations.length; i++){
				if(vm.convoBox.conversations[i].isSelected){
					convos.push(vm.convoBox.conversations[i].pmConversationId);
				}
			}
			
			if(convos.length > 0){
				service.resource.leave({'aesKey' : {'key':localStorageService.get('pmKey')}, 'convoIds' : convos }).$promise.then(function(data){
					NotificationsService.addAlert("Conversations pruned successfully","success");
					$state.reload();
				});
			}
		};
		
		service.archiveConversations = function(vm){
			var params = vm;
			params.modal = ModalService.createConfirmDialog("Are you sure you want to archive?",
											 "You will not be able to rejoin these conversations.",
											 service.archiveConversationsConfirm,
											 params);
		};
		
		service.archiveConversationsConfirm = function(vm){
			var convos = [];
			for(var i = 0; i < vm.convoBox.conversations.length; i++){
				if(vm.convoBox.conversations[i].isSelected){
					convos.push(vm.convoBox.conversations[i].pmConversationId);
				}
			}
			
			if(convos.length > 0){
				service.resource.archive({'aesKey' : {'key':localStorageService.get('pmKey')}, 'convoIds' : convos }).$promise.then(function(data){
					NotificationsService.addAlert('Conversations Archived Successfully','success');
					$state.reload();
				});
			}
		};
		
		service.stripHtml = function (text) {
		      var result = text ? String(text).replace(/<[^>]+>/gm, '') : '';
		      
		      if(result.length > 20){
		    	  result = result.substring(0,10) + "...";
		      }
		      
		      return result;
	    };
	    
	    service.checkForCheckedBoxes = function(vm){
	    	for(var i = 0; i < vm.convoBox.conversations.length; i++){
	    		if(vm.convoBox.conversations[i].isSelected === true){
	    			vm.boxesSelected = true;
	    			return;
	    		}
	    	}
	    	
	    	vm.boxesSelected = false;
	    };
	    
	    service.newMessage = function(){
	    	$state.go('sendPm');
	    };
		
		return service;
	};
	
	angular.module('zfgc.pm')
		   .service('ConvoBoxService',['$resource','$state', 'NotificationsService','localStorageService','ModalService',ConvoBoxService]);
	
})();