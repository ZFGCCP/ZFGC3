(function(){
	'use strict';
	
	function avatarGallery(){
		var directive = {};
		directive.restrict = 'E';
		directive.transclude = true;
		directive.templateUrl = "scripts/directives/avatar-gallery/avatar-gallery.html";
		directive.scope = {
				avatarList :"=",
				avatarGalleryId : "="
		}

		directive.link = function ($scope, element, attrs) 
		{ 
			$scope.selectedIndex = -1;
			
			$scope.highlightAvatar = function(index){
				$scope.selectedIndex = index;
				$scope.avatarGalleryId = $scope.avatarList[index].id;
			};
		};
		
		return directive;
	};
	
	angular
	       .module("zfgc.forum")
	       .directive("avatarGallery", avatarGallery);
})();