(function(){
	'use strict';
	
	function UsersCtrl(LookupsService, UserService, $location){
		var vm = this;
		UserService.loadProfile($location.search().userId,vm);
		
		vm.lookups = LookupsService.getLookupsList("MEMBER_GROUP");
		
		vm.tabClick = function(tab, subTab){
			UserService.setTabActive(vm,tab, subTab);
		};
		
		vm.saveAccountSettings = function(){
			UserService.saveAccountSettings(vm);
		};
	}
	
	angular
		.module('zfgc.users')
		.controller('UsersCtrl', ['LookupsService','UserService','$location', UsersCtrl])
})();