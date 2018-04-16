(function(){
	
	function ConvoBoxCtrl($scope, PmService, ConvoBoxService){
		var vm = this;
		
		vm.filters = {'filterBy' : -1};
		vm.filterOptions = [{'id': -1, 'value': 'All Messages'},{'id' : 0, 'value':'Inbox'},{'id':1,'value':'Outbox'},{'id':2,'value':'Archived'}];
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
		
		vm.convoBox = PmService.getConvoBox();
	}
	
	angular.module('zfgc.pm')
		   .controller('ConvoBoxCtrl',['$scope','PmService','ConvoBoxService',ConvoBoxCtrl])
	
})();