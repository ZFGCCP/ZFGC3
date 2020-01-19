(function(){
	'use strict';
	
	function ForumService($resource){
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
		};
		
		return ForumService;
	}
	
	angular
		.module('zfgc.forum')
		.service('ForumService', ['$resource',ForumService])
})();