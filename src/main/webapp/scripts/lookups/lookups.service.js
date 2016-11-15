(function(){
	'use strict';
	
	function LookupsService($resource){
		var LookupsService = {};
		
		LookupsService.resource = $resource('/forum/lookups/:lkupName', {lkupName:'@lkupName'},
		{
			getLkup : {
				url : '/forum/lookups/:lkupName',
				method: 'GET'
			},
			getLkupList : {
				url : '/forum/lookups/list',
				method: 'POST'
			}
		});
		
		LookupsService.getLookupsList = function(list){
			return LookupsService.resource.getLkupList(list);
		};
		
		return LookupsService;
		
	}
	
	angular
		.module('zfgc.forum')
		.service('LookupsService', ['$resource',LookupsService])
})();