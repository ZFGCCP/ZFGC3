(function(){
	
	function PruneConvoCtrl(PmService){
		var vm = this;
		
		vm.prune = PmService.resource.pruneTemplate();
		
		vm.pruneConvos = function(){
			PmService.pruneConversations(vm);
		};
	}
	
	angular.module('zfgc.pm')
		   .controller('PruneConvoCtrl',['PmService',PruneConvoCtrl]);
	
})();