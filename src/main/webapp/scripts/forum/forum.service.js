(function(){
	'use strict';
	
	function ForumService($resource){
		var ForumService = {};
		
		ForumService.resource = $resource('/forum/forum/index', {},
		{
			ForumIndex:{
			         url: '/forum/forum/index',
			         method: 'GET'
			}
		});
		
		return ForumService;
	}
	
	angular
		.module('zfgc.forum')
		.service('ForumService', ['$resource',ForumService])
})();