(function(){
	
	function BoardController($scope, $location, ForumService){
		var vm = this;
		
		vm.getBoard = function(){
			var boardId = $location.search().boardId;
			ForumService.getBoard(vm, boardId, $scope);
		};
		
		$scope.$on('$locationChangeStart', function( event ) {
			//vm.usersViewingSub.unsubscribe();
		});
		
		vm.getBoard();
		
	}
	
	angular.module('zfgc.forum')
		   .controller("BoardCtrl",['$scope', '$location', 'ForumService', BoardController]);
	
})();