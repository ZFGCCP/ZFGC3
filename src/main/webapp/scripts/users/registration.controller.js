(function(){
	'use strict';
	
	function RegistrationCtrl(LookupsService, UserService){
		var vm = this;
		vm.somevalue = 'swipe all day';
		
		vm.lookups = LookupsService.getLookupsList("TIMEZONE,LANGUAGE");
		
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
		
		vm.newUser= function(){
			UserService.register(vm.user).$promise.then(function(data){
				
			});
			
		};
		
		
		vm.lookups.$promise.then(function(data){
			//sample usage
			vm.usertimezone= { id: vm.getCurrentTimeZoneId() };
		});
	}
	
	angular
		.module('zfgc.users')
		.controller('RegistrationCtrl', ['LookupsService','UserService', RegistrationCtrl])
})();