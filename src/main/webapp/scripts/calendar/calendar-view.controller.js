(function(){
	
	function CalendarViewCtrl(CalendarService){
		var vm = this;
		vm.params = {};
		
		vm.params.date = CalendarService.getToday();
		
		vm.calendar = CalendarService.resource.get({'viewTypeId' : 0, 'startingDt' : vm.params.date});
		vm.showDayDetails = false;
		
		vm.changeDate = function(date){
			CalendarService.changeDate(vm, date);
			vm.toggleDayDetails();
		};
		
		vm.toggleDayDetails = function(){
			vm.showDayDetails = !vm.showDayDetails;
		};
		
		vm.calendar.$promise.then(function(data){
			vm.changeDate(data.selectedDate);
		});
		
		vm.changeMonth = function(interval){
			var month = vm.calendar.monthIndex;
			var year = vm.calendar.year;
			month += interval;
			
			if(month <= 0){
				month = 12;
				year--;
			}
			else if(month >= 13){
				month = 1;
				year++;
			}
			
			vm.updateMonth(month, year);
		};
		
		vm.updateMonth = function(month, year){
			vm.calendar = CalendarService.getMonth(month, year);
		};
	}
	
	angular.module('zfgc.calendar')
		   .controller('CalendarViewCtrl', ['CalendarService', CalendarViewCtrl]);
	
})();