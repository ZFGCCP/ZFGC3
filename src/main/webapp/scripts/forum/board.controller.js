(function(){
	
	function BoardController($location, ForumService){
		var vm = this;
		
		vm.getBoard = function(){
			var boardId = $location.search().boardId;
			ForumService.getBoard(vm, boardId);
		};
		
		vm.getBoard();
		
	}
	
	angular.module('zfgc.forum')
		   .controller("BoardCtrl",['$location', 'ForumService', BoardController]);
	
})();