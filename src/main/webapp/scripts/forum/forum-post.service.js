(function(){
	
	function ForumPostService(){
		var service = {};
		
		service.toggleMessageReply = function(messageListContainer){
			messageListContainer.showReplyBox = !messageListContainer.showReplyBox;
		};
		
		return service;
	}
	
	angular.module('zfgc.forum')
		   .service('ForumPostService',[ForumPostService]);
	
})();