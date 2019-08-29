(function(){
	'use strict';
	
	function eventList(){
		var directive = {};
		directive.restrict = 'E';
		directive.transclude = true;
		directive.templateUrl = "scripts/directives/event-list/event-list.directive.html";
		directive.scope = {
				events: '='
		}

		directive.link = function ($scope, element, attrs) 
		{ 
			
		};
		
		return directive;
	};
	
	angular
	       .module("zfgc.calendar")
	       .directive("eventList", eventList);
})();