(function(){
	'use strict';
	
	function comboboxItem(){
		var directive = {};
		directive.restrict = 'E';
		directive.transclude = true;
		directive.templateUrl = "scripts/directives/combobox-item/combobox-item.directive.html";
		directive.require = '^combobox',
		directive.scope = {
				textValue : '@',
				idValue : '='
		}

		directive.link = function ($scope, element, attrs, cvm, transclude) 
		{ 
			$scope.cvm = cvm;
			
			transclude($scope, function(clone) {
				$scope.cvm.addTranscludedContent($scope.idValue, clone);
	        });
		};
		
		return directive;
	};
	
	angular
	       .module("zfgc.forum")
	       .directive("comboboxItem", comboboxItem);
})();