(function(){
	
	function BoardController($scope, $location, $transitions, ForumService){
		var vm = this;
		
		vm.getBoard = function(){
			var boardId = $location.search().boardId;
			ForumService.getBoard(vm, boardId, $scope);
		};
		
		vm.deregisterTransition = $transitions.onStart({}, function(transition) {
			/*vm.usersViewingSub.unsubscribe();
			vm.usersViewingSub = null;
			vm.deregisterTransition();*/
		});
		
		vm.threadChecked = function(){
			vm.checked = false
			for(var i = 0; i < vm.board.threads.length; i++){
				if(vm.board.threads[i].isChecked){
					vm.checked = true;
					return;
				}
			}
				
			if(vm.checked === false){
				for(var i = 0; i < vm.board.stickyThreads.length; i++){
					if(vm.board.stickyThreads[i].isChecked){
						vm.checked = true;
						break;
					}
				}	
			}
		};
		
		function getCheckedThreads(threads){
			var threadIds = threads.map(function(x){
				if(x.isChecked === true){
					return x.threadId;
				}
			});

			return threadIds;
		}
		
		vm.stickyUnstickyThreads = function(){
			var threadIds = getCheckedThreads(vm.board.threads);
			var stickyThreadIds = getCheckedThreads(vm.board.stickyThreads);
			
			threadIds = threadIds.concat(stickyThreadIds);
			
			ForumService.stickyUnstickyThreads(vm, vm.board.forumId, threadIds);
		};
		
		vm.lockUnlockThreads = function(){
			var threadIds = getCheckedThreads(vm.board.threads);
			var stickyThreadIds = getCheckedThreads(vm.board.stickyThreads);
			
			threadIds = threadIds.concat(stickyThreadIds);
			
			ForumService.lockUnlockThreads(vm, vm.board.forumId, threadIds);
		};
		
		vm.goToThreadMove = function(){
			ForumService.goToThreadMove(vm);
		};
		
		vm.getBoard();
		
		vm.checkedThreads = {};
		
	}
	
	angular.module('zfgc.forum')
		   .controller("BoardCtrl",['$scope', '$location', '$transitions', 'ForumService', BoardController]);
	
})();