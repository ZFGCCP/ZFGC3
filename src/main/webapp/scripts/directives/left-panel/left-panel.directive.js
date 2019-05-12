(function(){
	'use strict';
	
	function LeftPanel(CalendarService){
		var directive = {};
		directive.restrict = 'E';
		directive.templateUrl = "scripts/directives/left-panel/left-panel.directive.html";
		directive.scope = {
				
		}

		directive.link = function ($scope, element, attrs) {
			
		}
		
		return directive;
	}
	
	angular.module("zfgc.forum")
		   .directive("leftPanel", ['CalendarService', LeftPanel]);
	
})();