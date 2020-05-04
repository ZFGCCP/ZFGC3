(function(){
	'use strict';
	
	function combobox(){
		var directive = {};
		directive.restrict = 'E';
		directive.transclude = true;
		directive.templateUrl = "scripts/directives/combobox/combobox.directive.html";
		directive.controller = function($scope){
			var cvm = this;
			cvm.transcludedContent = [];
			
			cvm.addTranscludedContent = function(transcludeId, transcludeContent){
				cvm.transcludedContent.push({id : transcludeId, content: transcludeContent});
			};
			
			cvm.selectItem = function(selectedId, selectedValue){
				cvm.selectedId = selectedId;
				cvm.selectedValue = selectedValue;
				
				cvm.selectedContent = cvm.transcludedContent.filter(function(item){
					return item.id === cvm.selectedId;
				})[0];
				
				cvm.closeDropdown();
			};
			
			cvm.closeDropdown = function(){
				$scope.toggleDropdown();
			};
		},
		directive.scope = {
				id: '@',
				ngModel: '=',
				tabIndex: '@'
		}

		directive.link = function ($scope, element, attrs, cvm) 
		{ 
			$scope.isOpen = false;
			$scope.showInput = false;
			$scope.groupId = $scope.id;
			
			$scope.cvm = cvm;
			
			$scope.$watch('cvm.selectedId', function(newValue){
				$scope.ngModel = newValue;

				angular.element(element[0].getElementsByClassName('selected-content')).html(cvm.selectedContent.content);
			});
			
			$scope.toggleDropdown = function(event){
				$scope.isOpen = !$scope.isOpen;
				$scope.showInput = !$scope.showInput;
			};
		};
		
		return directive;
	};
	
	angular
	       .module("zfgc.forum")
	       .directive("combobox", combobox);
})();