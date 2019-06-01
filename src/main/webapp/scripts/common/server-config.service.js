(function(){
	
	function ServerConfigService($resource){
		var service = {};
		
		service.config = $resource('/forum/config',{}).get();
		
		return service;
		
		
	}
	
	angular.module('zfgc.forum')
		   .service('ServerConfigService',['$resource',ServerConfigService]);
	
})();