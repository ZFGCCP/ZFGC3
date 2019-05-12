(function(){
	'use strict';
	
	function LeftPanel(CalendarService){
		var directive = {};
		directive.restrict = 'E';
		directive.templateUrl = "scripts/directives/left-panel/left-panel.directive.html";
		directive.scope = {
				
		}

		directive.link = function ($scope, element, attrs) {
			$scope.events = CalendarService.resource.upcomingEvents();
			$scope.birthdays = CalendarService.resource.upcomingBirthdays();
			$scope.accordions = {};
			
			$scope.accordions.events = false;
			$scope.accordions.birthdays = false;
		}
		
		return directive;
	}
	
	angular.module("zfgc.forum")
		   .directive("leftPanel", ['CalendarService', LeftPanel]);
	
})();