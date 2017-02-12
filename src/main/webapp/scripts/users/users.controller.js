(function(){
	'use strict';
	
	function UsersCtrl(LookupsService, UserService, $location){
		var vm = this;
		UserService.loadProfile($location.search().userId,vm);
		
		vm.lookups = LookupsService.getLookupsList("MEMBER_GROUP,AVATAR_TYPE,AVATAR_GALLERY,GENDER");
		
		vm.tabClick = function(tab, subTab){
			UserService.setTabActive(vm,tab, subTab);
		};
		
		vm.saveAccountSettings = function(){
			UserService.saveAccountSettings(vm);
		};
		
		vm.saveForumProfile = function(){
			UserService.saveForumProfile(vm);
		};
		
		vm.getAvatarUrl = function(){
			if(vm.profile && vm.profile !== null){
				return UserService.getAvatarUrl(vm.profile.avatar);
			}
		};
	}
	
	angular
		.module('zfgc.users')
		.controller('UsersCtrl', ['LookupsService','UserService','$location', UsersCtrl])
})();