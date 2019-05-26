(function(){
	
	function CalendarViewCtrl(CalendarService){
		var vm = this;
		vm.params = {};
		
		vm.params.date = CalendarService.getToday();
		
		vm.calendar = CalendarService.resource.get({'viewTypeId' : 0, 'startingDt' : vm.params.date});
		
		vm.changeDate = function(date){
			CalendarService.changeDate(vm, date);
		};
		
		vm.calendar.$promise.then(function(data){
			vm.changeDate(data.selectedDate);
		});
	}
	
	angular.module('zfgc.calendar')
		   .controller('CalendarViewCtrl', ['CalendarService', CalendarViewCtrl]);
	
})();