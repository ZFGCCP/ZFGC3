(function(){
	
	function threadCtrl($location, $state, MessageEditorService){
		var vm = this;
		
		vm.getConstants = function(){
			return MessageEditorService.pmConstants;
		};
		
		vm.newThread = {body: ""};
		
		vm.returnToBoard = function(){
			var boardId = $location.search().boardId;
			
			$state.go('board',{boardId: boardId});
		};
		
		vm.isOpen = false;
		
	}
	
	angular.module('zfgc.forum')
		   .controller('threadCtrl', ['$location', '$state', 'MessageEditorService', threadCtrl]);
	
})();