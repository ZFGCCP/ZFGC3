(function(){
	
	function CalendarViewCtrl(CalendarService){
		var vm = this;
		
		vm.calendar = CalendarService.resource.get({'viewTypeId' : 0, 'startingDt' : '05/18/2019'});
		
		vm.calendar.$promise.then(function(data){
			console.log(vm.calendar);
		});
	}
	
	angular.module('zfgc.calendar')
		   .controller('CalendarViewCtrl', ['CalendarService', CalendarViewCtrl]);
	
})();