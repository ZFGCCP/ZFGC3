(function(){
	
	function searchCtrl(UserSearchService){
		var vm = {};
		
		vm.doSimpleUserSearch = function(query, start, length){
			var results = UserSearchService.performSearch(query, start, length);
		}
	}
	
	angular.module('zfgc.forum')
		   .controller('SearchCtrl', ['UserSearchService',searchCtrl]);
	
})();