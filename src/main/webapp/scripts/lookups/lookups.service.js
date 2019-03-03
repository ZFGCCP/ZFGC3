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
		
		LookupsService.getLkupValue = function(lookup,id){
			if(lookup && lookup !== null && id && id !== null){
				for(var i = 0; i < lookup.length; i++){
					if(lookup[i].id === id){
						return lookup[i].value;
					}
				}
			}
			
			return "";
		};
		
		return LookupsService;
		
	}
	
	angular
		.module('zfgc.forum')
		.service('LookupsService', ['$resource',LookupsService])
})();