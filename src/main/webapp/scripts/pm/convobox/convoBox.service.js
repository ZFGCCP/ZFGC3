(function(){
	
	function ConvoBoxService($resource, $state, localStorageService){
		var service = {};
		
		service.resource = $resource('/forum/pm/convobox',{},{
			convoBox : {
				url : '/forum/pm/convobox',
				method : 'POST'
			}
		});
		
		//testing purposes only
		localStorageService.set('pmKey', 'butts');
		
		service.getConvoBox = function(){
			return service.resource.convoBox({'key' : localStorageService.get('pmKey')});
		};
		
		service.stripHtml = function (text) {
		      var result = text ? String(text).replace(/<[^>]+>/gm, '') : '';
		      
		      if(result.length > 20){
		    	  result = result.subString(0,10) + "...";
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
		   .service('ConvoBoxService',['$resource','$state','localStorageService',ConvoBoxService]);
	
})();