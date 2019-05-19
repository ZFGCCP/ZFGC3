(function(){
	
	function CalendarViewCtrl(CalendarService){
		var vm = this;
		vm.params = {};
		
		vm.params.date = CalendarService.getToday();
		
		vm.calendar = CalendarService.resource.get({'viewTypeId' : 0, 'startingDt' : vm.params.date});
	}
	
	angular.module('zfgc.calendar')
		   .controller('CalendarViewCtrl', ['CalendarService', CalendarViewCtrl]);
	
})();