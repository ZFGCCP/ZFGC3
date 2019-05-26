(function(){
	
	function CalendarService($resource){
		var CalendarService = {};
		
		CalendarService.resource = $resource('/forum/calendar',{viewTypeId : '@viewTypeId'},
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
		
		CalendarService.getToday = function(){
			var today = new Date();
			var mm = today.getMonth() + 1; // getMonth() is zero-based
			var dd = today.getDate();

			return [(mm>9 ? '' : '0') + mm,
					(dd>9 ? '' : '0') + dd,
					today.getFullYear()
		         ].join('/');
		};
		
		CalendarService.changeDate = function(vm, date){
			if(date.date !== null){
				vm.calendar.selectedDate = date;
				
				//set the selected param
				vm.calendar.weeks.forEach(function(week){
					week.daysOfWeek.forEach(function(day){
						day.isSelected = false;
					});
				});
				
				date.isSelected = true;
			}
		};
		
		return CalendarService;
	}
	
	angular.module("zfgc.calendar")
		   .service('CalendarService', ['$resource', CalendarService]);
	
})();