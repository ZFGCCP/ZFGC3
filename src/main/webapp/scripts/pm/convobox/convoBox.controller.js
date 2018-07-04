(function(){
	
	function ConvoBoxCtrl($scope, $state, PmService, ConvoBoxService){
		var vm = this;
		
		vm.filters = {'filterBy' : 0, 'sortBy' : 0};
		vm.filterOptions = [{'id': 0, 'value': 'All Messages'},{'id' : 1, 'value':'Inbox'},{'id':2,'value':'Outbox'},{'id':3,'value':'Archived'}];
		vm.sortOptions = [{'id' : 0, 'value' : 'Latest Message'},{'id' : 1, 'value' : 'Started Date'},{'id' : 2, 'value' : 'Started By'},{'id' : 3, 'value' : 'Last Message By'},{'id' : 4, 'value' : 'Subject'}];
		vm.boxesSelected = false;
		vm.prune = {};
		
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
		
		vm.prune = function(){
			PmService.openPruneDialog(vm);
		};
		
		vm.sortConversations = function(){
			PmService.sortMessages(vm);
		};

		vm.getConversations();
	}
	
	angular.module('zfgc.pm')
		   .controller('ConvoBoxCtrl',['$scope','$state','PmService','ConvoBoxService',ConvoBoxCtrl])
	
})();