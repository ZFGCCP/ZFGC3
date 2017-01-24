(function(){
	'use strict';
	
	function collapsibleWidget(){
		var directive = {};
		directive.restrict = 'E';
		directive.transclude = true;
		directive.templateUrl = "scripts/directives/collapsible-widget/collapsible-widget.html";
		directive.scope = {
				widgetId :"@",
				widgetTitle :"@",
				templateUrl :"@",
				contentModel : "="
		}

		directive.link = function ($scope, element, attrs) 
		{ 
			$scope.vm = $scope.contentModel;
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