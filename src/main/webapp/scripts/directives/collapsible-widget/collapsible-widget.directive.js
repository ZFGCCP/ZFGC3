(function(){
	'use strict';
	
	function collapsibleWidget(){
		var directive = {};
		directive.restrict = 'E';
		directive.transclude = true;
		directive.templateUrl = "scripts/directives/collapsible-widget/collapsible-widget.html";
		directive.scope = {
				widgetTitle :"@",
		}

		directive.link = function ($scope, element, attrs) 
		{ 
			$scope.isCollapsed = false;
			
			$scope.toggle = function(){
				$scope.isCollapsed = !$scope.isCollapsed;
			};
		};;
		
		return directive;
	};
	
	angular
	       .module("zfgc.forum")
	       .directive("collapsibleWidget", collapsibleWidget);
})();