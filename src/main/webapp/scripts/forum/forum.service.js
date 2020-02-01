(function(){
	'use strict';
	
	function ForumService($resource, WebsocketService){
		var ForumService = {};
		
		ForumService.resource = $resource('/forum/forum/:forumId', {'forumId' : '@forumId', 'itemsPerPage' : '@itemsPerPage', 'pageNo' : '@pageNo'},
		{
			ForumIndex:{
			         url: '/forum/forum/index',
			         method: 'GET'
			}
		});
		
		ForumService.getBoard = function(vm, boardId){
			vm.board = ForumService.resource.get({forumId : boardId, itemsPerPage : 10, pageNo : 1});
			vm.usersViewingSub = WebsocketService.subscribe("/socket/viewingForum/" + boardId, vm.updateWhosViewing);
			vm.board.$promise.then(function(data){
				WebsocketService.send("/usersocket/updateUserAction", "2:" + boardId);
				
			});
		};
		
		return ForumService;
	}
	
	angular
		.module('zfgc.forum')
		.service('ForumService', ['$resource','WebsocketService',ForumService])
})();