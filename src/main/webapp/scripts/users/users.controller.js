(function(){
	'use strict';
	
	function UsersCtrl(LookupsService){
		var vm = this;
		vm.somevalue = 'swipe all day';
		
		vm.lookups = LookupsService.getLookupsList("TIMEZONE");
		
		vm.getCurrentTimeZone = function(){
			var tz = jstz.determine();
		    return tz.name();
		};
		
		console.log(vm.getCurrentTimeZone());
		
		vm.getCurrentTimeZoneId = function(){
			var tz = vm.getCurrentTimeZone();
			for(var i = 0; i < vm.lookups.TIMEZONE.length; i++){
				if(vm.lookups.TIMEZONE[i].value === tz){
					return vm.lookups.TIMEZONE[i].id;
				}
			}
		};
		
		vm.lookups.$promise.then(function(data){
			//sample usage
			console.log(vm.getCurrentTimeZoneId());
		});
	}
	
	angular
		.module('zfgc.users')
		.controller('UsersCtrl', ['LookupsService',UsersCtrl])
})();