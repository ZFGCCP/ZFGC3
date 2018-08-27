(function(){
	
	function PruneConvoCtrl(PmService, NotificationsService, $state,params){
		var vm = this;
		
		vm.prune = PmService.resource.pruneTemplate();
		
		vm.pruneConvos = function(){
			PmService.pruneConversations(vm).$promise.then(function(){
				params.modal.close();
				NotificationsService.addAlert('Conversations Pruned Successfully','success');
				$state.reload();
			});
		};
	}
	
	angular.module('zfgc.pm')
		   .controller('PruneConvoCtrl',['PmService','NotificationsService','$state','params',PruneConvoCtrl]);
	
})();