(function(){
	
	function whosOnlineService(){
		var service = {};

		
		service.updateWhosOnline = function(data){
			var users = JSON.parse(data.body);

			return users.body ? users.body : users;
		};
		
		
		
		return service;
	};
	
	angular.module('zfgc.forum')
		   .service('WhosOnlineService', [whosOnlineService]);
	
})();