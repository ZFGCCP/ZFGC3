(function(){
	'use strict';
	
	function RegistrationCtrl(LookupsService, UserService){
		var vm = this;
		vm.user = {};
		vm.somevalue = 'swipe all day';
		
		vm.lookups = LookupsService.getLookupsList("TIMEZONE");
		
		vm.pubKey = "6Lde4o4UAAAAAI0Nkg5Gymqa6l3o9Is7g9-0OYOn";
		
		vm.getCurrentTimeZone = function(){
			var tz = jstz.determine();
		    return tz.name();
		};
		
		console.log(vm.getCurrentTimeZone());
		
		vm.getUserTemplate = function(){
			vm.user = UserService.getNewUserTemplate();
		};
		
		vm.user = vm.getUserTemplate();
		
		vm.getCurrentTimeZoneId = function(){
			var tz = vm.getCurrentTimeZone();
			for(var i = 0; i < vm.lookups.TIMEZONE.length; i++){
				if(vm.lookups.TIMEZONE[i].value === tz){
					return vm.lookups.TIMEZONE[i].id;
				}
			}
		};
		
		vm.newUser= function(){
			vm.setDisplayNameOnSubmit();
			var registered = UserService.register(vm.user);
			
			if(registered !== null){
				registered.$promise.then(function(data){
					
				});
			}
		};
		
		vm.setDisplayNameOnSubmit = function(){
			if(!vm.user.displayName || vm.user.displayName === null || vm.user.displayName === ""){
				vm.user.displayName = vm.user.loginName;
			}
		};
		
		vm.lookups.$promise.then(function(data){
			vm.user.timeOffset= vm.getCurrentTimeZoneId();
		});
	}
	
	angular
		.module('zfgc.users')
		.controller('RegistrationCtrl', ['LookupsService','UserService', RegistrationCtrl])
})();