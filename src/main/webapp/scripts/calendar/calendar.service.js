(function(){
	
	function CalendarService($resource){
		var CalendarService = {};
		
		CalendarService.resource = $resource('/forum/calendar',{},
		{
			upcomingEvents : {
				url : '/forum/calendar/upcoming',
				method : 'GET',
				isArray: true
			},
			upcomingBirthdays : {
				url : '/forum/calendar/birthday',
				method : 'GET',
				isArray : true
			}
		});
		
		return CalendarService;
	}
	
	angular.module("zfgc.calendar")
		   .service('CalendarService', ['$resource', CalendarService]);
	
})();