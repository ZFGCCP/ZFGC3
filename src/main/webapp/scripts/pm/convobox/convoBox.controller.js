(function(){
	
	function ConvoBoxCtrl($scope, PmService, ConvoBoxService){
		var vm = this;
		
		vm.filters = {'filterBy' : -1};
		vm.filterOptions = [{'id': -1, 'value': 'All Messages'},{'id' : 0, 'value':'Inbox'},{'id':1,'value':'Outbox'}];
		
		vm.stripHtml = function(text){
			return ConvoBoxService.stripHtml(text);
		};
		
		vm.convoBox = PmService.getConvoBox();
	}
	
	angular.module('zfgc.pm')
		   .controller('ConvoBoxCtrl',['$scope','PmService','ConvoBoxService',ConvoBoxCtrl])
	
})();