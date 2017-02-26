(function(){
	'use strict';
	
	function UsersCtrl(LookupsService, UserService, $scope,$location,$window){
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
		
		vm.saveNotificationSettings = function(){
			UserService.saveNotificationSettings(vm);
		};
		
		vm.getAvatarUrl = function(){
			if(vm.profile && vm.profile !== null){
				return UserService.getAvatarUrl(vm.profile.avatar);
			}
		};
		
		 var w = angular.element($window);
         w.bind('resize', function () {
             
             // Get window width
             $scope.windowWidth = "innerWidth" in window ? window.innerWidth : document.documentElement.offsetWidth;
             vm.showDropdown = false;
             // Change maxSize based on window width
             if($scope.windowWidth > 800) {
                 vm.max = 5;
             } else if($scope.windowWidth > 600) {
                 vm.max = 3;
             } else{
                 vm.max = 0;
                 vm.showDropdown = true;
             }
             $scope.$apply();
         });
		
		vm.max = 5;
		vm.total = 175;
		vm.showDropdown = false;
	}
	
	angular
		.module('zfgc.users')
		.controller('UsersCtrl', ['LookupsService','UserService','$scope','$location','$window', UsersCtrl])
})();