(function(){
	'use strict';
	
	function UsersCtrl(LookupsService){
		var vm = this;
		vm.somevalue = 'swipe all day';
		
		vm.lookups = LookupsService.getLookupsList("TIMEZONE");
	}
	
	angular
		.module('zfgc.users')
		.controller('UsersCtrl', ['LookupsService',UsersCtrl])
})();