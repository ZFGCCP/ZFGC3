(function(){
	
	function userSearchService($resource){
		var searchService = {};
		
		searchService.resource = $resource('/forum/search/simpleUserSearch',{'query' : '@query', 'start' : '@start', 'length' : '@length'},{
			simpleSearch : {
				url : '/forum/search/simpleUserSearch',
				method : 'POST',
				isArray : true
			}
		});
		
		searchService.performSearch = function(searchQuery, start, length){
			var results = searchService.resource.simpleSearch({
				'query' : searchQuery,
				'start' : start,
				'length' : length
			});
			
			return results;
		};
		
		return searchService;
	}
	
	angular.module('zfgc.forum')
		   .service('UserSearchService', ['$resource', userSearchService]);
	
})();