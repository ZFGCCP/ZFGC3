(function(){
	
	function PruneConvoCtrl(PmService, $state,params){
		var vm = this;
		
		vm.prune = PmService.resource.pruneTemplate();
		
		vm.pruneConvos = function(){
			PmService.pruneConversations(vm).$promise.then(function(){
				params.modal.close();
				$state.reload();
			});
		};
	}
	
	angular.module('zfgc.pm')
		   .controller('PruneConvoCtrl',['PmService','$state','params',PruneConvoCtrl]);
	
})();