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
		
		ForumService.getBoard = function(vm, boardId, scope){
			vm.board = ForumService.resource.get({forumId : boardId, itemsPerPage : 10, pageNo : 1});
			vm.usersViewingSub = WebsocketService.subscribe("/socket/viewingForum/" + boardId,
					function(data){
						vm.viewingUsers = JSON.parse(data.body);
						scope.$digest();
					});
			vm.board.$promise.then(function(data){
				
			});
		};
		
		return ForumService;
	}
	
	angular
		.module('zfgc.forum')
		.service('ForumService', ['$resource','WebsocketService',ForumService])
})();