(function(){
	'use strict';
	
	function NotificationsService($resource){
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
		
		return notificationsService;
	}
	
	angular.module('zfgc.notifications')
	       .service('NotificationsService',['$resource',NotificationsService]);
})();