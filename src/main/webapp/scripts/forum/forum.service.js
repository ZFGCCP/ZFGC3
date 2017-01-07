(function(){
	'use strict';
	
	function ForumService($resource){
		var ForumService = {};
		
		ForumService.resource = $resource('/forum/index', {},
		{
			ForumIndex:{
			         url: '/forum/index',
			         method: 'GET'
			}
		});
		
		return ForumService;
	}
	
	angular
		.module('zfgc.forum')
		.service('ForumService', ['$resource',ForumService])
})();