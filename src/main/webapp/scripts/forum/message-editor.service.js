(function(){
	
	function messageEditorService($resource, LookupsService){
		var service = {};
		
		service.threadResource = $resource('/forum/forum/:forumId/thread/template',{'forumId' : '@forumId'},{
			preview : {
				url : '/forum/forum/:forumId/thread/preview',
				method : 'POST'
			}
		});
		
		service.getThreadTemplate = function(forumId){
			return service.threadResource.get({forumId: forumId});
		};
		
		service.getThreadPreview = function(thread){
			return service.threadResource.preview({forumId: thread.parentForumId}, thread);
		};
		
		service.lookups = LookupsService.getLookupsList("BBCODE");
		
		service.pmConstants = {
				bbCodes : {
					bold : 1,
					italic : 2,
					underline : 3,
					strikethrough : 4
				}	
			};
		
		service.getLastCursorPos = function(vm){
			$timeout(function(){
				vm.currentCursorPos = vm.textArea[0].selectionStart;
			},100);
		};
		
		service.insertShortcut = function(cursor,message,shortcut){
			var workingMessage = message.slice(0,cursor) + 
								 service.getBbCodeFromLkup(service.lookups.BBCODE,shortcut) + 
								 message.slice(cursor);
			
			return workingMessage;
		};
		
		service.getBbCodeFromLkup = function(lookups,code){
			for(var i = 0; i < lookups.length;i++){
				if(lookups[i].id === code){
					return lookups[i].value;
				}
			}
			
			return null;
		};
		
		return service;
	}
	
	angular.module('zfgc.forum')
		   .service('MessageEditorService', ['$resource', 'LookupsService', messageEditorService]);
	
})();