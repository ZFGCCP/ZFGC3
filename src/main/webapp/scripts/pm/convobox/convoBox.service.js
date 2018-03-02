(function(){
	
	function ConvoBoxService($resource, localStorageService){
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
		
		return service;
	};
	
	angular.module('zfgc.pm')
		   .service('ConvoBoxService',['$resource','localStorageService',ConvoBoxService]);
	
})();