(function(){
	
	function ConvoBoxCtrl($scope, PmService, ConvoBoxService){
		var vm = this;
		
		vm.filters = {'filterBy' : 0};
		vm.filterOptions = [{'id': 0, 'value': 'All Messages'},{'id' : 1, 'value':'Inbox'},{'id':2,'value':'Outbox'},{'id':3,'value':'Archived'}];
		vm.boxesSelected = false;
		
		vm.stripHtml = function(text){
			return ConvoBoxService.stripHtml(text);
		};
		
		vm.checkForCheckedBoxes = function(){
			ConvoBoxService.checkForCheckedBoxes(vm);
		};
		
		vm.newMessage = function(){
			ConvoBoxService.newMessage();
		};
		
		vm.archiveConversations = function(){
			ConvoBoxService.archiveConversations(vm);
		};
		
		vm.deleteConversations = function(){
			ConvoBoxService.deleteConversations(vm);
		};
		
		vm.getConversations = function(){
			vm.convoBox = ConvoBoxService.getConvoBox(vm);
		};

		vm.getConversations();
	}
	
	angular.module('zfgc.pm')
		   .controller('ConvoBoxCtrl',['$scope','PmService','ConvoBoxService',ConvoBoxCtrl])
	
})();