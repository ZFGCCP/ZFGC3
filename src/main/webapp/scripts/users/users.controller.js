(function(){
	'use strict';
	
	function UsersCtrl(LookupsService, UserService, $scope,$location,$sce,$window, ModalService, FileUploader, ServerConfigService, NotificationsService){
		var vm = this;
		UserService.loadProfile($location.search().userId,vm, $scope);
		
		vm.lookups = LookupsService.getLookupsList("MEMBER_GROUP,AVATAR_TYPE,AVATAR_GALLERY,GENDER,NOTIFICATION_FREQUENCY,LKUP_RECEIVE_MESSAGES,LKUP_PM_NOTIF");
		vm.getLkupValue = LookupsService.getLkupValue;
		
		vm.uploader = new FileUploader({
			url : 'http://localhost:8080/forum/contentstream/avatar/81',
			autoUpload: true,
			alias: 'avatarFile'
		});
		
		vm.uploader.onBeforeUploadItem = function(item){
			vm.savingAvatar = true;
		};
		
		vm.uploader.onSuccessItem = function(fileItem, response, status, headers) {
			vm.profile.stagedAvatar = response;

			NotificationsService.addSuccessAlert("successfully uploaded avatar");
		}
		
		vm.uploader.onErrorItem = function(fileItem, response, status, headers) {
			vm.profile.stagedAvatar = response;

			var message = "";
			for(var i = 0; i < response.validationErrors.length; i++){
				message += response.validationErrors[i].errorMessage + "\n";
			}
			
			NotificationsService.addErrorAlert(message);
		}
		
		vm.uploader.onCompleteItem = function(fileItem, response, status, headers){
			vm.savingAvatar = false;
		};
		
		vm.saveProfileDisabled = function(){
			return vm.savingAvatar;
		}
		
		vm.userActivation = function(){
			UserService.adminUserActivate(vm.profile.usersId);
		};
		
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
		
		vm.savePmSettings = function(){
			UserService.savePmSettings(vm);
		};
		
		vm.saveBuddyList = function(){
			UserService.saveBuddyList(vm);
		};
		
		vm.getAvatarUrlByUser = function(user){
			if(user && user !== null){
				return UserService.getAvatarUrl(user.personalInfo.avatar);
			}
		}
		
		vm.getAvatarUrl = function(){
			if(vm.profile && vm.profile !== null){
				return UserService.getAvatarUrl(vm.profile.personalInfo.avatar);
			}
		};
		
		vm.canEditRestrictedProfileField = function(){
			return UserService.canEditRestrictedProfileField(vm.profile.usersId);
		};
		
		vm.openUserTitleCard = function(user){
			ModalService.createTemplatedPopup('UserTitleCardCtrl','scripts/modal/templates/modalUserTitleCard.html', 'user-title-card-modal',{user : user});
		};
		
		vm.deleteBuddy = function(index){
			UserService.deleteBuddy(vm,index);
		};
		
		vm.deleteIgnore = function(index){
			UserService.deleteIgnore(vm,index);
		};
		
		vm.selectBuddy = function(buddy){
			UserService.addBuddy(vm,buddy);
		};
		
		vm.selectIgnore = function(buddy){
			UserService.addIgnore(vm,buddy);
		};
		
		vm.isUserAdmin = function(){
			return UserService.isUserAdmin(UserService.loggedInUser);
		};
		
		vm.isUserModerator = function(){
			return UserService.isUserModerator(UserService.loggedInUser);
		};
		
		vm.addMemberGroup = function(){
			vm.profile.secondaryMemberGroups.memberGroups.push({memberGroupId : vm.selectedMemberGroup});
		};
		
		vm.removeMemberGroup = function(index){
			vm.profile.secondaryMemberGroups.memberGroups.splice(index,1);
		};
		
		vm.canSendPmToUser = function(){
			return UserService.canSendPmToUser(vm);
		};
		
		vm.openNav = function(tab, showDetails){
			vm.tabDropdown = tab;
			vm.navOpen = !vm.navOpen;
			
			vm.showDetails = showDetails;
			vm.showNav = !showDetails;
		};
		
		vm.stageAvatar = function(){
			UserService.stageAvatar(vm);
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
		.controller('UsersCtrl', ['LookupsService','UserService','$scope','$location','$sce','$window', 'ModalService', 'FileUploader', 'ServerConfigService', 'NotificationsService', UsersCtrl])
})();