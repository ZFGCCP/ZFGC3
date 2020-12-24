(function(){
	
	function newThreadCtrl($location, $state, MessageEditorService){
		var vm = this;
		
		vm.getConstants = function(){
			return MessageEditorService.pmConstants;
		};
		
		vm.newThread = MessageEditorService.getThreadTemplate($location.search().boardId);
		
		vm.returnToBoard = function(){
			var boardId = $location.search().boardId;
			
			$state.go('board',{boardId: boardId});
		};
		
		vm.previewThread = function(){
			vm.previewThread = MessageEditorService.getThreadPreview(vm.newThread);
			
			vm.previewThread.$promise.then(function(data){
				vm.preview = true;
			});
		};
		
		vm.postThread = function(){
			MessageEditorService.saveThread(vm.newThread).$promise.then(function(data){
				
			});
		}
		
		vm.isOpen = false;
		
	}
	
	angular.module('zfgc.forum')
		   .controller('newThreadCtrl', ['$location', '$state', 'MessageEditorService', newThreadCtrl]);
	
})();