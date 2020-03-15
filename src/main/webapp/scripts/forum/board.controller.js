(function(){
	
	function BoardController($scope, $location, $transitions, ForumService){
		var vm = this;
		
		vm.getBoard = function(){
			var boardId = $location.search().boardId;
			ForumService.getBoard(vm, boardId, $scope);
		};
		
		vm.deregisterTransition = $transitions.onStart({}, function(transition) {
			vm.usersViewingSub.unsubscribe();
			vm.usersViewingSub = null;
			vm.deregisterTransition();
		});
		
		vm.getBoard();
		
	}
	
	angular.module('zfgc.forum')
		   .controller("BoardCtrl",['$scope', '$location', '$transitions', 'ForumService', BoardController]);
	
})();