(function(){
	'use strict';
	
	function MessageEditor(PmService){
		var directive = {};
		directive.restrict = 'E';
		directive.templateUrl = "scripts/directives/forms/message-editor/message-editor.directive.html";
		directive.scope = {
				ngModel:'='
		}

		directive.link = function ($scope, element, attrs) {
			$scope.getLastCursorPos = function(){
				PmService.getLastCursorPos(vm);
			};
			
			$scope.insertShortcut = function(shortcut){
				PmService.insertShortcut(vm,shortcut);
			};
		}
	}
	
	
	
})();