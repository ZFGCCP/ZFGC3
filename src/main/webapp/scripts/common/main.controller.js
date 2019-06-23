(function(){
	
	function MainCtrl($rootScope){
		var vm = this;
		vm.hideContainer = false;
		
		$rootScope.$on("WhosOnlineDetailsToggled", function(ev, params){
			vm.hideContainer = params;
		});
	}
	
	angular.module('zfgc.forum')
		   .controller('MainCtrl', ['$rootScope', MainCtrl]);
	
})();