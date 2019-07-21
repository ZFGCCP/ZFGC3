(function(){
	'use strict';
	
	function RegistrationCtrl($timeout, $state, $q, LookupsService, UserService){
		var vm = this;
		vm.complete = false;
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
		
		vm.registrationFieldsComplete = function(){
			return UserService.registrationFieldsComplete(vm, vm.user);
		};
		
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
			var registered = UserService.register(vm, vm.user);
			
			if(registered !== null){
				registered.$promise.then(function(data){
					vm.complete = true;
					$timeout(function(){
						$state.go('forum');
					}, 5000);
				});
			}
		};
		
		vm.setDisplayNameOnSubmit = function(){
			if(!vm.user.displayName || vm.user.displayName === null || vm.user.displayName === ""){
				vm.user.displayName = vm.user.loginName;
			}
		};
		
		vm.getUserTemplate();
		
		$q.all([vm.lookups.$promise,vm.user.$promise]).then(function(){
			vm.user.timeOffset= vm.getCurrentTimeZoneId();
		});
	}
	
	angular
		.module('zfgc.users')
		.controller('RegistrationCtrl', ['$timeout','$state','$q','LookupsService','UserService', RegistrationCtrl])
})();