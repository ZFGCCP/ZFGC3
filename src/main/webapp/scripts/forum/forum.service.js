(function(){
	'use strict';
	
	function ForumService($resource, $state, NotificationsService, WebsocketService, ModalService){
		var ForumService = {};
		
		ForumService.resource = $resource('/forum/forum/:forumId', {'forumId' : '@forumId', 'itemsPerPage' : '@itemsPerPage', 'pageNo' : '@pageNo'},
		{
			ForumIndex:{
			         url: '/forum/forum/index',
			         method: 'GET'
			},
			threadTemplate: {
				url: '/forum/forum/:forumId/thread/template',
				method: 'GET'
			},
			stickyUnsticky: {
				url: '/forum/forum/:forumId/stickyUnsticky',
				method: 'POST'
			}
		});
		
		ForumService.stickyUnstickyThreads = function(vm, boardId, threadIds){
			var params = {boardId : boardId, threadIds : threadIds, vm: vm};
			ModalService.createConfirmDialog(null, "This will sticky/unsticky all selected threads.", ForumService.stickyUnstickyConfirm, params);
		};
		
		ForumService.stickyUnstickyConfirm = function(params){
			ForumService.resource.stickyUnsticky({forumId : params.boardId}, params.threadIds).$promise.then(function(data){
				//reload the board
				//todo: load in the user's current page no
				NotificationsService.addSuccessAlert("Threads stickied/unstickied successfully");
				params.vm.board = ForumService.resource.get({forumId : params.boardId, itemsPerPage : 10, pageNo : 1});
			});
		};
		
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
		
		ForumService.getThreadTemplate = function(boardId){
			return ForumService.resource.threadTemplate({forumId: boardId});
		};
		
		return ForumService;
	}
	
	angular
		.module('zfgc.forum')
		.service('ForumService', ['$resource','$state', 'NotificationsService', 'WebsocketService','ModalService',ForumService])
})();