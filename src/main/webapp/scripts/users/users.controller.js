(function(){
	'use strict';
	
	function UsersCtrl(LookupsService, UserService, $location){
		var vm = this;
		UserService.loadProfile($location.search().userId,vm);
		UserService.getProfileNavigationTabs(vm);
		
		vm.tabClick = function(tab){
			UserService.setTabActive(vm,tab);
		};
	}
	
	angular
		.module('zfgc.users')
		.controller('UsersCtrl', ['LookupsService','UserService','$location', UsersCtrl])
})();