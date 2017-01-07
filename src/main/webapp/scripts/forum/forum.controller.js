(function(){
	'use strict';
	
	function ForumController(LookupsService, UserService, ForumService){
		var vm = this;
		vm.categories = [];
		
		vm.logIndex = function(){
			ForumService.resource.ForumIndex().$promise.then(function(data){
				vm.categories=data.categories;
				console.log(data);
			});
		};
		vm.logIndex();
	}
	
	angular
		.module('zfgc.forum')
		.controller('ForumController', ['LookupsService','UserService', 'ForumService', ForumController])
})();