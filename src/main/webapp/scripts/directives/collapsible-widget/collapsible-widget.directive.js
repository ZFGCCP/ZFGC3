(function(){
	'use strict';
	
	function collapsibleWidget(){
		var directive = {};
		directive.restrict = 'E';
		directive.replace = true;
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
		};
		
		return directive;
	};
	
	angular
	       .module("zfgc.forum")
	       .directive("collapsibleWidget", collapsibleWidget);
})();