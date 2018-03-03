(function(){
	
	function ConvoBoxCtrl($scope, PmService, ConvoBoxService){
		var vm = this;
		
		vm.stripHtml = function(text){
			return ConvoBoxService.stripHtml(text);
		};
		
		vm.convoBox = PmService.getConvoBox();
	}
	
	angular.module('zfgc.pm')
		   .controller('ConvoBoxCtrl',['$scope','PmService','ConvoBoxService',ConvoBoxCtrl])
	
})();