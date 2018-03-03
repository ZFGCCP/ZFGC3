(function(){
	
	function ConvoBoxCtrl($scope, PmService){
		var vm = this;
		
		vm.convoBox = PmService.getConvoBox();
	}
	
	angular.module('zfgc.pm')
		   .controller('ConvoBoxCtrl',['$scope','PmService',ConvoBoxCtrl])
	
})();