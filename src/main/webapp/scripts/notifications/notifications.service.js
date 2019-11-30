(function(){
	'use strict';
	
	function NotificationsService($rootScope,$resource){
		var notificationsService = {};
		
		notificationsService.resource = $resource('/forum/subscriptions/',
		{
		 'userId' : '@userId',
		 'pageNo' : '@pageNo',
		 'itemsPerPage' : '@itemsPerPage'
		},
		{
			getThreadSubs :{
				url:'/forum/subscriptions/threads/:userId',
				method:'GET'
			}
		});
		
		notificationsService.getThreadSubs = function(userId, pageNo, itemsPerPage){
			return notificationsService.resource.getThreadSubs({'userId' : userId, 'pageNo' : pageNo, 'itemsPerPage' : itemsPerPage});
		};
		
		notificationsService.addSuccessAlert = function(message){
			notificationsService.addAlert(message, "success");
		};
		
		notificationsService.addErrorAlert = function(message){
			notificationsService.addAlert(message, "error");
		};
		
		notificationsService.addInfoAlert = function(message){
			notificationsService.addAlert(message, "info");
		};
		
		notificationsService.addAlert = function(message,type){
			$rootScope.$broadcast('alertAdded',notificationsService.createAlert(message,type));
		};
		
		notificationsService.createAlert = function(message,type){
			var alert = {
				'message' : message,
				'type' : type
			};
			
			return alert;
		};
		
		return notificationsService;
	}
	
	angular.module('zfgc.notifications')
	       .service('NotificationsService',['$rootScope','$resource',NotificationsService]);
})();